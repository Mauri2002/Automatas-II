/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.util.ArrayList;
import java.util.List;

public class InfoSimbolos {
    private String lexema;
    private String token;
    private int repeticiones = 0;
    private String lineas = "";
    private int id;
    private double valor;
    
    //Constructor
    public InfoSimbolos(String lexema, String token, int repeticiones, 
                        int linea, int ID, double valor){
        this.lexema = lexema;
        this.token = token;
        this.repeticiones = repeticiones;
        this.lineas += linea+" ";
        this.id = ID;
        this.valor = valor;
    }
    
    public void incrementarRep(){
        repeticiones++;
    }
    
    public void agregarLineas(int linea){
            lineas+=linea+" ";
        
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public String getLineas() {
        return lineas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id++;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        System.out.printf(" |%15s |%15s |%15s |%20s |%10s |%10s |",lexema,token,repeticiones,lineas,id,valor);
        return "";
    }
}
