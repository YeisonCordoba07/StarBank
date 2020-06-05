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

    public OperacionRetirar(String nombreOperacion, Date fechaOperacion, double valor) {
        super(nombreOperacion, fechaOperacion);
        this.valorARetirar = valor;
    }

    public void buscarValor() {
        //busca dentro de otros el valor y lo guarda en valorARetirar
    }

    @Override
    public String retornaStringOperacion() {
        String operacionString = "";
        operacionString += "Operacion: "+nombreOperacion + "\n";
        operacionString += "Fecha: "+fechaOperacion + "\n";
        operacionString += "Valor retiro: "+valorARetirar;
        return operacionString;
    }
}
