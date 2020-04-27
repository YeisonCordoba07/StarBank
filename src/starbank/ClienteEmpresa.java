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
public class ClienteEmpresa extends Cliente{

    String nit;
    String nombreEmpresa;
    String sectorComercial;

    public ClienteEmpresa(String id, String nombre, String telefono, String direccion, String ocupacion, boolean estaSuscrito,String contraseña, String nit, String nombreEmpresa, String sectorComercial) {
        super(id, nombre, telefono, direccion, ocupacion, estaSuscrito, contraseña);
        this.nit = nit;
        this.nombreEmpresa = nombreEmpresa;
        this.sectorComercial = sectorComercial;
    }
    
    @Override
    public void iniciarSesion(String id, String contraseña) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
