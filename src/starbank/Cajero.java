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



    public void crearCliente(String id, String nombre, String telefono, String direccion, String ocupacion, boolean estaSuscrito, String contraseña, String tipoCliente,
            String nit, String nombreEmpresa, String sectorComercial) {

        

        switch (tipoCliente) {
            //Agregar a la base de datos de json los datos
            case "Persona":
                ClientePersona nuevoCliente = new ClientePersona(id, nombre, telefono, direccion, ocupacion, estaSuscrito, contraseña);
                //Aplicando el patron de singleton, haciendo referencia a un objeto de la clase Json 
                //que me va a dar acceso a todos lo que necesite de el, sin necesidad de crear uno deferente 
                Json.objetoJson.agregarCliente(nuevoCliente);
                break;
            case "Empresa":
                ClienteEmpresa nuevoClienteEmpresa = new ClienteEmpresa(id, nombre, telefono, direccion, ocupacion, estaSuscrito, contraseña, nit, nombreEmpresa, sectorComercial);
                Json.objetoJson.agregarCliente(nuevoClienteEmpresa);
                break;
            default:
                System.out.println("No se ingreso un cliente correcto");
                break;
        }
       
    }

    public void crearCuenta() {

    }

    public void desactivarCuenta() {

    }

    public void verCliente(String id, String contraseña) {

    }

}
