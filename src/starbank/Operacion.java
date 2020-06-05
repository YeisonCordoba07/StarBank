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

    
    
    
    public Operacion(String nombreOperacion, Date fechaOperacion)
    {
        this.nombreOperacion = nombreOperacion;
        this.fechaOperacion = fechaOperacion;

    }
    
    
    

//------------------------------------------------------------------------------ 
    public String retornaStringOperacion()
    {
        String operacionString = "";
        operacionString += "Operacion:" + nombreOperacion + "\n";
        operacionString += "Fecha: " + fechaOperacion + "\n";
        return operacionString;
    }

    
//Setter y Getters--------------------------------------------------------------
    public String getNombreOperacion()
    {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion)
    {
        this.nombreOperacion = nombreOperacion;
    }

    //--------------------------------------------
    public Date getFechaOperacion() 
    {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) 
    {
        this.fechaOperacion = fechaOperacion;
    }
    
    

//------------------------------------------------------------------------------    
}
