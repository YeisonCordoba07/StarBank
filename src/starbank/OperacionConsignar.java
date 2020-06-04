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

    public OperacionConsignar(String nombreOperacion, Date fechaOperacion, Time hora, double valor) {
        super(nombreOperacion, fechaOperacion, hora);
        this.valorAConsignar = valor;//Revisar
    }

    public void buscarValor() {
        //busca dentro de otros el valor y lo guarda en valorAConsignar
    }

    @Override
    public String retornaStringOperacion() {
        String operacionString = "";
        operacionString += nombreOperacion + "\n";
        operacionString += fechaOperacion + "\n";
        operacionString += hora + "\n";
        operacionString += valorAConsignar;
        return operacionString;
    }
}
