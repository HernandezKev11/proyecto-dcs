package com.proyecto.dcs;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class ProcesarAuto implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String tipoAuto = (String) delegateExecution.getVariable("tipoAuto");
        String subTipo = "";

        switch (tipoAuto){

            case "monoplaza":
                subTipo = "otro";

                break;
            case "sedan":
                subTipo = "otro";
                delegateExecution.setVariable("subTipo",subTipo);

                break;
            case "suburbanmini":
                subTipo = "suburban";
                break;

            case "suburbanplus":
                subTipo = "suburban";
                break;

            case "suburbanheavy":
                subTipo = "suburban";
                break;

        }

        delegateExecution.setVariable("subTipo",subTipo);
        System.out.println("-------------------------------------");
        System.out.println("EL TIPO DE AUTO ENTRANDO ES "+tipoAuto);



    }

}