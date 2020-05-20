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
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import sun.net.www.content.text.plain;

/**
 *
 * @author YEISON
 */
public class Json {

    String stringJson = "[";//String con toda la informacion de los clientesJsonArray
    String stringLista = "[";//String con los todos los tipos de cliente
    String stringCuenta = "[";//String que tiene la informacion de las cuentas
    Gson gson = new Gson();
    public static Json objetoJson = new Json();//Singleton

    //Listas donde se almacenará la informacion que se saca del archivo Json
    ArrayList<ClientePersona> clientePersona = new ArrayList<ClientePersona>();
    ArrayList<ClienteEmpresa> clienteEmpresa = new ArrayList<ClienteEmpresa>();
    ArrayList<CuentaCorriente> cuentaCorriente = new ArrayList<CuentaCorriente>();
    ArrayList<CuentaDeAhorros> cuentaDeAhorros = new ArrayList<CuentaDeAhorros>();


    private Json() {
    }

//--------------------------------------------------------------------------------------------------------------------------------   
    //Agrega al nuevo cliente al string que tiene toda la informacion, lo agrega en notacion Json al archivo Json
    //Si no está vacio, elimina el ultimo corchete y pone una coma y un salto de linea
    public void agregarCliente(Cliente nuevoCliente) {
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
    //Busca el archivo Json en la carpeta del proyecto y lo sobreescribe
    public void sobreescribirJson() {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("pruebaJson.json"))) {
            bw.write(stringJson);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //--------------------------------------------------------------------------
    //Trae lo que está en el archivo Json
    public void leerJson() {
        String newStringJson = "";

        try (BufferedReader br = new BufferedReader(new FileReader("pruebaJson.json"))) {
            String line;
            while ((line = br.readLine()) != null) {
                newStringJson += line;
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        //JsonObject jsonObject = gson.fromJson(newStringJson, JsonObject.class);

        //Guarda todos los objetos del archivo Json
        stringJson = newStringJson;
        JsonArray clientesJsonArray = gson.fromJson(newStringJson, JsonArray.class);
        //imprimirListaObjetos();

//Pregunta el tipo de cliente y dependiendo de eso lo guarda en la lista de clientePersona o clienteEmpresa
        for (int i = 0; i < clientesJsonArray.size(); i++) {
            JsonObject jsonObject1 = (JsonObject) clientesJsonArray.get(i);
            if (jsonObject1.get("tipoCliente").getAsString().equalsIgnoreCase("Persona")) {
                ClientePersona persona = new ClientePersona();

                persona.setId(jsonObject1.get("id").getAsString());
                persona.setNombre(jsonObject1.get("nombre").getAsString());
                persona.setTelefono(jsonObject1.get("telefono").getAsString());
                persona.setDireccion(jsonObject1.get("direccion").getAsString());
                persona.setOcupacion(jsonObject1.get("ocupacion").getAsString());
                persona.setEstaSuscrito(jsonObject1.get("estaSuscrito").getAsBoolean());
                persona.setContraseña(jsonObject1.get("contraseña").getAsString());
                
                //Agregar cuentas una por una
                //persona.setCuentasCorrientes((ArrayList)jsonObject1.get("cuentasCorrientes"));
                clientePersona.add(persona);
            }
            else if (jsonObject1.get("tipoCliente").getAsString().equalsIgnoreCase("Empresa")) {
                ClienteEmpresa empresa = new ClienteEmpresa();

                empresa.setId(jsonObject1.get("id").getAsString());
                empresa.setNombre(jsonObject1.get("nombre").getAsString());
                empresa.setTelefono(jsonObject1.get("telefono").getAsString());
                empresa.setDireccion(jsonObject1.get("direccion").getAsString());
                empresa.setOcupacion(jsonObject1.get("ocupacion").getAsString());
                empresa.setEstaSuscrito(jsonObject1.get("estaSuscrito").getAsBoolean());
                empresa.setContraseña(jsonObject1.get("contraseña").getAsString());
                empresa.setNit(jsonObject1.get("nit").getAsString());
                empresa.setNombreEmpresa(jsonObject1.get("nombreEmpresa").getAsString());
                empresa.setSectorComercial(jsonObject1.get("sectorComercial").getAsString());
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
    public void imprimirLista(ArrayList lista) {
        System.out.println("");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }
    }

//--------------------------------------------------------------------------------------------------------------------------------  
    public void agregarCuenta(Cuenta nuevaCuenta) {
        if (stringCuenta != "[") {
            stringCuenta = stringCuenta.replace("]", "");
            stringCuenta += ",";

            stringCuenta += "\n";
        }
        stringCuenta += gson.toJson(nuevaCuenta) + "]";
        System.out.println(stringCuenta);
        sobreescribirCuenta();
    }

    public void sobreescribirCuenta() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("cuentaJson.json"))) {
            bw.write(stringCuenta);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void leerCuenta() {
        //Trae la lista de la base de datos
        String newStringCuenta = "";

        try (BufferedReader br = new BufferedReader(new FileReader("cuentasJson.json"))) {
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
        JsonArray cuentasJsonArray = gson.fromJson(newStringCuenta, JsonArray.class);
        if (cuentasJsonArray != null) {
            for (int i = 0; i < cuentasJsonArray.size(); i++) {
                JsonObject jsonObject1 = (JsonObject) cuentasJsonArray.get(i);

                if (jsonObject1.get("tipoCuenta").getAsString().equalsIgnoreCase("Corriente")) {

                    CuentaCorriente cuentaCorriente = new CuentaCorriente(
                            jsonObject1.get("idCuenta").getAsString(),
                            jsonObject1.get("contraseñaCuenta").getAsString(),
                            jsonObject1.get("saldo").getAsDouble(),
                            jsonObject1.get("estaActiva").getAsBoolean(),
                            jsonObject1.get("tipoCuenta").getAsString()
                    );
                    this.cuentaCorriente.add(cuentaCorriente);

                } else if (jsonObject1.get("tipoCuenta").getAsString().equalsIgnoreCase("DeAhorros")) {
                    CuentaDeAhorros cuentaDeAhorros = new CuentaDeAhorros(
                            jsonObject1.get("idCuenta").getAsString(),
                            jsonObject1.get("contraseñaCuenta").getAsString(),
                            jsonObject1.get("saldo").getAsDouble(),
                            jsonObject1.get("estaActiva").getAsBoolean(),
                            jsonObject1.get("tipoCuenta").getAsString()
                    );
                    this.cuentaDeAhorros.add(cuentaDeAhorros);

                }
            }
        }

    }
}

