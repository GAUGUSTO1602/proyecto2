/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 * Clase nodo para las pilas
 * @author Daniel Fiallo
 * @param <T>
 */
public class Nodo <T> {
    private String data;
    private Arbol pArbol;
    private Nodo <T> pNext;

    /**
     *
     * @param o
     */
    public Nodo(String o){
        data = o;
        pNext = null;
    }

    /**
     *
     * @param o
     */
    public Nodo(Arbol o){
        pArbol = o;
    }

    /**
     *
     * @return
     */
    public Arbol getpArbol() {
        return pArbol;
    }

    /**
     *
     * @param pArbol
     */
    public void setpArbol(Arbol pArbol) {
        this.pArbol = pArbol;
    }

    /**
     *
     * @return
     */
    public String getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
    public Nodo<T> getpNext() {
        return pNext;
    }

    /**
     *
     * @param pNext
     */
    public void setpNext(Nodo<T> pNext) {
        this.pNext = pNext;
    }



}
