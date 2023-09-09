/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

/**
 *
 * @author Mauricio
 */
public class Errores {
     private  String lexemas;
    private int linea;
    
 public Errores(String lexemas, int linea){
      this.lexemas=lexemas;
      this.linea=linea;
  } 

    public String getLexemas() {
        return lexemas;
    }

    public void setLexemas(String lexemas) {
        this.lexemas = lexemas;
    }

    public int getLinea() {
        return linea;
    }
    public void sigLinea(int line){
        linea+=line;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    @Override
    public String toString() {
        return "Errores" + "lexemas=" + lexemas + ", linea=" + linea + '}';
    }
    
    
    
}
