/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbank;

/**
 *
 * @author YEISON
 */
public class CuentaDeAhorros extends Cuenta{
    private final double INTERES = 0.1;


    public CuentaDeAhorros(String idCuenta,String idCliente, String contraseñaCuenta, double saldo, boolean estaActivada, String tipoCuenta) {
        super(idCuenta, idCliente, contraseñaCuenta, saldo, estaActivada, tipoCuenta);
    }


    
    
    
    
    
}
