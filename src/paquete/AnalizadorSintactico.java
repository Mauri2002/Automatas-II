 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author diego
 */

public class AnalizadorSintactico {

    //OBJETOS DE LAS CLASES
    private Pila<String> pilaT = new Pila<>();
    private AnalizadorLexico aL = new AnalizadorLexico();
    private Matriz matriz = new Matriz();
    private Gramatica gramatica = new Gramatica();
    

    //Metodo que hara el analisis sintactico de lo que le entregue el lexico
    public void analisisS() {
        String x, a;
        int posLD = 0;
        pilaT.push("inicio");
        x = pilaT.tope();
        a = aL.mandarToken();
        System.out.println();
        System.out.println("---------------------- Analisis sintactico -------------------------");
        //Inicio de bucle while mientras que la pila no esta vacia 
        while (!pilaT.isEmpty()) {
            //salida con a y x
            if (esNoT(x)) { //Si esta en los terminales
                posLD = matriz.getMatrizInt()[posX(x.trim())][posA(a.trim())];
                if (posLD != 0) {
                    pilaT.pop();
                    //Imprime rl tope de la pila que sera 'x'
                    System.out.println("El tope de la pila es: " + x);
                    //Imprime el tojen que se va a analizar 'a'
                    System.out.println("El token a analizar es: " + a);
                    //numero de produccion que te arrojo la matriz
                    System.out.print("Su produccion es: " + posLD);
                    meterEnPila(posLD-1);
                    //'x' sera el tope de la pila actual
                    x = pilaT.tope();
                } else {
                    //esto es error de sintaxix
                    System.out.println("El analizador detecto un error, el programa se detendra");
                    System.out.println("Tope: " + x);
                    System.out.println("Analizar: " + a);
                    matriz.impirmir();
                    System.exit(0);
                }
                
            } else { //No esta en los terminales
                System.out.println("Comparando 'x' con 'a' para saber si son iguales...");
                if (x.equals(a)) {
                    pilaT.pop();
                    System.out.println("El tope de la pila es: " + x);
                    System.out.println("El token a analizar es: " + a);
                    System.out.println("----------------------------------");
                    //Actualizar 'a' y 'x'
                    a = aL.mandarToken();
                    x = pilaT.tope();
                } else {
                    //esto es otro error
                    //Al igual con el caso anterior en el else si no cumple sera un error.
                    System.out.println("El analizador detecto un error, el programa se detendra");
                    System.out.println("Tope: " + x);
                    System.out.println("Analizar: " + a);
                    matriz.impirmir();
                    System.exit(0);
                }
            }
        }
        //Terminando el bule simplemente imprime la amtriz predictiva para poder visualizarla.
        matriz.impirmir();
    }

    //Metodo tipo booleano para verificar si una cadena de String es un no terminal 
    public boolean esNoT(String x) {
        boolean flag = false;
        for (int i = 0; i < gramatica.getNTerminales().length; i++) {
            if (x.equals(gramatica.getNTerminales()[i])) {
                flag = true;
                break;
            }
        }
        //Si retotna true 'x' es un terminal de caso contarrio sera false
        return flag;
    }


    public int posX(String x) {
        int posicionX = 0;
        //Recorre los elementos del arreglo getnTerminales
        for (int i = 0; i < gramatica.getNTerminales().length; i++) {
            if (x.equals(gramatica.getNTerminales()[i])) {
                posicionX = i;
                break;
            }
        }
        //posicion del arreglo de x
        return posicionX;
    }

    public int posA(String a) {
        int posicionA = 0;
        //Recorre los elementos del arreglo de getTerminales
        for (int i = 0; i < gramatica.terminalesA.length; i++) {
            if (a.equals(gramatica.terminalesA[i])) {
                posicionA = i;
                break;
            }
        }
        //posicion del arreglo de a
        return posicionA;
    }

    public void meterEnPila(int posicion) {
        String aux = gramatica.getLadosD()[posicion];
        System.out.println(" " + aux);
        System.out.println("----------------------------------");
        if(aux.contains(" ")){
            String [] aux2 = gramatica.getLadosD()[posicion].split(" ");
            //Ciclo for que recorre los elementos de 'aux2' sera uno de los elementos
            //de la derecha de la produccion gramatical.
            for (int i = aux2.length - 1; i >= 0; i--) {
                /**Si es diferente a epsilon (ε) se pone en la pila 'aux2' (se hace
                 * un push)
                 */
                if(!aux2[i].trim().equals("ε")){
                    pilaT.push(aux2[i]);
                }   
            }
        }else{
            //Si aux es difetente a epsilon se hace un push con aux en la pila 
            if(!aux.trim().equals("ε")){
                pilaT.push(aux);
            }   
        }
    }

    public static void main(String[] args) {
        AnalizadorSintactico aS = new AnalizadorSintactico();
        aS.analisisS();

    }
}
