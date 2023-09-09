/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

/**
 *
 * @author diego
 */
public class Nodo<T> {
    private T contenido;
    //Referencia al nodo siguiente.
    private Nodo<T> siguiente;
    //Constructor
    public Nodo(T contenido) {
        this.contenido = contenido;
        this.siguiente = null;
    }
    //Devuelve el contenido del nodo
    public T getContenido() {
        return contenido;
    }
    //devuelve el siguiente nodo de la lista enlazada
    public Nodo<T> getSiguiente() {
        return siguiente;
    }
    //Establece el siguiente nodo en la lista enlazada, toma el argumento
    //'siguiente' de tipo 'Nodo<T>' se le asigna ese nodo como el siguiente nodo
    //enlazado al nodo actual
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

}
