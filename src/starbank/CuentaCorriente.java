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
public class CuentaCorriente extends Cuenta{


    public CuentaCorriente(String idCuenta, String idCliente, String contraseñaCuenta, double saldo, boolean estaActivada, String tipoCuenta) {
        super(idCuenta, idCliente, contraseñaCuenta, saldo, estaActivada, tipoCuenta);
    }
    
    
}
