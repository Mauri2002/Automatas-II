/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class Lista<T> {
    
    //Referencia al primer nodo de la lista
    public NodoL<T> cabeza;
    private int longitud;

    public Lista() {
        cabeza = null;
        longitud = 0;
    }

    // Clase interna Nodo
    public static class NodoL<T> {
        public T dato;
        public T lexema, descripcion;
        public NodoL<T> siguiente;
        //Constructor de la clase nodo interna 
        public NodoL(T dato) {
            this.dato = dato;
            siguiente = null;
        }
        
        public NodoL(T lexema, T descripcion) {
            this.lexema = lexema;
            this.descripcion = descripcion;
            siguiente = null;   
        }
    }

    // Verifica si la lista está vacía
    public boolean estaVacia() {
        return cabeza == null;
    }

    // Devuelve la longitud de la lista
    public int longitud() {
        return longitud;
    }

    // Agrega un elemento al final de la lista
    public void agregarAlFinal(T lexema, T descripcion) {
        NodoL<T> nuevoNodo = new NodoL<>(lexema, descripcion);
        if (estaVacia()) {
            cabeza = nuevoNodo;
        } else {
            NodoL<T> nodoActual = cabeza;
            while (nodoActual.siguiente != null) {
                nodoActual = nodoActual.siguiente;
            }
            nodoActual.siguiente = nuevoNodo;
        }
        longitud++;
    }
    
    //Agrega un elemento al final de la lista
    public void agregarAlFinal(T dato) {
        NodoL<T> nuevoNodo = new NodoL<>(dato);
        if (estaVacia()) {
            cabeza = nuevoNodo;
        } else {
            NodoL<T> nodoActual = cabeza;
            while (nodoActual.siguiente != null) {
                nodoActual = nodoActual.siguiente;
            }
            nodoActual.siguiente = nuevoNodo;
        }
        longitud++;
    }

    // Imprime los elementos de la lista (Imprime elementos de la gramatica)
    public void imprimirLista() {
        NodoL<T> nodoActual = cabeza;
        while (nodoActual != null) {
            System.out.println(nodoActual.dato + " ");
            nodoActual = nodoActual.siguiente;
        }
        System.out.println();
    }
    //Imprime los elementos de la lista con su 'lexema' y 'descripcion'
    //(Imprime elementos del lexico)
    public void imprimirLista(int i) {
        System.out.println("");
        System.out.println("----------------LISTA TOKENS-------------------");
        NodoL<T> nodoActual = cabeza;
        while (nodoActual != null) {
            System.out.println(nodoActual.lexema + "\t" + nodoActual.descripcion);
            nodoActual = nodoActual.siguiente;
        }
        System.out.println("-----------------FIN DE LA LISTA------------------");
    }
/*    
    //NEW ------------------------------------------------------------  
    public void imprimirTablaSimbolos(){
        List<infoIdentificador> listaIdentificador = new ArrayList<>();
        NodoL<T> nodoActual = cabeza;
        int numeroLinea = 1;
        
        while(nodoActual != null){
            if(esIdentificador(nodoActual.dato)){
                boolean encontrado = false;
                
                for(infoIdentificador info: listaIdentificador){
                    if(info.getIdentificador().equals(nodoActual.dato)){
                        System.out.println("Antes del if: comparar");
                        info.incrementarRep();
                        info.saberNumLinea(numeroLinea);
                        encontrado = true;
                        break;
                    }
                }
                
                if(!encontrado){
                    infoIdentificador info = new infoIdentificador(nodoActual.dato);
                    info.incrementarRep();
                    info.saberNumLinea(numeroLinea);
                    listaIdentificador.add(info);
                }
            }
            
            nodoActual = nodoActual.siguiente;
            numeroLinea++;
        }
        
        for(infoIdentificador info: listaIdentificador){
            System.out.println("Identificador: "+info.getIdentificador());
            System.out.println("Repeticiones: "+info.getRepeticiones());
            System.out.println("Lineas: "+info.getLineas());
        }
    }
        
    
    
    private boolean esIdentificador(T dato){
        //Logica
        return true;
    }
    
    private class infoIdentificador{
        private T identificador;
        private int repeticiones;
        private List<Integer> lineas;
        NodoL<T> nodoActual = cabeza;
        
        public infoIdentificador(T identificador){
            this.identificador = identificador;
            repeticiones = 0;
            lineas = new ArrayList<>();
        }
        
        public T getIdentificador() {
            if(nodoActual.descripcion.equals("id"))
                identificador = nodoActual.lexema;
            return identificador;
        }
        
        public void incrementarRep(){
            repeticiones++;
        }
        
        public void saberNumLinea(int numLinea){
            lineas.add(numLinea);
        }
        
        public int getRepeticiones(){
            return repeticiones;
        }
        
        public List<Integer> getLineas(){
            return lineas;
        }
        
    }
    
}
*/
}

