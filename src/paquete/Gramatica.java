    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package paquete;

/**
 *
 * @author diego
 */
public class Gramatica {
    //Instancia de la clase para leer el archivo de texto
    LecturaArchivo archivo = new LecturaArchivo("src\\paquete\\GramaticaLC.txt");
    //Instancias de la clase Lista para almacenar los terminales, no terminales
    //y las producicones de la gramatica.
    public Lista<String> terminales = new Lista<>();
    public Lista<String> noTerminales = new Lista<>();
    public Lista<String> producciones = new Lista<>();
    //Variable para almacenar cada linea leida
    String linea;
    //Arreglo para almacenar subcadenas obtenidas a partir de dividir una linea
    String[] aux;
    //Arreglo que contiene los terminales
    String[] pTerminal = {"class", "id", "{", "}", "=", "read", "(", ")", ";",
        "write", ",", "enteros", "reales", "int", "float", "+",
        "-", "*"};
    
    String [] ladosD = new String [50];
    String [] terminalesA;
    String [] nTerminales;
    int ld = 0;
    //Constructor de la clase para llamar el metodo archivo
    public Gramatica() {
        archivo();
    }
    //Metodo para analizar una linea de la gramatica y obtener el lado derecho
    //de una produccion
    public void LadoD(String linea) {
        aux = linea.split("→");
        //agrega el lado derecho a la lista de producciones 
        producciones.agregarAlFinal(aux[1].trim());
        //Guarda el lado derecho
        ladosD[ld] = aux[1].trim();
        ld++;

    }
    
    public boolean noEstaLista(String terminal) {
        boolean flag = true;
        Lista.NodoL<String> nodoActual = terminales.cabeza;
        while (nodoActual != null) {
            if (terminal.equals(nodoActual.dato)) {
                flag = false;
                break;
            }
            nodoActual = nodoActual.siguiente;
        }
        return flag;
    }

    public boolean NoEstaListaNT(String terminal) {
        boolean flag = true;
        Lista.NodoL<String> nodoActual = noTerminales.cabeza;
        while (nodoActual != null) {
            if (terminal.equals(nodoActual.dato)) {
                flag = false;
                break;
            }
            nodoActual = nodoActual.siguiente;
        }
        return flag;
    }
    //procesa una línea de la gramática y extraer los terminales.
    public void Terminales(String linea) {
        aux = linea.split(" ");
        for (int i = 0; i < aux.length; i++) {
            if (esTerminal(aux[i].trim())) {
                if (noEstaLista(aux[i].trim())) {
                    terminales.agregarAlFinal(aux[i]);
                }
            }
        }
        terminalesA = new String[terminales.longitud()];
        Lista.NodoL<String> nodoActual = terminales.cabeza;
        int ter = 0;
        while (nodoActual != null) {
            terminalesA[ter] = nodoActual.dato;
            ter ++;
            nodoActual = nodoActual.siguiente;
        }
    }

    //procesa una línea de la gramática y extraer los no terminales.
    public void NTerminales(String linea) {
        aux = linea.split("→");
        for (int i = 0; i < aux.length; i++) {
            if (NoEstaListaNT(aux[0].trim())) {
                
                noTerminales.agregarAlFinal(aux[0].trim());
            }

        }
        nTerminales = new String [noTerminales.longitud()];
        Lista.NodoL<String> nodoActual = noTerminales.cabeza;
        int nter = 0;
        while (nodoActual != null) {
            nTerminales[nter] = nodoActual.dato;
            nter ++;
            nodoActual = nodoActual.siguiente;
        }
    }

    //Verifica si una cadena es terminal comparandola con los no terminales predefinidos
    public boolean esTerminal(String esT) {
        boolean flag = false;
        for (int i = 0; i < pTerminal.length; i++) {
            if (esT.equals(pTerminal[i])) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    //Metodo para imprimir los lados derechos, terminales y no terminales
    public void imprimir() {
        System.out.println("--------------- LADOS DERECHOS ---------------");
        producciones.imprimirLista();

        System.out.println("--------------- TERMINALES ---------------");
        terminales.imprimirLista();

        System.out.println("--------------- NO TERMINALES ---------------");
        noTerminales.imprimirLista();
    }

    //Abre el archivo de texto, lle linea por liena y llama a los metodos 'LadoD',
    //'Terminales' y 'NTerminales'
    public void archivo() {
        archivo.abrir();
        do {
            linea = archivo.leer();
            if (linea != null) {
                LadoD(linea);
                Terminales(linea);
                NTerminales(linea);
            }
        } while (linea != null);
        imprimir();

    }
    //Devuelve el arreeglo de los Lados derechos
    public String[] getLadosD() {
        
        return ladosD;
    }
    
    public String[] getTerminalA(){
        return terminalesA;
    }
    public String [] getNTerminales(){
        return nTerminales;
    }
    
    
    public static void main(String[] args) {
        Gramatica run = new Gramatica();

    }
    

}
