package com.proyecto.dcs;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class ValidarSeleccion implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String autoSeleccionado = (String) delegateExecution.getVariable("autoSeleccionado");
        int cantidadDineroPagar = 0;
        String subTipo = "";


        switch (autoSeleccionado){

            case "monoplaza":
                subTipo = "otro";
                cantidadDineroPagar = 10000;
                delegateExecution.setVariable("dineroIngresado",cantidadDineroPagar);
                break;
            case "sedan":
                subTipo = "otro";
                cantidadDineroPagar = 25000;
                delegateExecution.setVariable("dineroIngresado",cantidadDineroPagar);
                break;
            case "suburbanmini":
                subTipo = "serban";
                cantidadDineroPagar = 38000;
                break;

            case "suburbanplus":
                subTipo = "suburban";
                cantidadDineroPagar = 45000;
                break;

            case "suburbanheavy":
                subTipo = "suburban";
                cantidadDineroPagar = 58000;
                break;

        }

        delegateExecution.setVariable("subTipoSeleccionado",subTipo);
        delegateExecution.setVariable("dineroPagar",cantidadDineroPagar);




    }
}
