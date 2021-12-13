package com.proyecto.dcs;

import com.proyecto.dcs.Solicitante.Solicitante;
import com.proyecto.dcs.Solicitante.SolicitanteRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named
public class AsignarAuto implements JavaDelegate {


    @Autowired
    SolicitanteRepository soliRepo;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {



        Long idSolicitante = (Long) delegateExecution.getVariable("idSolicitante");
        Solicitante soli =  soliRepo.findBySoliId(idSolicitante);


        soli.setEstadoSolicitud("Finalizado");
        soliRepo.updateSolicitante(soli);
        System.out.println("SE ENTREGO EL "+delegateExecution.getVariable("tipoAuto")+ " AL USUARIO "+soli.getCorreo() + " DEBE PAGAR "+soli.getDineroEntregado());



    }

}
