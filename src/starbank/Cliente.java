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
abstract class Cliente {

    protected String id;
    protected String nombre;
    protected String telefono;
    protected String direccion;
    protected String ocupacion;
    protected boolean estaSuscrito;//Se perderá la suscripcion a la sucursal si no tiene por lo menos una cuenta activa
    protected String contraseña;

    abstract public void iniciarSesion(String id, String contraseña);//Ir a la base de datos y comprobar que el id y la contraseña esten bien, luego trae toda la informacion del Cliente

    public Cliente(String id, String nombre, String telefono, String direccion, String ocupacion, boolean estaSuscrito, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ocupacion = ocupacion;
        this.estaSuscrito = estaSuscrito;
        this.contraseña = contraseña;
    }

}
