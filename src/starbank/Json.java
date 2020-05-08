/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbank;

import com.google.gson.Gson;
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

    String stringJson = "[";
    Gson gson = new Gson();
    public static Json objetoJson = new Json();

    public static ArrayList<PosicionObjetos> listaObjetos = new ArrayList<PosicionObjetos>();//Guarda el numero de objetos que hay en el archivo Json y también contiene su tipo
    //Para saber si el cliente se guarda definitivamente en persona o en empresa, se mira el tipo y se cambia de empresa a persona
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

//--------------------------------------------------------------------------------------------------------------------------------   
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
    public void leerJson() 
    {
        System.out.println("holaaaaa");
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
        System.out.println("askdjfañsd");
        Object[] clientes = gson.fromJson(newStringJson, ClientePersona[].class);
        System.out.println("holld");
        imprimirListaObjetos();
        //Aquí hay que guardar los datos en un tipo de archivo que debe ser Cliente Persona, o Cliente Empresa
        //Pero si pongo ClientePersona, los datos como nit, se pierden.
        //Y si pongo ClienteEmpresa, los que sean Cliente persona tendrán atributos como el nit en null
        //Si lo pongo como ClienteEmpresa se soluciona por ahora, pero si en un futuro aparece un nuevo cliente
        //con otro atrubuto diferente, ya no funcionaria y estariamos en el mismos problema
        //Lo mismo pasa con operacion y sus hijos
        ArrayList<ClientePersona> clientePersona = new ArrayList<ClientePersona>();
        ArrayList<ClienteEmpresa> clienteEmpresa = new ArrayList<ClienteEmpresa>();
        for (int i = 0; i <= listaObjetos.size(); i++) {
            if (listaObjetos.get(i).tipoObjeto == "Persona") {
                
                //Añade un cliente persona a la lista, para agregarlo va a la listaObjetos y mira cuales objetos coinciden con su tipo
                //A estos les pide la posicion que tienen en el vector donde estan almacenados (clientes), los va a buscar y los agrega
                clientePersona.add(   (ClientePersona)clientes   [listaObjetos.get(i).getPosicionObjeto()-1]      );
            }
            else if(listaObjetos.get(i).tipoObjeto == "Empresa"){
                clienteEmpresa.add((ClienteEmpresa)clientes[listaObjetos.get(i).getPosicionObjeto()-1]);
            }
            else{
                System.out.println("Error al ver el tipo de objeto en Clase Json");
            }
        }
        imprimirListaObjetos();

    }

//--------------------------------------------------------------------------------------------------------------------------------    
//    public String retornaTipoCliente(int a) {
//        return (String) vectorJson[a][2];
//    }
    public void agregarALista(String tipo) {

        //Posicion, es index en donde está en la listaObjetos y en el Json
        PosicionObjetos a = new PosicionObjetos(listaObjetos.size() + 1, tipo);
        listaObjetos.add(a);

    }
//

    public void imprimirListaObjetos() {
        System.out.println("");
        for (int i = 0; i < listaObjetos.size(); i++) {
            System.out.print(listaObjetos.get(i) +" ");
            System.out.print(listaObjetos.get(i).getPosicionObjeto()+" ");
            System.out.println(listaObjetos.get(i).getTipoObjeto());
        }
    }

//--------------------------------------------------------------------------------------------------------------------------------   
}

class PosicionObjetos {

    public int posicionObjeto;
    public String tipoObjeto;

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
