package com.proyecto.dcs;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class BuscarPrimerSolicitante implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        System.out.println("ES SEDAN O MONO");
        delegateExecution.setVariable("solicitante","false");



    }

}
