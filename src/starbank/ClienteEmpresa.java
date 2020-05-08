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
public class ClienteEmpresa extends Cliente {

    private String nit;
    private String nombreEmpresa;
    private String sectorComercial;

    public ClienteEmpresa(String id, String nombre, String telefono, String direccion, String ocupacion, boolean estaSuscrito, String contraseña, String nit, String nombreEmpresa, String sectorComercial) {
        super(id, nombre, telefono, direccion, ocupacion, estaSuscrito, contraseña);
        this.nit = nit;
        this.nombreEmpresa = nombreEmpresa;
        this.sectorComercial = sectorComercial;
    }


    public void iniciarSesion(String id, String contraseña) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//------------------------------------------------------------------------------

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    //-----------------------------------
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    //-----------------------------------
    public String getSectorComercial() {
        return sectorComercial;
    }

    public void setSectorComercial(String sectorComercial) {
        this.sectorComercial = sectorComercial;
    }
    //------------------------------------------------------------------------------   

    @Override
    public String toString() {
        return "Cliente{"+"\n" + "Nombre: " + nombre + "\n" + "ID: " + id + "\n" + "Telefono: " + telefono + "\n" + "Direccion: " + direccion + "\n"
                + "Ocupacion: " + ocupacion + "\n" + "Contraseña: " + contraseña + "Nit: " + nit + "\n" + "Nombre Empresa: " + nombreEmpresa + "\n"
                + "Sector comercial: " + sectorComercial + "\n" + "}"+"\n"+"\n";
    }

}
