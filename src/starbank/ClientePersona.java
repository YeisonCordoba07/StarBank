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
public class ClientePersona extends Cliente {

    public static ClientePersona clientePersona;

    public ClientePersona() {
    }

    public ClientePersona(String id, String nombre, String telefono, String direccion, String ocupacion,
            boolean estaSuscrito, String contraseña, String tipoCliente) {

        super(id, nombre, telefono, direccion, ocupacion, estaSuscrito, contraseña, tipoCliente);
    }
    
    
    
//-------------------------------------------------------------------------------------------------------------------------
    @Override
    public String toString()
    {
        return "ClientePersona{" + "\n" + "Nombre: " + nombre + "\n" + "ID: " + id + "\n" + "Telefono: " + telefono + "\n" + "Direccion: " + direccion + "\n" + "Ocupacion: " + ocupacion + "\n"
                + "Contraseña: " + contraseña + "\n" + "}" + "\n" + "\n";
    }

}
