/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

import java.util.Stack;

/**
 *
 * @author diego
 */
public class Pila<T> {
    //Referencia al nodo del tope 
    private Nodo<T> tope;
    //Constructor
    public Pila() {
        this.tope = null;
    }
    //Metodo push
    public void push(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if (tope == null) {
            tope = nuevoNodo;
        } 
        else {
            nuevoNodo.setSiguiente(tope);
            tope = nuevoNodo;
        }
    }
    //metodo pop
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T elemento = tope.getContenido();
        tope = tope.getSiguiente();
        return elemento;
    }
    //verifica si la pila esta vacia
    public boolean isEmpty() {
        return tope == null;
    }
    
    //Devuelve el tope de la pila sin eliminarlo
    public T tope(){
        T nul = null;
        //si el tope es nulo devuelve nulo
        if (tope == null) {
            return nul;
        }
        //Vuelve al contenido del tope actual
        return tope.getContenido();
    }


}
