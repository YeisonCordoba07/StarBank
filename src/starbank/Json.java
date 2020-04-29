/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbank;

import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author YEISON
 */
public class Json {

    String stringJson = "";
    Gson gson = new Gson();

    public void agregarCliente(Cliente nuevoCliente) {
        stringJson = "[" + gson.toJson(nuevoCliente) + "]";
        buscarYAgregar();
    }

    public void buscarYAgregar() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("pruebaJson.json"))) {
            bw.write(stringJson);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
