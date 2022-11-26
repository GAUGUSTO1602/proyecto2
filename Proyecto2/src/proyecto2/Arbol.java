/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *  Clase arbol de tipo binario
 * @author Gabriel González
 * @param <T>
 */
public class Arbol <T> {
    private NodoAB <T> raiz;

    /**
     *
     */
    public Arbol(){
        raiz = null;
    }

    /**
     *
     * @param x
     */
    public Arbol(String x){
        NodoAB nuevo = new NodoAB(x);
        raiz = nuevo;
    }

    /**
     *
     * @param x
     */
    public Arbol(NodoAB x){
        raiz = x;
    }

    /**
     *
     * @return
     */
    public NodoAB<T> getRaiz() {
        return raiz;
    }

    /**
     *
     * @param raiz
     */
    public void setRaiz(NodoAB<T> raiz) {
        this.raiz = raiz;
    }

    /**
     *
     * @return
     */
    public boolean esVacio(){
        return raiz == null;
    }

    /**
     * Método para recorrer un arbol binario en preorden
     * @return
     */
    public String preorden(){
        return preorden(this.getRaiz(), "");
    }

    /**
     * Método para recorrer un arbol binario en preorden
     * @param raiz
     * @param ruta
     * @return
     */
    public String preorden(NodoAB raiz, String ruta){
        ruta += raiz.getData();
        if(raiz.getHijo_izq() != null){
            ruta = preorden(raiz.getHijo_izq(), ruta);
        }
        if(raiz.getHijo_der() != null){
            ruta = preorden(raiz.getHijo_der(), ruta); 
        }

        return ruta;
    }

    /**
     * Método para recorrer un arbol binario en inorden
     * @return
     */
    public String inorden(){
        return inorden(this.getRaiz(), "");
    }

    /**
     * Método para recorrer un arbol binario en inorden
     * @param raiz
     * @param ruta
     * @return
     */
    public String inorden(NodoAB raiz, String ruta){
        if(raiz.getHijo_izq() != null){
            ruta = inorden(raiz.getHijo_izq(), ruta);
        }
        ruta += raiz.getData();
        if(raiz.getHijo_der() != null){
            ruta = inorden(raiz.getHijo_der(), ruta);
        }

        return ruta;
    }

    /**
     * Método para recorrer un arbol binario en posorden
     * @return
     */
    public String postOrden(){
        return postOrden(this.getRaiz(), "");
    }

    /**
     * Método para recorrer un arbol binario en posorden
     * @param raiz
     * @param ruta
     * @return
     */
    public String postOrden(NodoAB raiz, String ruta){
        if(raiz.getHijo_izq() != null){
            ruta = postOrden(raiz.getHijo_izq(), ruta);
        }
        if(raiz.getHijo_der() != null){
            ruta = postOrden(raiz.getHijo_der(), ruta);
        }
        ruta += raiz.getData();

        return ruta;
    }

    /**
     * Crea un arbol binario a traves de una expresión postfija/polaca inversa
     * @param exp
     * @return
     */
    public Arbol crearArbol(String exp){
        String[] parts = exp.split("|");
        Pila pila = new Pila();
        for (int i = 0; i < parts.length; i++) {
            if(parts[i].equals("+") || parts[i].equals("-") || parts[i].equals("*") || parts[i].equals("/") || parts[i].equals("^")){

                NodoAB padre = new NodoAB(parts[i]);
                NodoAB hijoDer = pila.getpCima().getpArbol().getRaiz();
                pila.Desapilar();
                NodoAB hijoIzq = pila.getpCima().getpArbol().getRaiz();
                pila.Desapilar();
                padre.setHijo_der(hijoDer);
                padre.setHijo_izq(hijoIzq);
                Arbol aux = new Arbol(padre);
                pila.Apilar(aux);

            }else{
                NodoAB nAux = new NodoAB(parts[i]);
                Arbol aux = new Arbol(nAux);
                pila.Apilar(aux);
            }
        }
        Arbol pAux = pila.getpCima().getpArbol();

        return pAux;
    }

    /**
     * Crea un arbol binario a traves de una expresioón prefija/polaca
¨    * Si el algoritmo falla es porque la expresión prefija introducida no es valida
     * @param n
     * @param i
     * @param exp
     */
    public void preArbol(NodoAB n, Integer i, String[] exp){
        if(i == exp.length){
        }else if(exp[i].equals("+") || exp[i].equals("-") || exp[i].equals("*") || exp[i].equals("/") || exp[i].equals("^")){
            NodoAB nuevo = new NodoAB(exp[i]);
            n.setHijo_izq(nuevo);
            nuevo.setPadre(n);
            i = i +1;
            preArbol(nuevo, i, exp);
        }else{
            NodoAB nuevo = new NodoAB(exp[i]);
            n.setHijo_izq(nuevo);
            nuevo.setPadre(n);
            while(n.getHijo_der() != null){
                n = n.getPadre();
            }
            i = i +1;
            NodoAB nuevo2 = new NodoAB(exp[i]);
            n.setHijo_der(nuevo2);
            nuevo2.setPadre(n);
            if(exp[i].equals("+") || exp[i].equals("-") || exp[i].equals("*") || exp[i].equals("/") || exp[i].equals("^")){
                preArbol(nuevo2, i + 1, exp);
                
            }else{
                if(i == exp.length - 1){
                }else{
                    nuevo2 = nuevo2.getPadre();
                    while(nuevo2.getHijo_der() != null){
                        nuevo2 = nuevo2.getPadre();
                    }
                    i = i +1;
                    NodoAB nuevo3 = new NodoAB(exp[i]);
                    nuevo2.setHijo_der(nuevo3);
                    nuevo3.setPadre(nuevo2);
                    if(i == exp.length - 1){
                    }else if(nuevo3.getData() != null && (!nuevo3.getData().equals("+") && !nuevo3.getData().equals("-") && !nuevo3.getData().equals("*") && !nuevo3.getData().equals("/") && !nuevo3.getData().equals("^"))){
                        nuevo3 = nuevo3.getPadre();
                        while(nuevo3.getHijo_der() != null){
                            nuevo3 = nuevo3.getPadre();
                        }
                        i = i + 1;
                        NodoAB nuevo4 = new NodoAB(exp[i]);
                        nuevo3.setHijo_der(nuevo4);
                        nuevo4.setPadre(nuevo3);
                        preArbol(nuevo4, i + 1, exp);
                    }else{
                        preArbol(nuevo3, i + 1, exp);
                    }
                    
                } 
            }

        }

    }

}
