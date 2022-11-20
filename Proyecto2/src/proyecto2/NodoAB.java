/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author veronica
 */
public class NodoAB <T> {
    private T data;
    private NodoAB <T> Padre;
    private NodoAB <T> hijo_izq;
    private NodoAB <T> hijo_der;

    public NodoAB(T o){
        data = o;
        Padre = null;
        hijo_izq = null;
        hijo_der = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodoAB<T> getPadre() {
        return Padre;
    }

    public void setPadre(NodoAB<T> Padre) {
        this.Padre = Padre;
    }

    public NodoAB<T> getHijo_der() {
        return hijo_der;
    }

    public void setHijo_der(NodoAB<T> hijo_der) {
        this.hijo_der = hijo_der;
    }

    public NodoAB<T> getHijo_izq() {
        return hijo_izq;
    }

    public void setHijo_izq(NodoAB<T> hijo_izq) {
        this.hijo_izq = hijo_izq;
    }

    


}
