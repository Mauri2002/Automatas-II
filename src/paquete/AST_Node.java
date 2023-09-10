/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.util.Map;

/**
 *
 * @author Mauricio
 */
public class AST_Node {

}
//clase base para los nodos AST

abstract class AstNode {

    public abstract void generateSymbolTable(Map<String, Integer> symbolTable);
}

//definir  dos tipos de nodos: uno para declaracion de variables y otro para bloques de codigo que tienen variables declaradas
//nodo para declaracion de variable
class NodeVarialDeclare extends AstNode {

    private String varialName;

    public NodeVarialDeclare(String varialName) {
        this.varialName = varialName;
    }

    @Override
    public void generateSymbolTable(Map<String, Integer> symbolTable) {
        // Agregar la variable a la tabla de símbolos con un valor inicial (por ejemplo, 0)
        symbolTable.put(varialName, 0);
    }
}

//nodo para bloques de codigo que contienen declaracion de variables
class BloqueNode extends AstNode {

    private AstNode[] statements;

    public BloqueNode(AstNode[] statements) {
        this.statements = statements;
    }

    @Override
    public void generateSymbolTable(Map<String, Integer> symbolTable) {
        //genera una tabla de simbolos para cada bloque declarado 
        for (AstNode statement : statements) {
            statement.generateSymbolTable(symbolTable);
        }
    }
}
