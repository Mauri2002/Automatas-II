/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

/**
 *
 * @author diego
 */

public class Matriz {
    
    //Arreglo bidimensional de enteros, representa el numero de cada produccion
    int[][] matrizP = {{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       { 0, 2, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 2, 2, 0, 0, 0},
                       { 0, 3, 0, 4, 0, 0, 3, 0, 0, 3, 0, 0, 0, 3, 3, 0, 0, 0},
                       { 0, 6, 0, 0, 0, 0, 7, 0, 0, 8, 0, 0, 0, 5, 5, 0, 0, 0},
                       { 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       { 0, 0, 0, 0,11, 0, 0, 0,11, 0,10, 0, 0, 0, 0, 0, 0, 0},
                       { 0,12, 0, 0, 0, 0, 0,12, 0, 0, 0,12,12, 0, 0, 0, 0, 0},
                       { 0, 0, 0, 0,13, 0, 0, 0,14, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       { 0,15, 0, 0, 0, 0, 0,15, 0, 0, 0,15,15, 0, 0, 0, 0, 0},
                       { 0, 0, 0, 0,17, 0, 0, 0,17, 0, 0, 0, 0, 0, 0,16,16,16},
                       { 0,19, 0, 0, 0, 0, 0,18, 0, 0, 0,20,21, 0, 0, 0, 0, 0},
                       { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,22,23, 0, 0, 0},
                       { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,24,25,26},
                       {27, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        //Arreglo bidimensional de String, su unica funcion es poder vizualizarla 
        String[][] matrizT = {
        {"No.terminales", "class", "id", "{", "}", "; ", "=", "read", "( ", ") ", "write", ", ", "enteros", "reales", "int", "float", "+ ", "- ", "* "},
        {"programa     ", "1  ", "  0 ", "0", "0", "0 ", "0", "0   ", "0 ", "0 ", "0    ", "0 ", "0      ", "0     ", "0  ", "0    ", "0 ", "0 ", "0 "},
        {"lista_sent   ", "0    ", "2 ", "0", "0", "0 ", "0", "2   ", "0 ", "0 ", "2    ", "0 ", "0      ", "0     ", "2  ", "2    ", "0 ", "0 ", "0 "},
        {"sent_final   ", "0    ", "3 ", "0", "4", "0 ", "0", "3   ", "0 ", "0 ", "3    ", "0 ", "0      ", "0     ", "3  ", "3    ", "0 ", "0 ", "0 "},
        {"sentencia    ", "0    ", "6 ", "0", "0", "0 ", "0", "7   ", "0 ", "0 ", "8    ", "0 ", "0      ", "0     ", "5  ", "5    ", "0 ", "0 ", "0 "},
        {"list_id      ", "0    ", "9 ", "0", "0", "0 ", "0", "0   ", "0 ", "0 ", "0    ", "0 ", "0      ", "0     ", "0  ", "0    ", "0 ", "0 ", "0 "},
        {"id_final     ", "0    ", "0 ", "0", "0", "11", "0", "0   ", "0 ", "11", "0    ", "10", "0      ", "0     ", "0  ", "0    ", "0 ", "0 ", "0 "},
        {"lista_expr   ", "0    ", "12", "0", "0", "0 ", "0", "0   ", "12", "0 ", "0    ", "0 ", "12     ", "12    ", "0  ", "0    ", "0 ", "0 ", "0 "},
        {"list_expr_fin", "0    ", "0 ", "0", "0", "13", "0", "0   ", "0 ", "14", "0    ", "0 ", "0      ", "0     ", "0  ", "0    ", "0 ", "0 ", "0 "},
        {"expresion    ", "0    ", "15", "0", "0", "0 ", "0", "0   ", "15", "0 ", "0    ", "0 ", "15     ", "15    ", "0  ", "0    ", "0 ", "0 ", "0 "},
        {"expr_final   ", "0    ", "0 ", "0", "0", "17", "0", "0   ", "0 ", "17", "0    ", "0 ", "0      ", "0     ", "0  ", "0    ", "16", "16", "16"},
        {"expr_arit    ", "0    ", "19", "0", "0", "0 ", "0", "0   ", "18", "0 ", "0    ", "0 ", "20     ", "21    ", "0  ", "0    ", "0 ", "0 ", "0 "},
        {"tipo         ", "0    ", "0 ", "0", "0", "0 ", "0", "0   ", "0 ", "0 ", "0    ", "0 ", "0      ", "0     ", "22 ", "23   ", "0 ", "0 ", "0 "},
        {"operador     ", "0    ", "0 ", "0", "0", "0 ", "0", "0   ", "0 ", "0 ", "0    ", "0 ", "0      ", "0     ", "0  ", "0    ", "24", "25", "26"},
        {"inicio       ", "27   ", "0 ", "0", "0", "0 ", "0", "0   ", "0 ", "0 ", "0    ", "0 ", "0      ", "0     ", "0  ", "0    ", "0 ", "0 ", "0 "}};


        
        
    
    public void impirmir(){
        System.out.println("------------------------------------ MATRIZ PREDICTIVA ------------------------------------");
        for (int i = 0; i < matrizT.length; i++) {
            for (int j = 0; j < matrizT[i].length; j++) {
                System.out.print(matrizT[i][j] + " ");
            }
            System.out.println();
        }
    }   

    //Metodo getter que devuelve la matrizP (el arreglo bidimensional de enteros)
    public int[][] getMatrizInt() {
        return matrizP;
    }

    
}