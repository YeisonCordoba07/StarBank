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
public class ClientePersona extends Cliente{

    public ClientePersona(String id, String nombre, String telefono, String direccion, String ocupacion, boolean estaSuscrito) {
        super(id, nombre, telefono, direccion, ocupacion, estaSuscrito);
    }
 
    
    
    
    @Override
    public void iniciarSesion(String id, String contraseña) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
