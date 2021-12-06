package com.proyecto.dcs;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.feel.syntaxtree.In;

import javax.inject.Named;

@Named
public class ValidarDineroIngresado implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        int dineroIngresado = (Integer) delegateExecution.getVariable("dineroIngresado");
        int dineroPagar = (Integer) delegateExecution.getVariable("dineroPagar");

        if(dineroIngresado > dineroPagar){
            delegateExecution.setVariable("dineroCorrecto","true");
            System.out.println("El dinero ingresado para la subasta es correcto");
        }else{
            delegateExecution.setVariable("dineroCorrecto","false");
            System.out.println("El dinero ingresado de "+ dineroIngresado + " para la subasta es inferior a "+dineroPagar);
        }
    }

}
