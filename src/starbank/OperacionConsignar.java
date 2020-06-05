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
public class OperacionConsignar extends Operacion {

    private double valorAConsignar;

    public OperacionConsignar(String nombreOperacion, Date fechaOperacion, double valor) {
        super(nombreOperacion, fechaOperacion);
        this.valorAConsignar = valor;//Revisar
    }

    public void buscarValor() {
        //busca dentro de otros el valor y lo guarda en valorAConsignar
    }

    @Override
    public String retornaStringOperacion() {
        String operacionString = "";
        operacionString += "Operacion: "+nombreOperacion + "\n";
        operacionString += "Fecha: "+fechaOperacion + "\n";
        operacionString += "Valor consignado: "+valorAConsignar;
        return operacionString;
    }
}
