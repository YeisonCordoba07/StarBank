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

    Json json = new Json();//Objeto con el cual se implementara la API Gson

    public void crearCliente(String id, String nombre, String telefono, String direccion, String ocupacion, boolean estaSuscrito, String contraseña, String tipoCliente,
            String nit, String nombreEmpresa, String sectorComercial) {

        

        switch (tipoCliente) {
            //Agregar a la base de datos de json los datos
            case "Persona":
                ClientePersona nuevoCliente = new ClientePersona(id, nombre, telefono, direccion, ocupacion, estaSuscrito, contraseña);
                json.agregarCliente(nuevoCliente);
                break;
            case "Empresa":
                ClienteEmpresa nuevoClienteEmpresa = new ClienteEmpresa(id, nombre, telefono, direccion, ocupacion, estaSuscrito, contraseña, nit, nombreEmpresa, sectorComercial);
                json.agregarCliente(nuevoClienteEmpresa);
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
