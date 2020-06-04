/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbank;

import java.util.ArrayList;

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

    public void crearCuentaCorriente(String idCuenta, String idCliente, String contraseña, String tipoCuenta) {
        CuentaCorriente cuentaCorriente = new CuentaCorriente(idCuenta, idCliente, contraseña, 0, false, tipoCuenta);
        Json.objetoJson.agregarCuenta(cuentaCorriente);
    }

    public void crearCuentaDeAhorros(String idCuenta, String idCliente, String contraseña, String tipoCuenta) {
        CuentaDeAhorros cuentaDeAhorros = new CuentaDeAhorros(idCuenta, idCliente, contraseña, 0, false, tipoCuenta);
        Json.objetoJson.agregarCuenta(cuentaDeAhorros);
    }

    public CuentaCorriente traerCuentaCorriente(String idCuenta) {
        return Json.objetoJson.retornaCuentaCorriente(idCuenta);
    }

    public CuentaDeAhorros traerCuentaDeAhorros(String idCuenta) {
        return Json.objetoJson.retornaCuentaDeAhorros(idCuenta);
    }

    public void desactivarCuenta() {

    }

    public ArrayList<CuentaCorriente> traerCuentasCorrientesCliente(String idCliente) {
        return Json.objetoJson.retornaCuentasCorrientesCliente(idCliente);
    }

    public ArrayList<CuentaDeAhorros> traerCuentasDeAhorrosCliente(String idCliente) {
        return Json.objetoJson.retornaCuentasDeAhorrosCliente(idCliente);
    }

    public ClientePersona traerClientePersona(String id) {
        return Json.objetoJson.retornaClientePersona(id);
    }

    public ClienteEmpresa traerClienteEmpresa(String id) {
        return Json.objetoJson.retornaClienteEmpresa(id);
    }

    public void actulizarCuentaCorriente(CuentaCorriente corriente) {
        Json.objetoJson.actulizarCuentaCorriente(corriente);
    }

    public void actulizarCuentaDeAhorros(CuentaDeAhorros deAhorros) {
        Json.objetoJson.actulizarCuentaDeAhorros(deAhorros);
    }

    //Lee lo que está en la base de datos Json
    public void traerJson() {
        Json.objetoJson.leerJson();
        Json.objetoJson.leerCuenta();
    }

}
