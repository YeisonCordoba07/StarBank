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
public class CuentaCorriente extends Cuenta {

    
    
    
    public CuentaCorriente(String idCuenta, String idCliente, String contraseñaCuenta, 
            double saldo, boolean estaActiva, String tipoCuenta) {
        
        super(idCuenta, idCliente, contraseñaCuenta, saldo, estaActiva, tipoCuenta);
    }
    
    
    
//---------------------------------------------------------------------------------------------------------------------
    @Override
    public String toString()
    {
        return "CuentaCorriente{" +"\n" + "IdCuenta: "+idCuenta+ "\n" +"IdCliente: "+idCliente+ "\n" 
                +"ContraseñaCuenta: "+contraseñaCuenta+ "\n" +"Saldo: "+saldo+ "\n" +"estaActiva: "+estaActiva
                + "\n" +"TipoCuenta: "+tipoCuenta + "\n" +"}" + "\n" + "\n";
    }

}
