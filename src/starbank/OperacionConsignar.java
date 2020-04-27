/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbank;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author YEISON
 */
public class OperacionConsignar extends Operacion{
    
    private double valorAConsignar;

    public OperacionConsignar(String nombreOperacion, Date fechaOperacion, Time hora, String otros) {
        super(nombreOperacion, fechaOperacion, hora, otros);
        this.valorAConsignar = Double.parseDouble(otros);//Revisar
    }
    
    public void buscarValor(){
        //busca dentro de otros el valor y lo guarda en valorAConsignar
    }
}
