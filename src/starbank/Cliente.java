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
abstract class Cliente {

    protected String id;
    protected String nombre;
    protected String telefono;
    protected String direccion;
    protected String ocupacion;
    protected boolean estaSuscrito;//Se perderá la suscripcion a la sucursal si no tiene por lo menos una cuenta activa
    protected String contraseña;
    protected String tipoCliente;
    protected ArrayList<CuentaCorriente> cuentasCorrientes = new ArrayList<CuentaCorriente>();
    protected ArrayList<CuentaDeAhorros> cuentasDeAhorros = new ArrayList<CuentaDeAhorros>();

    //public void iniciarSesion(String id, String contraseña);//Ir a la base de datos y comprobar que el id y la contraseña esten bien, luego trae toda la informacion del Cliente
    public Cliente() {
    }

    public Cliente(String id, String nombre, String telefono, String direccion, String ocupacion, boolean estaSuscrito, String contraseña, String tipoCliente) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ocupacion = ocupacion;
        this.estaSuscrito = estaSuscrito;
        this.contraseña = contraseña;
        this.tipoCliente = tipoCliente;
    }

//------------------------------------------------------------------------------   
    public void agregarCuentaCorriente(CuentaCorriente cuenta) {
        cuentasCorrientes.add(cuenta);
    }

    public void agregarCuentaDeAhorros(CuentaDeAhorros cuenta) {
        cuentasDeAhorros.add(cuenta);
    }

//------------------------------------------------------------------------------ 
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //-----------------------------------------
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //-----------------------------------------
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //-----------------------------------------
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    //-----------------------------------------
    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    //-----------------------------------------
    public boolean isEstaSuscrito() {
        return estaSuscrito;
    }

    public void setEstaSuscrito(boolean estaSuscrito) {
        this.estaSuscrito = estaSuscrito;
    }

    //-----------------------------------------
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    //----------------------------------------- 

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    //-----------------------------------------     

    public ArrayList<CuentaCorriente> getCuentasCorrientes() {
        return cuentasCorrientes;
    }

    public void setCuentasCorrientes(ArrayList<CuentaCorriente> cuentasCorrientes) {
        this.cuentasCorrientes = cuentasCorrientes;
    }

    public ArrayList<CuentaDeAhorros> getCuentasDeAhorros() {
        return cuentasDeAhorros;
    }

    public void setCuentasDeAhorros(ArrayList<CuentaDeAhorros> cuentasDeAhorros) {
        this.cuentasDeAhorros = cuentasDeAhorros;
    }

}
