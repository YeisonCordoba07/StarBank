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
public class Cajero {
    
    
    public void crearCliente(String tipoCliente, String id, String nombre, String telefono, String direccion, String ocupacion, boolean estaSuscrito, String contraseña)
    {
        switch (tipoCliente)
        {
            case "Persona":
                ClientePersona nuevoCliente = new ClientePersona(id, nombre, telefono, direccion, ocupacion, estaSuscrito, contraseña);
                break;
            case "Empresa":
                break;
            default:
                System.out.println("No se ingreso un cliente correcto");
                break;
        }

    }
    
    public void crearCuenta()
    {
        
    }
    
    public void desactivarCuenta()
    {
        
    }
    
    public void verCliente(String id, String contraseña)
    {
        
    }
    
}
