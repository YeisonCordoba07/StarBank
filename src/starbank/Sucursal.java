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
public class Sucursal {
    String idSucursal;
    String direccionSucursal;
    String nombreSucursal;
    String ciudadSucursal;
    static double saldoSucursal;
    
    
    public void consignarSucursal(double precioRetiro){
        this.saldoSucursal += precioRetiro;//Se le añade el precio de retiro a el saldo de la sucursal
    }
}
