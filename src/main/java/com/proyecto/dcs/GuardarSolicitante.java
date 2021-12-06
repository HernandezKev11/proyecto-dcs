package com.proyecto.dcs;

import com.proyecto.dcs.domain.Solicitante;
import com.proyecto.dcs.services.SolicitanteServicesImpl;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named
public class GuardarSolicitante implements JavaDelegate {


    SolicitanteServicesImpl servicio;

    public GuardarSolicitante(){
        servicio = new SolicitanteServicesImpl();
    }
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String nombre = (String) delegateExecution.getVariable("nombreUsuario");
        String correo = (String) delegateExecution.getVariable("correoUsuario");
        String autoComprar = (String) delegateExecution.getVariable("autoSeleccionado");
        int dineroPagar = (Integer) delegateExecution.getVariable("dineroIngresado");

        Solicitante nuevoSoli = new Solicitante(nombre,correo,autoComprar,dineroPagar,"Pendiente");
        System.out.println(nuevoSoli.toString());
        servicio.save(nuevoSoli);


    }

}
