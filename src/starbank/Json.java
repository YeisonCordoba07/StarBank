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

    String stringJson = "[";//String con toda la informacion de los clientes
    String stringLista = "[";//String con los todos los tipos de cliente
    Gson gson = new Gson();
    public static Json objetoJson = new Json();//Singleton

    //Listas donde se almacenará la informacion que se saca del archivo Json
    ArrayList<ClientePersona> clientePersona = new ArrayList<ClientePersona>();
    ArrayList<ClienteEmpresa> clienteEmpresa = new ArrayList<ClienteEmpresa>();

    //Tiene una lista de todos los objetos que se han creado en el programa,
    //Tiene su tipo para saber si guardarlos en ClientePersona o ClienteEmpresa
    public static ArrayList<PosicionObjetos> listaObjetos = new ArrayList<PosicionObjetos>();//Guarda el numero de objetos que hay en el archivo Json y también contiene su tipo
    //public posicionObjetos[] d = new posicionObjetos[5];

    public Json() {
    }

//--------------------------------------------------------------------------------------------------------------------------------   
    //Agrega al nuevo cliente al string que tiene toda la informacion, lo agrega en notacion Json
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

//----------------------------------------------------------------------------------------  
    //Busca el archivo en la carpeta del proyecto y lo sobreescribe
    public void sobreescribirJson() {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("pruebaJson.json"))) {
            bw.write(stringJson);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

//--------------------------------------------------------------------------------------------------------------------------------
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
        JsonArray clientes = gson.fromJson(newStringJson, JsonArray.class);
        imprimirListaObjetos();

        //Aquí hay que guardar los datos en un tipo de archivo que debe ser Cliente Persona, o Cliente Empresa
        //Pero si pongo para que se guarden en ClientePersona, los datos como nit, se pierden.
        //Y si pongo ClienteEmpresa, los que sean ClientePersona tendrán atributos como el nit en null.
        //Si lo pongo como ClienteEmpresa se soluciona por ahora, pero si en un futuro aparece un nuevo cliente
        //con otro atrubuto diferentes, ya no funcionaria y estariamos en el mismos problema
        //Lo mismo pasa con operacion y sus hijos
        //Va a listaObjetos y mira que tipo es el objeto para saber en donde guardarlo
        for (int i = 0; i < listaObjetos.size(); i++) {
            if (listaObjetos.get(i).getTipoObjeto().equalsIgnoreCase("Persona")) {

                JsonObject jsonObject1 = (JsonObject) clientes.get(i);
                ClientePersona persona = new ClientePersona();

                persona.setId("" + jsonObject1.get("id"));
                persona.setNombre("" + jsonObject1.get("nombre"));
                persona.setTelefono("" + jsonObject1.get("telefono"));
                persona.setDireccion("" + jsonObject1.get("direccion"));
                persona.setOcupacion("" + jsonObject1.get("ocupacion"));
                persona.setEstaSuscrito(Boolean.parseBoolean("" + jsonObject1.get("estaSuscrito")));
                persona.setContraseña("" + jsonObject1.get("contraseña"));
                clientePersona.add(persona);

                //Añade un cliente empresa a la lista, para agregarlo va a la listaObjetos y mira cuales objetos coinciden con su tipo
            } else if (listaObjetos.get(i).getTipoObjeto().equalsIgnoreCase("Empresa")) {

                JsonObject jsonObject1 = (JsonObject) clientes.get(i);
                ClienteEmpresa empresa = new ClienteEmpresa();

                empresa.setId("" + jsonObject1.get("id"));
                empresa.setNombre("" + jsonObject1.get("nombre"));
                empresa.setTelefono("" + jsonObject1.get("telefono"));
                empresa.setDireccion("" + jsonObject1.get("direccion"));
                empresa.setOcupacion("" + jsonObject1.get("ocupacion"));
                empresa.setEstaSuscrito(Boolean.parseBoolean("" + jsonObject1.get("estaSuscrito")));
                empresa.setContraseña("" + jsonObject1.get("contraseña"));
                empresa.setNit("" + jsonObject1.get("nit"));
                empresa.setNombreEmpresa("" + jsonObject1.get("nombreEmpresa"));
                empresa.setSectorComercial("" + jsonObject1.get("sectorComercial"));
                clienteEmpresa.add(empresa);

            } else {
                System.out.println("Error al ver el tipo de objeto en Clase Json");
            }
        }

        System.out.println("IMPRIMIR LISTA");
        imprimirLista(clientePersona);
        imprimirLista(clienteEmpresa);

    }

//----------------------------------------------------------------------------------------  
    //Busca el archivo en la carpeta del proyecto y lo sobreescribe
    public void sobreescribirLista() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("listaJson.json"))) {
            bw.write(stringLista);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

//----------------------------------------------------------------------------------------  
    public void leerLista() {
        //Trae la lista de la base de datos
        String newStringLista = "";

        try (BufferedReader br = new BufferedReader(new FileReader("listaJson.json"))) {
            String line;
            while ((line = br.readLine()) != null) {
                newStringLista += line;
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        stringLista = newStringLista;
        PosicionObjetos[] lista = gson.fromJson(newStringLista, PosicionObjetos[].class);

//        //listaObjetos = null;
//        for (int i = 0; i < lista.length; i++) {
//            listaObjetos.get(i). = null;
//        }
        for (int i = 0; i < lista.length; i++) {
            agregarALista(lista[i].getTipoObjeto());
        }
    }

//-------------------------------------------------------------------------------------------------------------------------------- 
    //Agrega un nuevo cliente a la listaObjetos, que tiene todos los tipos de cliente
    public void agregarALista(String tipo) {

        //Posicion, es index en donde está en la listaObjetos y en el Json
        PosicionObjetos a = new PosicionObjetos(listaObjetos.size() + 1, tipo);
        listaObjetos.add(a);
        //agregarAListaJson(a);

    }

    //--------------------------------------------------------------------------------------------------------------------------------    
    //Agrega el tipo de cliente al string que tiene todos los tipos, lo agrega en notacion Json
    //Si no está vacio, elimina el ultimo corchete y pone una coma y un salto de linea
    public void agregarAListaJson(String tipo) {
        PosicionObjetos a = new PosicionObjetos(listaObjetos.size(), tipo);
        if (stringLista != "[") {
            stringLista = stringLista.replace("]", "");
            stringLista += ",";

            stringLista += "\n";
        }
        stringLista += gson.toJson(a) + "]";
        System.out.println(stringLista);
        sobreescribirLista();
    }
//

    public void imprimirListaObjetos() {
        System.out.println("IMPRIMIR LISTA OBJETOS");
        for (int i = 0; i < listaObjetos.size(); i++) {
            System.out.print(listaObjetos.get(i) + " ");
            System.out.print(listaObjetos.get(i).getPosicionObjeto() + " ");
            System.out.println(listaObjetos.get(i).getTipoObjeto());
        }
    }

    public void imprimirLista(ArrayList lista) {
        System.out.println("");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }
    }

//--------------------------------------------------------------------------------------------------------------------------------   
}

class PosicionObjetos {

    private int posicionObjeto;
    private String tipoObjeto;

    public PosicionObjetos(int posicionObjeto, String tipoObjeto) {
        this.posicionObjeto = posicionObjeto;
        this.tipoObjeto = tipoObjeto;
    }

    public int getPosicionObjeto() {
        return posicionObjeto;
    }

    public void setPosicionObjeto(int posicionObjeto) {
        this.posicionObjeto = posicionObjeto;
    }

    public String getTipoObjeto() {
        return tipoObjeto;
    }

    public void setTipoObjeto(String tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }

}
