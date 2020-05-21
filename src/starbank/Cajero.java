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

    public static Cajero cajero = new Cajero();//Singleton

    public void crearClientePersona(String id, String nombre, String telefono, String direccion, String ocupacion, boolean estaSuscrito, String contraseña, String tipoCliente) {
        ClientePersona nuevoCliente = new ClientePersona(id, nombre, telefono, direccion, ocupacion, estaSuscrito, contraseña, tipoCliente);
        Json.objetoJson.agregarCliente(nuevoCliente);//Agrega el cliente al archivo Json

    }

    public void crearClienteEmpresa(String id, String nombre, String telefono, String direccion, String ocupacion, boolean estaSuscrito, String contraseña, String tipoCliente,
            String nit, String nombreEmpresa, String sectorComercial) {
        ClienteEmpresa nuevoClienteEmpresa = new ClienteEmpresa(id, nombre, telefono, direccion, ocupacion, estaSuscrito, contraseña, tipoCliente, nit, nombreEmpresa, sectorComercial);
        Json.objetoJson.agregarCliente(nuevoClienteEmpresa);

    }

    public void crearCuenta() {

    }

    public void desactivarCuenta() {

    }

    public ClientePersona traerClientePersona(String id) {
        return Json.objetoJson.retornaClientePersona(id);
    }

    public ClienteEmpresa traerClienteEmpresa(String id) {
        return Json.objetoJson.retornaClienteEmpresa(id);
    }

    //Lee lo que está en la base de datos Json
    public void traerJson() {
        Json.objetoJson.leerJson();
    }

}
