package com.proyecto.dcs;

import com.proyecto.dcs.Solicitante.Solicitante;
import com.proyecto.dcs.Solicitante.SolicitanteRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Named
public class BuscarMejorPostor implements JavaDelegate {

    @Autowired
    SolicitanteRepository soliRepo;


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        System.out.println("BUSCANDO MEJOR POSTOR DE "+delegateExecution.getVariable("tipoAuto"));

        List<Solicitante> solicitanteList = soliRepo.findAll();

        List<Solicitante> solisApostando = new ArrayList<>();

        for(int i =0; i < solicitanteList.size();i++){
            if(solicitanteList.get(i).getEstadoSolicitud().equals("Pendiente") && solicitanteList.get(i).getAutoBuscado().equals(delegateExecution.getVariable("tipoAuto"))){
                solisApostando.add(solicitanteList.get(i));
            }
        }

        if(solisApostando.size() == 0){

            delegateExecution.setVariable("solicitante","false");
            System.out.println("NO SE ENCONTRE NINGUN SOLICITANTE APOSTANDO POR UN "+delegateExecution.getVariable("tipoAuto"));
        }else{

            int indiceDelMayor = 0;
            Solicitante soliIgual = null;

            for (int x = 1; x < solisApostando.size(); x++) {
                if (Integer.parseInt(solisApostando.get(x).getDineroEntregado()) > Integer.parseInt(solisApostando.get(indiceDelMayor).getDineroEntregado())) {
                    indiceDelMayor = x;
                }
            }

            Solicitante soliMayor = solisApostando.get(indiceDelMayor);
            solisApostando.remove(indiceDelMayor);

            for (int x = 0; x < solisApostando.size(); x++) {
                if (Integer.parseInt(solisApostando.get(x).getDineroEntregado()) == Integer.parseInt(soliMayor.getDineroEntregado())) {
                    soliIgual = solisApostando.get(x);
                }
            }


            if(soliIgual != null){
                delegateExecution.setVariable("solicitante","true");
                delegateExecution.setVariable("postoresIguales","true");
                delegateExecution.setVariable("solisIguales",soliMayor.getCorreo()+" / "+soliMayor.getFechaSolicitud());
                System.out.println("Se encontraron 2 solicitantes apostando con la misma cantidad");
            }else{
                delegateExecution.setVariable("solicitante","true");
                delegateExecution.setVariable("postoresIguales","false");
                delegateExecution.setVariable("idSolicitante",soliMayor.getId());

                System.out.println("Se encontro solicitante");
            }
        }





    }

}
