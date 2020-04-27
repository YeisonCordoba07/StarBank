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
    protected String id;
    protected String contraseñaCuenta;
    protected double saldo;//Una cuenta nunca puede tener un saldo menor a 10000
    protected boolean estaActivada;//Está activada cuando se crea y reliza una consignacion de 20000
    protected List <Operacion> listaOperaciones;    

    
    
    public void consignar(double valorAConsignar)
    {
        
    }
    
    
    //Solo se pueden hacer retiros si el valor es mayor a 20000 y multiplo de 10000 
    //Costo de retiro para cuenta de ahorros vale el 2% y para una cuenta corriente vale el 1.7% del valor a retirar
    //Se podra retirar si el valorARetirar + costoDeRetiro deja en la cuenta 10000 o mas
    public void retirar(double valorARetirar)
    {
            double costoDeRetiro;
    }
    
    
    public void agregarOperacion(Operacion operacion)
    {
        //Agrega la operacion a listaOperaciones
        
    }
}
