package com.proyecto.dcs;

import com.proyecto.dcs.Solicitante.Solicitante;
import com.proyecto.dcs.Solicitante.SolicitanteRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.List;

@Named
public class BuscarPrimerSolicitante implements JavaDelegate {

    @Autowired
    SolicitanteRepository soliRepo;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        List<Solicitante> listaOficial = soliRepo.findAll();
        Solicitante soliEncontrado = null;


        for(int i =0; i < listaOficial.size();i++){

            if(listaOficial.get(i).getEstadoSolicitud().equals("Pendiente") && listaOficial.get(i).getAutoBuscado().equals(delegateExecution.getVariable("tipoAuto")) ){

                soliEncontrado = listaOficial.get(i);
                break;
            }
        }



        if(soliEncontrado == null){
            delegateExecution.setVariable("solicitante","false");
            System.out.println("No hay solicitante");
        }else{
            delegateExecution.setVariable("solicitante","true");
            delegateExecution.setVariable("idSolicitante",soliEncontrado.getId());

            System.out.println("Se encontro solicitante");
        }


    }

}
