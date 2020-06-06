/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbank;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author YEISON
 */
public class Json {

    private String stringJson = "[";/*String con toda la informacion de los clientes*/
    private String stringCuenta = "[";/*String que tiene la informacion de las cuentas*/
    private Gson gson = new Gson();
    public static Json objetoJson = new Json();

    /*Listas donde se almacenará la informacion que se saca del archivo Json*/
    ArrayList<ClientePersona> clientePersona = new ArrayList<ClientePersona>();
    ArrayList<ClienteEmpresa> clienteEmpresa = new ArrayList<ClienteEmpresa>();
    ArrayList<CuentaCorriente> cuentaCorriente = new ArrayList<CuentaCorriente>();
    ArrayList<CuentaDeAhorros> cuentaDeAhorros = new ArrayList<CuentaDeAhorros>();

    
    
    
    private Json() {
    }
    
    
    
//--------------------------------------------------------------------------------------------------------------------------------   
    /*Agrega al nuevo cliente al string que tiene toda la informacion, lo agrega en notacion Json al archivo Json
    Si no está vacio, elimina el ultimo corchete y pone una coma y un salto de linea.*/
    public void agregarCliente(Cliente nuevoCliente) 
    {
        if (stringJson != "[") {
            stringJson = stringJson.replace("]", "");
            stringJson += ",";

            stringJson += "\n";
        }
        stringJson += gson.toJson(nuevoCliente) + "]";
        System.out.println(stringJson);
        sobreescribirJson();

    }

