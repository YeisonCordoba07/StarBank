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

    public static Cajero cajero = new Cajero();

    public void crearClientePersona(String id, String nombre, String telefono, String direccion, String ocupacion, boolean estaSuscrito, String contraseña, String tipoCliente) {
        ClientePersona nuevoCliente = new ClientePersona(id, nombre, telefono, direccion, ocupacion, estaSuscrito, contraseña);
        //Aplicando el patron de singleton, haciendo referencia a un objeto de la clase Json 
        //que me va a dar acceso a todos lo que necesite de el, sin necesidad de crear uno deferente 
        Json.objetoJson.agregarCliente(nuevoCliente);
        Json.objetoJson.agregarALista(tipoCliente);
        Json.objetoJson.agregarAListaJson(tipoCliente);
    }

    public void crearClienteEmpresa(String id, String nombre, String telefono, String direccion, String ocupacion, boolean estaSuscrito, String contraseña, String tipoCliente,
            String nit, String nombreEmpresa, String sectorComercial) {
        ClienteEmpresa nuevoClienteEmpresa = new ClienteEmpresa(id, nombre, telefono, direccion, ocupacion, estaSuscrito, contraseña, nit, nombreEmpresa, sectorComercial);
        Json.objetoJson.agregarCliente(nuevoClienteEmpresa);
        Json.objetoJson.agregarALista(tipoCliente);
        Json.objetoJson.agregarAListaJson(tipoCliente);
    }

    public void crearCuenta() {

    }

    public void desactivarCuenta() {

    }

    public void verCliente(String id, String contraseña) {

    }

    public void traerJson() {
        Json.objetoJson.leerLista();
        Json.objetoJson.leerJson();
    }

}
