/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 * Clase nodo para la clase arbol
 * @author Alfredo Herrera
 * @param <T>
 */
public class NodoAB <T> {
    private String data;
    private NodoAB <T> Padre;
    private NodoAB <T> hijo_izq;
    private NodoAB <T> hijo_der;

    /**
     *
     * @param o
     */
    public NodoAB(String o){
        data = o;
        Padre = null;
        hijo_izq = null;
        hijo_der = null;
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
    public NodoAB<T> getPadre() {
        return Padre;
    }

    /**
     *
     * @param Padre
     */
    public void setPadre(NodoAB<T> Padre) {
        this.Padre = Padre;
    }

    /**
     *
     * @return
     */
    public NodoAB<T> getHijo_der() {
        return hijo_der;
    }

    /**
     *
     * @param hijo_der
     */
    public void setHijo_der(NodoAB<T> hijo_der) {
        this.hijo_der = hijo_der;
    }

    /**
     *
     * @return
     */
    public NodoAB<T> getHijo_izq() {
        return hijo_izq;
    }

    /**
     *
     * @param hijo_izq
     */
    public void setHijo_izq(NodoAB<T> hijo_izq) {
        this.hijo_izq = hijo_izq;
    }

    /**
     * Devuelve el numero de nodos a dibijar en la representación del arbol binario
     * @param n
     * @return
     */
    public int nodosCompletos(NodoAB n){
        if(n == null){
            return 0;
        }else{
            if(n.getHijo_izq() != null && n.getHijo_der() != null){
                return nodosCompletos(n.getHijo_izq()) + nodosCompletos(n.getHijo_der()) + 1;
            }
            return nodosCompletos(n.getHijo_izq()) + nodosCompletos(n.getHijo_der());      
        }
    }


}
