/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbank;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author YEISON
 */
public class Operacion {
    protected String nombreOperacion;
    protected Date fechaOperacion;
    protected Time hora;

    
    //Contructor----------------------------------------------------------------
    public Operacion(String nombreOperacion, Date fechaOperacion, Time hora) {
        this.nombreOperacion = nombreOperacion;
        this.fechaOperacion = fechaOperacion;
        this.hora = hora;

    }
    
    
    
//------------------------------------------------------------------------------ 
    
    public String retornaStringOperacion(){
        String operacionString = "";
        operacionString += nombreOperacion + "\n";
        operacionString += fechaOperacion +"\n";
        operacionString += hora + "\n";
        return operacionString;
    }
    
    
    
//Setter y Getters--------------------------------------------------------------
    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }
    //--------------------------------------------
    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }
    //--------------------------------------------
    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
    //--------------------------------------------

//------------------------------------------------------------------------------    
    
    
}
