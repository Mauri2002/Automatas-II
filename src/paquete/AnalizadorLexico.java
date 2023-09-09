/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Float.parseFloat;
import java.util.ArrayList;
import java.util.List;
import paquete.Lista.NodoL;

public class AnalizadorLexico {

    //Objeto de las clase Lista para ir guardando los tokens.
    public Lista tokenss;
    //Objeto de la clase interna de Lista
    NodoL recorrerLista;
    //Objeto de la clase Lectura archivo para poder abrir y empiece hacer el 
    //analisis linea por linea
    private LecturaArchivo archivo;

    String auxToken;

    /**
     * Las variables 'apInicio', 'apFinal' y 'linea' Se tutilizan para almacenar
     * el token actualmente analizado, el caracter actual y la linea de codigo
     * que se esta analizando en el momento.
     */
    private String apInicio = "";
    private char apFinal;
    private String linea = "src\\paquete\\archivo1.txt";

    String tokenActual;

    //creamos objeto
    private List<InfoSimbolos> listaSimb = new ArrayList<>();
    int numeroLinea = 1;
    private int asignarID = 499;

    //lista error
    int posLinea = 1;
    private List<Errores> Errlist = new List<>();
    String lineaConError = "";

    //Constructor de la clase donde inicializa la ruta del archivo y llama al metodo analizar()
    public AnalizadorLexico() {
        archivo = new LecturaArchivo(linea);
        tokenss = new Lista();

        System.out.println("----------------------------------------------------------");
        this.analizar();
    }

    //Metodo para poder abrir un archivo de codigo fuente, empieza a leer linea
    //por linea y llama al metodo Tokens para anlizar cada linea
    public void analizar() {
        archivo.abrir();
        while ((linea = archivo.leer()) != null) {
            Tokens();
        }
        //Terminando el ciclo while se cierra el archivo 
        archivo.cerrar();
        //En el objeto 'recorrerLista' guardamos la cabeza del Nodo de la lista
        recorrerLista = tokenss.cabeza;
    }

