/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 * Clase para iniciar el dibujaod del arbol binario
 * @author Daniel Fiallo
 */
public class Controlador {
    private Lienzo objLienzo;
    private Arbol objArbol;

    /**
     *
     * @param l
     * @param a
     */
    public Controlador(Lienzo l, Arbol a){
        this.objLienzo = l;
        this.objArbol = a;
    }

    /**
     *
     */
    public void iniciar(){
        this.objLienzo.setObjArbol(this.objArbol);
    }

    
}