    //--------------------------------------------------------------------------
    /*Busca el archivo Json en la carpeta del proyecto y lo sobreescribe*/
    private void sobreescribirJson()
    {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("clientesJson.json"))) {
            bw.write(stringJson);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        leerJson();
    }

    //--------------------------------------------------------------------------
    /*Trae lo que está en el archivo Json. Guarda todo en stringJson. Pero los 
    clientes los guarda en las listas clientePersona o clienteEmpresa*/
    public void leerJson()
    {
        String newStringJson = "";

        try (BufferedReader br = new BufferedReader(new FileReader("clientesJson.json"))) {
            String line;
            while ((line = br.readLine()) != null) {
                newStringJson += line;
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        /*Guarda todos los objetos del archivo Json en stringJson*/
        stringJson = newStringJson;
        
        /*Guarda todos los objetos del string en un JsonArray*/
        JsonArray clientesJsonArray = gson.fromJson(newStringJson, JsonArray.class);

        /*Vacia las listas*/
        clientePersona = new ArrayList<ClientePersona>();
        clienteEmpresa = new ArrayList<ClienteEmpresa>();

        /*Pregunta el tipo de cliente y dependiendo de eso lo guarda en la lista de clientePersona o clienteEmpresa*/
        for (int i = 0; i < clientesJsonArray.size(); i++) 
        {         
            /*Crea un jsonObject, en el que se guardara cada uno de los objetos que clientesJsonArray tenga.
            Luego crea un objeto cliente dependiendo del tipo de cliente. 
            Por ultimo le pasa a ese objeto cliente toda la informacion que tiene el jsonObject
            y lo agrega a una de las listas de clientes*/
            JsonObject jsonObject = (JsonObject) clientesJsonArray.get(i);        

            if (jsonObject.get("tipoCliente").getAsString().equalsIgnoreCase("Persona")) 
            {
                ClientePersona persona = new ClientePersona();

                persona.setId(jsonObject.get("id").getAsString());
                persona.setNombre(jsonObject.get("nombre").getAsString());
                persona.setTelefono(jsonObject.get("telefono").getAsString());
                persona.setDireccion(jsonObject.get("direccion").getAsString());
                persona.setOcupacion(jsonObject.get("ocupacion").getAsString());
                persona.setEstaSuscrito(jsonObject.get("estaSuscrito").getAsBoolean());
                persona.setContraseña(jsonObject.get("contraseña").getAsString());
                persona.setTipoCliente(jsonObject.get("tipoCliente").getAsString());

                clientePersona.add(persona);
                
            } else if (jsonObject.get("tipoCliente").getAsString().equalsIgnoreCase("Empresa")) 
            {
                ClienteEmpresa empresa = new ClienteEmpresa();

                empresa.setId(jsonObject.get("id").getAsString());
                empresa.setNombre(jsonObject.get("nombre").getAsString());
                empresa.setTelefono(jsonObject.get("telefono").getAsString());
                empresa.setDireccion(jsonObject.get("direccion").getAsString());
                empresa.setOcupacion(jsonObject.get("ocupacion").getAsString());
                empresa.setEstaSuscrito(jsonObject.get("estaSuscrito").getAsBoolean());
                empresa.setContraseña(jsonObject.get("contraseña").getAsString());
                empresa.setTipoCliente(jsonObject.get("tipoCliente").getAsString());
                empresa.setNit(jsonObject.get("nit").getAsString());
                empresa.setNombreEmpresa(jsonObject.get("nombreEmpresa").getAsString());
                empresa.setSectorComercial(jsonObject.get("sectorComercial").getAsString());
                
                clienteEmpresa.add(empresa);

            } else {
                System.out.println("Error al ver el tipo de objeto en Clase Json");
            }
        }

        System.out.println("IMPRIMIR LISTA");
        imprimirLista(clientePersona);
        imprimirLista(clienteEmpresa);

    }

    
    
//--------------------------------------------------------------------------------------------------------------------------------  
    //Imprime los objetos de la lista que se le pasa como parametro
    private void imprimirLista(ArrayList lista)
    {
        System.out.println("");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }
    }
    
    

//--------------------------------------------------------------------------------------------------------------------------------  
    /*Elimina el ultimo corchete, agrega una coma, agrega la nueva cuenta y agrega de nuevo el corchete.
    Sobreescribe el archivo json de las cuentas, con uno con la cuenta agregada*/
    public void agregarCuenta(Cuenta nuevaCuenta) 
    {
        if (stringCuenta != "[") 
        {
            stringCuenta = stringCuenta.substring(0, stringCuenta.length() - 1);
            //stringCuenta = stringCuenta.replace("]", "");
            stringCuenta += ",";
            stringCuenta += "\n";
        }
        stringCuenta += gson.toJson(nuevaCuenta) + "]";
        System.out.println(stringCuenta);
        sobreescribirCuenta(stringCuenta);

    }

    //--------------------------------------------------------------------------
    private void sobreescribirCuenta(String stringInformacion)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("cuentasJson.json"))) 
        {
            bw.write(stringInformacion);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        leerCuenta();
    }

    //--------------------------------------------------------------------------
    public void leerCuenta() {
        //Trae la lista de la base de datos
        String newStringCuenta = "";

        try (BufferedReader br = new BufferedReader(new FileReader("cuentasJson.json"))) 
        {
            String line;
            while ((line = br.readLine()) != null) {
                newStringCuenta += line;
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        stringCuenta = newStringCuenta;
               
        /*Vacia las cuentas*/
        cuentaCorriente = new ArrayList<CuentaCorriente>();
        cuentaDeAhorros = new ArrayList<CuentaDeAhorros>();
        
        JsonArray cuentasJsonArray = gson.fromJson(newStringCuenta, JsonArray.class);
        if (cuentasJsonArray != null) 
        {
            for (int i = 0; i < cuentasJsonArray.size(); i++)
            {
                JsonObject jsonObject = (JsonObject) cuentasJsonArray.get(i);
                
                /*Crea un objeto tipo cuenta y se le pasa toda la informacion que tiene el jsonObject.
                Crea una lista y también se le agregan todas las operaciones que tiene la lista del jsonObject.
                Por ultimo se agrega la lista a la cuenta,y la cuenta a la lista de cuentas cuentaCorriente
                o cuentaDeAhorros*/
                if (jsonObject.get("tipoCuenta").getAsString().equalsIgnoreCase("Corriente")) 
                {
                    CuentaCorriente cuentaCorriente = new CuentaCorriente(
                            jsonObject.get("idCuenta").getAsString(),
                            jsonObject.get("idCliente").getAsString(),
                            jsonObject.get("contraseñaCuenta").getAsString(),
                            jsonObject.get("saldo").getAsDouble(),
                            jsonObject.get("estaActiva").getAsBoolean(),
                            jsonObject.get("tipoCuenta").getAsString()
                    );

                    ArrayList<String> listaOperaciones = new ArrayList<String>();
                    JsonArray jsonArrayListaOperaciones = jsonObject.get("listaOperaciones").getAsJsonArray();
                    if (jsonArrayListaOperaciones != null)
                    {
                        for (int j = 0; j < jsonArrayListaOperaciones.size(); j++)
                        {
                            listaOperaciones.add(jsonArrayListaOperaciones.get(j).getAsString());
                        }
                    }

                    cuentaCorriente.setListaOperaciones(listaOperaciones);
                    this.cuentaCorriente.add(cuentaCorriente);

                } else if (jsonObject.get("tipoCuenta").getAsString().equalsIgnoreCase("DeAhorros")) 
                {
                    CuentaDeAhorros cuentaDeAhorros = new CuentaDeAhorros(
                            jsonObject.get("idCuenta").getAsString(),
                            jsonObject.get("idCliente").getAsString(),
                            jsonObject.get("contraseñaCuenta").getAsString(),
                            jsonObject.get("saldo").getAsDouble(),
                            jsonObject.get("estaActiva").getAsBoolean(),
                            jsonObject.get("tipoCuenta").getAsString()
                    );

                    ArrayList<String> listaOperaciones = new ArrayList<String>();
                    JsonArray jsonArrayListaOperaciones = jsonObject.get("listaOperaciones").getAsJsonArray();
                    if (jsonArrayListaOperaciones != null)
                    {
                        for (int j = 0; j < jsonArrayListaOperaciones.size(); j++) 
                        {
                            listaOperaciones.add(jsonArrayListaOperaciones.get(j).getAsString());
                        }
                    }

                    cuentaDeAhorros.setListaOperaciones(listaOperaciones);
                    this.cuentaDeAhorros.add(cuentaDeAhorros);

                }
            }
        }
        System.out.println("IMPRIMIR CUENTAS");
        imprimirLista(cuentaCorriente);
        imprimirLista(cuentaDeAhorros);

    }

    
    
//-------------------------------------------------------------------------------------------------------------------------------- 
    /*Busca en la lista de clientes al cliente con la id que se le pasa como parametro, y lo retorna si lo encuentra.
    También sirve para saber si el cliente existe.*/
    public ClientePersona retornaClientePersona(String idCliente)
    {
        for (ClientePersona persona : this.clientePersona)
        {
            if (persona.getId().equalsIgnoreCase(idCliente)) 
            {
                return persona;
            }
        }
        return null;
    }

    //--------------------------------------------------------------------------
    public ClienteEmpresa retornaClienteEmpresa(String idCliente) 
    {
        for (ClienteEmpresa empresa : this.clienteEmpresa)
        {
            if (empresa.getId().equalsIgnoreCase(idCliente))
            {
                return empresa;
            }
        }
        return null;
    }



//--------------------------------------------------------------------------------------------------------------------------------    
    public boolean existeCuenta(String idCuenta)
    {
            for(CuentaCorriente corriente : this.cuentaCorriente)
            {
                if(corriente.getIdCuenta().equals(idCuenta))
                {
                    return true;
                }
            }            
            for(CuentaDeAhorros ahorros : this.cuentaDeAhorros)
            {
                if(ahorros.getIdCuenta().equals(idCuenta))
                {
                    return true;
                }
            }
            return false;
    }
    
    
//--------------------------------------------------------------------------------------------------------------------------------
    /*Devuelve todas las cuentas que tenga un cliente*/
    public ArrayList<CuentaCorriente> retornaCuentasCorrientesCliente(String idCliente) 
    {
        ArrayList<CuentaCorriente> listaCorriente = new ArrayList<CuentaCorriente>();
        for (CuentaCorriente corriente : this.cuentaCorriente) 
        {
            if (corriente.getIdCliente().equalsIgnoreCase(idCliente)) 
            {
                listaCorriente.add(corriente);
            }
        }
        return listaCorriente;
    }

    //--------------------------------------------------------------------------
    public ArrayList<CuentaDeAhorros> retornaCuentasDeAhorrosCliente(String idCliente) 
    {
        ArrayList<CuentaDeAhorros> listaDeAhorros = new ArrayList<CuentaDeAhorros>();
        for (CuentaDeAhorros deAhorros : this.cuentaDeAhorros)
        {
            if (deAhorros.getIdCliente().equalsIgnoreCase(idCliente))
            {
                listaDeAhorros.add(deAhorros);
            }
        }
        return listaDeAhorros;
    }

    //--------------------------------------------------------------------------
    /*Cuendo se requiere actualizar el dato de una cuenta, toma el stringCuenta y agrega todas las cuentas 
    que tiene la lista de cuentas. Cuando encuentra la que se quiere actulizar, en lugar de agregar la que esta en la lista,
    agrega la que se le pasa como parametro con la informacion actulizada, luego hace lo mismo con los otros tipos de cuentas*/
    public void actulizarCuentaCorriente(CuentaCorriente cuenta)
    {
        if (cuenta != null) 
        {
            stringCuenta = "[";
        }
        for (int i = 0; i < cuentaCorriente.size(); i++) 
        {
            try {
                if (cuenta != null && cuentaCorriente.get(i).getIdCuenta().equalsIgnoreCase(cuenta.getIdCuenta())) 
                {
                    stringCuenta += gson.toJson(cuenta);

                } else {
                    stringCuenta += gson.toJson(cuentaCorriente.get(i));
                }
            } catch (NullPointerException e) {
                System.out.println("Nullo en actualizarCuentaCorriente");
            }

            if (cuenta == null && i + 1 == cuentaCorriente.size())
            {
                stringCuenta += "]";
            } else {
                stringCuenta += ",";
            }
        }
        
        /*Si la cuenta que se le pasa como parametro es nula, entonces sobreescribe el archivoJson.
        Sino, hace lo mismo con los otros tipos de cuenta*/
        if (cuenta != null)
        {
            actulizarCuentaDeAhorros(null);
        } else {
            sobreescribirCuenta(stringCuenta);
        }

    }

    //--------------------------------------------------------------------------
    public void actulizarCuentaDeAhorros(CuentaDeAhorros cuenta)
    {
        if (cuenta != null)
        {
            stringCuenta = "[";
        }

        for (int i = 0; i < cuentaDeAhorros.size(); i++) 
        {
            try {
                if (cuenta != null && cuentaDeAhorros.get(i).getIdCuenta().equalsIgnoreCase(cuenta.getIdCuenta())) 
                {
                    stringCuenta += gson.toJson(cuenta);

                } else {
                    stringCuenta += gson.toJson(cuentaDeAhorros.get(i));
                }
            } catch (NullPointerException e) {
                System.out.println("Nullo en actualizar cuenta de ahorros");
            }

            if (cuenta == null && i + 1 == cuentaDeAhorros.size())
            {
                stringCuenta += "]";
            } else {
                stringCuenta += ",";
            }
        }
        if (cuenta != null) 
        {
            actulizarCuentaCorriente(null);
        } else {
            sobreescribirCuenta(stringCuenta);
        }

    }

}
