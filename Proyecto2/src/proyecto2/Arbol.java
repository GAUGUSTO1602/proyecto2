/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author veronica
 */
public class Arbol <T> {
    private NodoAB <T> raiz;

    public Arbol(){
        raiz = null;
    }

    public Arbol(String x){
        NodoAB nuevo = new NodoAB(x);
        raiz = nuevo;
    }

    public Arbol(NodoAB x){
        raiz = x;
    }

    public NodoAB<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoAB<T> raiz) {
        this.raiz = raiz;
    }

    public boolean esVacio(){
        return raiz == null;
    }

    public NodoAB buscarPadre(NodoAB raiz, String padre){
        NodoAB encontrado = null;
        if(raiz.getData() == padre){
            return raiz;
        }
        if(raiz.getHijo_izq() != null && encontrado == null){
            encontrado = buscarPadre(raiz.getHijo_izq(), padre);
        }
        if(raiz.getHijo_der() != null && encontrado == null){
            encontrado = buscarPadre(raiz.getHijo_der(), padre);
        }

        return encontrado;
    }

    public void añadirNodo(String hijo, String padre, String side){
        NodoAB nHijo = new NodoAB(hijo);
        if(this.esVacio()){
            this.raiz = nHijo;
        } else{
            NodoAB nPadre = buscarPadre(this.raiz, padre);
            if(nPadre == null){
                System.out.println("El padre no existe");
            } else if(side == "left" && nPadre.getHijo_izq() == null){
                nPadre.setHijo_izq(nHijo);
            } else if(side == "right" && nPadre.getHijo_der() == null){
                nPadre.setHijo_der(nHijo);
            } else{
                System.out.println("Ambos hijos estn llenos");
            }
        }
    }

    public void borrarHijo(NodoAB n){
        if(n != null){
            n.setHijo_der(null);
            n.setHijo_izq(null);
        }
    }

    public void borrarNivel(int nivel){
        this.borrarNivel(this.raiz, nivel, 1);
    }

    public void borrarNivel(NodoAB raiz, int nivel, int nivelActual){
        if(nivel == nivelActual){
            this.borrarHijo(raiz);
        }
        if(raiz.getHijo_izq() != null){
            this.borrarNivel(raiz, nivel, nivelActual + 1);
        }
        if(raiz.getHijo_der() != null){
            this.borrarNivel(raiz, nivel, nivelActual + 1);
        }
    } 



    public String preorden(){
        return preorden(this.getRaiz(), "");
    }

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

    public String inorden(){
        return inorden(this.getRaiz(), "");
    }

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

    public String postOrden(){
        return postOrden(this.getRaiz(), "");
    }

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
        System.out.println(pAux.inorden());
        System.out.println(pAux.postOrden());
        System.out.println(pAux.preorden());
        return pAux;
    }

}
