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

    public boolean igualEstructura(NodoAB raiz2){
        return this.igualEstructura(this.getRaiz(), raiz2);
    }

    public boolean igualEstructura(NodoAB raiz1, NodoAB raiz2){
        boolean igual = true;

        if(raiz1 == null || raiz2 == null){
            return false;
        }
        if((raiz1.getHijo_izq() != null || raiz2.getHijo_izq() != null) && igual){
            igual = igualEstructura(raiz1.getHijo_izq(), raiz2.getHijo_izq());
        }
        if((raiz1.getHijo_der() != null || raiz2.getHijo_der() != null) && igual){
            igual = igualEstructura(raiz1.getHijo_der(), raiz2.getHijo_der());
        }

        return igual;
    }

    public boolean igualValor(NodoAB raiz2){
        return igualValor(this.getRaiz(), raiz2);
    }

    public boolean igualValor(NodoAB raiz1, NodoAB raiz2){
        boolean igual = true;

        if(raiz1 == null || raiz2 == null || !raiz1.getData().equals(raiz2.getData())){
            return false;
        }
        if((raiz1.getHijo_izq() != null || raiz2.getHijo_izq() != null) && igual){
            igual = igualValor(raiz1.getHijo_izq(), raiz2.getHijo_izq());
        }
        if((raiz1.getHijo_der() != null || raiz2.getHijo_der() != null) && igual){
            igual = igualValor(raiz1.getHijo_der(), raiz2.getHijo_der());
        }

        return igual;
    }

    public boolean espejoEstructura(NodoAB raiz2){
        return this.espejoEstructura(this.getRaiz(), raiz2);
    }

    public boolean espejoEstructura(NodoAB raiz1, NodoAB raiz2){
        boolean igual = true;

        if(raiz1 == null || raiz2 == null){
            return false;
        }
        if((raiz1.getHijo_izq() != null || raiz2.getHijo_der() != null) && igual){
            igual = espejoEstructura(raiz1.getHijo_izq(), raiz2.getHijo_der());
        }
        if((raiz1.getHijo_der() != null || raiz2.getHijo_izq() != null) && igual){
            igual = espejoEstructura(raiz1.getHijo_der(), raiz2.getHijo_izq());
        }

        return igual;
    }

    public boolean espejoValor(NodoAB raiz2){
        return this.espejoValor(this.getRaiz(), raiz2);
    }

    public boolean espejoValor(NodoAB raiz1, NodoAB raiz2){
        boolean igual = true;

        if(raiz1 == null || raiz2 == null || !raiz1.getData().equals(raiz2.getData())){
            return false;
        }
        if((raiz1.getHijo_izq() != null || raiz2.getHijo_der() != null) && igual){
            igual = espejoValor(raiz1.getHijo_izq(), raiz2.getHijo_der());
        }
        if((raiz1.getHijo_der() != null || raiz2.getHijo_izq() != null) && igual){
            igual = espejoValor(raiz1.getHijo_der(), raiz2.getHijo_izq());
        }

        return igual;
    }


    public String preorden(){
        return preorden(this.getRaiz(), "");
    }

    public String preorden(NodoAB raiz, String ruta){
        ruta += raiz.getData() + ",";
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
        ruta += raiz.getData() + ",";
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
        ruta += raiz.getData() + ",";

        return ruta;
    }

}
