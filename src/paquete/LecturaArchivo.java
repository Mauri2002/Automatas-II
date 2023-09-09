/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package paquete;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class LecturaArchivo {

    String filename;
    Scanner lector;

    //Constructor que representa el nombre del archivo que se desea leer.
    public LecturaArchivo(String filename) {
        this.filename = filename;
    }
    //Metodo para poder abrir el archivo
    public void abrir(){
        try {
            lector = new Scanner(new File(filename));
        } catch (IOException e) {
            System.out.println("Hay un problema con el archivo " + filename + e.getMessage());
            e.printStackTrace();
        }
    }
    //Lee el archivo linea por linea 
    public String leer(){
        if (lector != null && lector.hasNextLine()) {
            return lector.nextLine();
        }else{
            cerrar();
            return null;
        }
    }
    //Metodo para cerrar el archivo despues de leerlo.
    public void cerrar(){
        if (lector != null) {
            lector.close();
        }
    }
    
}