    /**
     * Metodo donde empieza a hacer el analisis lexico.
     */
    public void Tokens() {
        System.out.println(linea);

        int estado = 0;
        for (int i = 0; i < linea.length(); i++) {
            apFinal = linea.charAt(i);

            switch (estado) {
                case 0:
                    //caracteres  que empiecen con minusculas
                    if (apFinal >= 'a' && apFinal <= 'z') {
                        apInicio += apFinal;
                        estado = 5;
                    } //Caracteres que empiecen con algun caracter simples permitidos
                    else if (apFinal == '{' || apFinal == '}' || apFinal == '='
                            || apFinal == '(' || apFinal == ')' || apFinal == ';'
                            || apFinal == ',' || apFinal == '+' || apFinal == '-'
                            || apFinal == '*') {
                        apInicio += apFinal;

                        i--;
                        estado = 4;
                    } //IDENTIFICADORES
                    //Caracteres que empiecen con mayuscula
                    else if (apFinal >= 'A' && apFinal <= 'Z') {
                        apInicio += apFinal;
                        estado = 1;
                    } //CERO Y DECIMAL
                    //Si empieza con 0
                    else if (apFinal == '0') {
                        apInicio += apFinal;
                        estado = 8;
                    } //NUMEROS ENTEROS
                    //Si empieza dentro del rango entre 1 y 9
                    else if (apFinal >= '1' && apFinal <= '9') {
                        apInicio += apFinal;
                        estado = 2;
                    }
                    break;
                case 1:
                    //Estado donde se van los identificadores
                    if (apFinal >= 'a' && apFinal <= 'z' || apFinal >= '0' && apFinal <= '9' || apFinal == '_') {
                        apInicio += apFinal;
                    } else if (apFinal == '{' || apFinal == '}' || apFinal == '='
                            || apFinal == '(' || apFinal == ')' || apFinal == ';'
                            || apFinal == ',' || apFinal == '+' || apFinal == '-'
                            || apFinal == '*' || apFinal == ' ') {
                        i--;
                        tokenss.agregarAlFinal(apInicio, "id");
//(STR)lexema - (STR)token - (INT)repeticiones - (INT)linea - (INT)ID - (DBL)valor
//Verificamos si el simbolo existe
                        InfoSimbolos existeSimbolo = buscarEnListaSimbolos(apInicio);
                        if (existeSimbolo != null) {
                            existeSimbolo.incrementarRep();
                            existeSimbolo.agregarLineas(numeroLinea);
                        } else {
                            asignarID++;
                            listaSimb.add(new InfoSimbolos(apInicio, "id", 0, numeroLinea, asignarID, 0.0));
                        }
                        apInicio = "";

                        estado = 0;
                    } else if (apFinal == '\n') {

                        tokenss.agregarAlFinal(apInicio, "id");
                        apInicio = "";
                        estado = 0;
                    } else {

                        tokenss.agregarAlFinal(apInicio, "id");
                        apInicio = "";
                        estado = 7;
                    }
                    break;
                //Estado donde se quedan los numeros enteros
                case 2:
                    //Si hay un punto despues de un numero entero pasa al estado 3
                    if (apFinal == '.') {
                        apInicio += apFinal;
                        estado = 3;
                    } else if (apFinal >= '0' && apFinal <= '9') {
                        apInicio += apFinal;
                    } else if (apFinal == '{' || apFinal == '}' || apFinal == '='
                            || apFinal == '(' || apFinal == ')' || apFinal == ';'
                            || apFinal == ',' || apFinal == '+' || apFinal == '-'
                            || apFinal == '*' || apFinal == ' ') {
                        i--;
                        tokenss.agregarAlFinal(apInicio, "enteros");
//Verificamos si el simbolo existe
                        InfoSimbolos existeSimbolo = buscarEnListaSimbolos(apInicio);
                        if (existeSimbolo != null) {
                            existeSimbolo.incrementarRep();
                            existeSimbolo.agregarLineas(numeroLinea);
                        } else {
                            asignarID++;
                            listaSimb.add(new InfoSimbolos(apInicio, "enteros", 0, numeroLinea, asignarID, Integer.parseInt(apInicio)));
                        }
                        apInicio = "";
                        estado = 0;
                    } else {
                        tokenss.agregarAlFinal(apInicio, "enteros");
                        apInicio = "";
                        estado = 7;
                    }
                    break;
                //DESPUES DEL PUNTO
                case 3:
                    //Estado donde se van los flotantes 
                    if (apFinal >= '0' && apFinal <= '9') {
                        apInicio += apFinal;
                    } else if (apFinal == '{' || apFinal == '}' || apFinal == '='
                            || apFinal == '(' || apFinal == ')' || apFinal == ';'
                            || apFinal == ',' || apFinal == '+' || apFinal == '-'
                            || apFinal == '*' || apFinal == ' ') {
                        i--;
                        tokenss.agregarAlFinal(apInicio, "float");
//listaSimb.add(new InfoSimbolos(apInicio, "float", 1, numeroLinea, 500, 0.0));
//Verificamos si el simbolo existe
                        InfoSimbolos existeSimbolo = buscarEnListaSimbolos(apInicio);
                        if (existeSimbolo != null) {
                            existeSimbolo.incrementarRep();
                            existeSimbolo.agregarLineas(numeroLinea);
                        } else {
                            asignarID++;
                            listaSimb.add(new InfoSimbolos(apInicio, "float", 0, numeroLinea, asignarID, Float.parseFloat(apInicio)));
                        }
                        apInicio = "";
                        estado = 0;
                    } else if (apFinal >= 'a' && apFinal <= 'z') {
                        tokenss.agregarAlFinal(apInicio, "float");
                        apInicio = "";
                        i--;
                        estado = 0;
                    } else {
                        tokenss.agregarAlFinal(apInicio, "float");
                        apInicio = "";
                        estado = 7;
                    }
                    break;
                case 4:
                    //Estado donde se van los caracteres simples 
                    if (apFinal == '{' || apFinal == '}' || apFinal == '='
                            || apFinal == '(' || apFinal == ')' || apFinal == ';'
                            || apFinal == ',' || apFinal == '+' || apFinal == '-'
                            || apFinal == '*') {
                        tokenss.agregarAlFinal(apInicio, apInicio);

                        apInicio = "";
                        estado = 0;
                    } else if (apFinal >= 'A' && apFinal <= 'Z') {
                        apInicio = "";
                        estado = 0;
                    } else if (apFinal <= '0' && apFinal >= '9') {
                        apInicio += apFinal;
                        estado = 0;
                    } else if (esReservada(apInicio)) {
                        tokenss.agregarAlFinal(apInicio, apInicio);

                        apInicio = "";
                        estado = 0;
                    } else {
                        tokenss.agregarAlFinal(apInicio, apInicio);

                        apInicio = "";
                        estado = 7;
                    }
                    break;
                //Estado donde se van las palabras reservadas
                case 5:
                    if (apFinal >= 'a' && apFinal <= 'z') {
                        apInicio += apFinal;
                        if (esReservada(apInicio)) {
                            tokenss.agregarAlFinal(apInicio, apInicio);

                            apInicio = "";
                            estado = 0;
                        }

                    } else if (apFinal == '{' || apFinal == '}' || apFinal == '='
                            || apFinal == '(' || apFinal == ')' || apFinal == ';'
                            || apFinal == ',' || apFinal == '+' || apFinal == '-'
                            || apFinal == '*') {
                        apInicio += apFinal;
                        estado = 0;
                    } else if (apFinal <= '0' && apFinal >= '9') {
                        if (esReservada(apInicio)) {
                            apInicio += apFinal;
                            i--;
                            estado = 0;
                        }
                    } else if (apFinal == ' ') {
                        tokenss.agregarAlFinal(apInicio, apInicio);

                        apInicio = "";
                        estado = 0;
                    } else {
                        tokenss.agregarAlFinal(apInicio, apInicio);
                        apInicio = "";
                        estado = 7;
                    }
                    break;
                //Estado de errrores
                case 7:
                    tokenss.agregarAlFinal(apInicio, apInicio);
                    /*Errores error = buscaError(apInicio);
                   if(error == null){
                       error.sigLinea(posLinea);
                   }else{
                       Errlist.add(new Errores(apInicio, "Error",0,posLinea));
                       
                   }*/
                    // Agrega la cadena actual a la línea con error
                    lineaConError += apInicio;
                    // Agrega la cadena a la lista de errores
                    tokenss.agregarAlFinal(apInicio, apInicio);
                       Errores error = buscaError(apInicio);
                    if (error == null) {
                        error.sigLinea(posLinea);
                    } else {
                        Errlist.add(new Errores(apInicio, posLinea));
                    }

                    break;
                case 8:
                    //Estado de numero 0
                    if (apFinal == '.') {
                        apInicio += apFinal;
                        estado = 3;
                    } else if (apFinal == '{' || apFinal == '}' || apFinal == '='
                            || apFinal == '(' || apFinal == ')' || apFinal == ';'
                            || apFinal == ',' || apFinal == '+' || apFinal == '-'
                            || apFinal == '*') {
                        apInicio += apFinal;
                        estado = 0;
                    } else if (apFinal >= 'a' && apFinal <= 'z') {
                        apInicio += apFinal;
                        estado = 0;
                    } else if (apFinal == ' ') {
                        tokenss.agregarAlFinal(apInicio, "enteros");
//Verificamos si el simbolo existe
                        InfoSimbolos existeSimbolo = buscarEnListaSimbolos(apInicio);
                        if (existeSimbolo != null) {
                            existeSimbolo.incrementarRep();
                            existeSimbolo.agregarLineas(numeroLinea);
                        } else {
                            asignarID++;
                            listaSimb.add(new InfoSimbolos(apInicio, "enteros", 0, numeroLinea, asignarID, 0.0));
                        }
                        apInicio = "";
                        estado = 0;
                    }

            }
        }
        numeroLinea++;
     // Después de salir del bucle for, verifica si hay una línea con error y la imprime
     if (!lineaConError.isEmpty()) {
    System.out.println("Línea con error: " + lineaConError);
}
    }
    
