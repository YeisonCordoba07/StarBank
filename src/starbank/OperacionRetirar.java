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
public class OperacionRetirar extends Operacion {

    private double valorARetirar;

    public OperacionRetirar(String nombreOperacion, Date fechaOperacion, Time hora, double valor) {
        super(nombreOperacion, fechaOperacion, hora);
        this.valorARetirar = valor;//Revisar
    }

    public void buscarValor() {
        //busca dentro de otros el valor y lo guarda en valorARetirar
    }

    @Override
    public String retornaStringOperacion() {
        String operacionString = "";
        operacionString += nombreOperacion + "\n";
        operacionString += fechaOperacion + "\n";
        operacionString += hora + "\n";
        operacionString += valorARetirar;
        return operacionString;
    }
}
