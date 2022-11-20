/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author veronica
 */
public class Nodo <T> {
    private String data;
    private Arbol pArbol;
    private Nodo <T> pNext;

    public Nodo(String o){
        data = o;
        pNext = null;
    }

    public Nodo(Arbol o){
        pArbol = o;
    }

    public Arbol getpArbol() {
        return pArbol;
    }

    public void setpArbol(Arbol pArbol) {
        this.pArbol = pArbol;
    }



    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public Nodo<T> getpNext() {
        return pNext;
    }

    public void setpNext(Nodo<T> pNext) {
        this.pNext = pNext;
    }



}