    //Metodo tipo booleano para ssaber si pertenece a alguna reservada
    public boolean esReservada(String r) {
        return "class".equals(r) || "float".equals(r)
                || "int".equals(r) || "read".equals(r)
                || "write".equals(r);
    }

    //Metodo para obtener el siguiente token del analisisi sintactico
    //devuelve el token actual 
    public String mandarToken() {
        // si recorrerLista no es nulo a la variable auxToken recorre la lista y
        //se le agrega su descripciom del token
        if (recorrerLista != null) {
            auxToken = recorrerLista.descripcion.toString();
            recorrerLista = recorrerLista.siguiente;
            return auxToken;
        } else {
            System.out.println("Fin del programa");
            return "$";
        }
    }

    //Metodo gettrer para obtener la lista de los tokens
    public Lista getListaToken() {
        return tokenss;
    }

    public List<InfoSimbolos> getInfoSimbolos() {
        return listaSimb;
    }

    public void guardarTablaSimbolos() {
        try {
            String rutaArchivo = "D:\\proyectos de Netbins\\1_A_AnalizadorLS\\src\\paquete\\simbolos.txt";
            BufferedWriter escribir = new BufferedWriter(new FileWriter(rutaArchivo));

            // Encabezado del archivo
            escribir.write("Lexema\t\tToken\t\tRepeticiones\t\tLineas\t\tValor\n");
            escribir.write("------\t\t-----\t\t------------\t\t------\t\t-----\n");

            // Escribir la información de cada símbolo en el archivo
            for (InfoSimbolos listaSimb : listaSimb) {
                escribir.write(listaSimb.getLexema()
                        + "\t\t" + listaSimb.getToken()
                        + "\t\t" + listaSimb.getRepeticiones()
                        + "\t\t" + listaSimb.getLineas()
                        + "\t\t\t" + listaSimb.getValor() + "\n");
            }

            escribir.close();
            System.out.println("Tabla de símbolos guardada en TablaSimbolos.txt");
        } catch (IOException e) {
            System.out.println("Error al guardar la tabla de símbolos: " + e.getMessage());
        }
    }

