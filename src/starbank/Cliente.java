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

    String id;
    String nombre;
    String telefono;
    String direccion;
    String ocupacion;
    boolean estaSuscrito;

    abstract public void iniciarSesion(String id, String contraseña);

}
