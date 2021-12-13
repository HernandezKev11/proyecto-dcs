package com.proyecto.dcs;

import com.proyecto.dcs.Solicitante.Solicitante;
import com.proyecto.dcs.Solicitante.SolicitanteRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Named
public class GuardarSolicitante implements JavaDelegate {


    @Autowired
    SolicitanteRepository soliRepo;


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String nombre = (String) delegateExecution.getVariable("nombreUsuario");
        String correo = (String) delegateExecution.getVariable("correoUsuario");
        String autoComprar = (String) delegateExecution.getVariable("autoSeleccionado");
        String dineroPagar = (String) delegateExecution.getVariable("dineroIngresado");

        Solicitante nuevoSoli = new Solicitante(nombre,correo,autoComprar,dineroPagar,"Pendiente", LocalDateTime.now());
        soliRepo.save(nuevoSoli);


    }

}
