package com.proyecto.dcs;

import com.proyecto.dcs.Solicitante.Solicitante;
import com.proyecto.dcs.Solicitante.SolicitanteRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;


@Named
public class SeleccionarPrimerPostor implements JavaDelegate {

    @Autowired
    SolicitanteRepository soliRepo;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Long idUno = (Long) delegateExecution.getVariable("postorUno");
        Long idDos = (Long) delegateExecution.getVariable("postorDos");

        Solicitante primerSoli = soliRepo.findBySoliId(idUno);
        Solicitante segundoSoli = soliRepo.findBySoliId(idDos);

        boolean isBefore = primerSoli.getFechaSolicitud().isBefore(segundoSoli.getFechaSolicitud());

        if(isBefore){
            delegateExecution.setVariable("idSolicitante",primerSoli.getId());

        }else{
            delegateExecution.setVariable("idSolicitante",segundoSoli.getId());
        }
    }
}
