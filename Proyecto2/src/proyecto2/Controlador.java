/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author veronica
 */
public class Controlador {
    private Lienzo objLienzo;
    private Arbol objArbol;

    public Controlador(Lienzo l, Arbol a){
        this.objLienzo = l;
        this.objArbol = a;
    }

    public void iniciar(){
        this.objLienzo.setObjArbol(this.objArbol);
    }

    
}
