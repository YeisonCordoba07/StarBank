/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbank;

import java.util.List;

/**
 *
 * @author YEISON
 */
public abstract class Cuenta {

    //Si se desactiva la cuenta podrá retirar todo el saldo 
    protected String idCuenta;
    protected String idCliente;
    protected String contraseñaCuenta;
    protected double saldo;//Una cuenta nunca puede tener un saldo menor a 10000
    protected boolean estaActiva;//Está activa cuando se crea y reliza una consignacion de 20000
    protected String tipoCuenta;
    //protected List<Operacion> listaOperaciones;

//---------------------------------------------------------------------------------------------------------------------
    public Cuenta(String idCuenta, String idCliente, String contraseñaCuenta, double saldo, boolean estaActivada, String tipoCuenta) {
        this.idCuenta = idCuenta;
        this.idCliente = idCliente;
        this.contraseñaCuenta = contraseñaCuenta;
        this.saldo = saldo;
        this.estaActiva = estaActivada;
        this.tipoCuenta = tipoCuenta;
    }

//---------------------------------------------------------------------------------------------------------------------
    public void consignar(double valorAConsignar) {

    }

    //Solo se pueden hacer retiros si el valor es mayor a 20000 y multiplo de 10000 
    //Costo de retiro para cuenta de ahorros vale el 2% y para una cuenta corriente vale el 1.7% del valor a retirar
    //Se podra retirar si el valorARetirar + costoDeRetiro deja en la cuenta 10000 o mas
    public void retirar(double valorARetirar) {
        double costoDeRetiro;
    }

//    public void agregarOperacion(Operacion operacion) {
//        //Agrega la operacion a listaOperaciones
//        listaOperaciones.add(operacion);
//
//    }

    public void verificarValorARetirar(double valorARetirar, double interes) {
        if (saldo - (interes * valorARetirar) < 10000) {
            //No se puede retirar
        }
    }

//------------------------------------------------------------------------------
    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }
    //--------------------------------------

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    //--------------------------------------
    public String getContraseñaCuenta() {
        return contraseñaCuenta;
    }

    public void setContraseñaCuenta(String contraseñaCuenta) {
        this.contraseñaCuenta = contraseñaCuenta;
    }
    //--------------------------------------

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    //--------------------------------------

    public boolean isEstaActiva() {
        return estaActiva;
    }

    public void setEstaActiva(boolean estaActiva) {
        this.estaActiva = estaActiva;
    }
    //--------------------------------------
//
//    public List<Operacion> getListaOperaciones() {
//        return listaOperaciones;
//    }
//
//    public void setListaOperaciones(List<Operacion> listaOperaciones) {
//        this.listaOperaciones = listaOperaciones;
//    }

    //--------------------------------------
    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    //------------------------------------------------------------------------------
}