    //Metodo para buscar simbolo en lista
    private InfoSimbolos buscarEnListaSimbolos(String lexema) {
        for (InfoSimbolos simbolo : listaSimb) {
            if (simbolo.getLexema().equals(lexema)) {
                return simbolo;
            }
        }
        return null;
    }

    //busca simbilo en la lista 
    private Errores buscaError(String lexemas) {
        for (Errores simbol : Errlist) {
            if (simbol.getLexemas().equals(lexemas)) {
                return simbol;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        AnalizadorLexico obj = new AnalizadorLexico();
        AnalizadorLexico obj2 = new AnalizadorLexico();
        obj.tokenss.imprimirLista(1);

        System.out.println("\n\n\n\n\n\n\n----------------------------------------------------------\n"
                + "                        TABLA SIMBOLOS\n"
                + "----------------------------------------------------------");
        System.out.printf(" |%15s |%15s |%15s |%20s |%10s |%10s |\n", "LEXEMA", "TOKEN", "REPETICIONES", "LINEAS", "ID", "VALOR");
        for (InfoSimbolos listaSimb : obj.listaSimb) {
            listaSimb.incrementarRep();
            System.out.println(listaSimb.toString());
        }

        obj.guardarTablaSimbolos();


        System.out.printf(" |%15s |%15s |%15s |%20s |%10s |%10s |\n", "LEXEMA");

    }
}
/* Después de salir del bucle for, verifica si hay una línea con error y la imprime
if (!lineaConError.isEmpty()) {
    System.out.println("Línea con error (Linea " + numeroLinea + "): " + lineaConError);
}
numeroLinea++;
lineaConError = ""; // Reinicia la variable para la siguiente línea
*/