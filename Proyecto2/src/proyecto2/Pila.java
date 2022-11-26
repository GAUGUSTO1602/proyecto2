/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import javax.swing.JOptionPane;

/**
 * Clase pila
 * @author Gabriel González
 * @param <T>
 */
public class Pila <T> {
    private Nodo <T> pCima;
    private Integer size;

    /**
     * Constructor
     */
    public Pila(){
        this.pCima = null;
        this.size = 0;
    }

    /**
     * 
     * @return
     */
    public Nodo<T> getpCima() {
        return pCima;
    }

    /**
     *
     * @param pCima
     */
    public void setpCima(Nodo<T> pCima) {
        this.pCima = pCima;
    }

    /**
     *
     * @return
     */
    public Integer getSize() {
        return size;
    }

    /**
     *
     * @param size
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     *
     * @return
     */
    public boolean esVacio() {
        return pCima == null;
    }

    /**
     *
     */
    public void Vaciar() {
        this.pCima = null;
        this.size = 0;
    } 

    /**
     * Apila un nuevo elemento a la pila
     * @param x
     */
    public void Apilar(String x){
        Nodo nuevo = new Nodo(x);
        if(this.esVacio()){
            pCima = nuevo;
        } else{
            nuevo.setpNext(pCima);
            pCima = nuevo;
        }
        size++;
    }

    /**
     * Apila un arbol a la pila
     * @param x
     */
    public void Apilar(Arbol x){
        Nodo nuevo = new Nodo(x);
        if(this.esVacio()){
            pCima = nuevo;
        } else{
            nuevo.setpNext(pCima);
            pCima = nuevo;
        }
        size++;
    }

    /**
     * Desapila un elemento de la pila
     */
    public void Desapilar(){
        if(this.esVacio()){
            JOptionPane.showMessageDialog(null,"Esta pila esta vaciia");
        } else if(this.size == 1){
            pCima = null;
            size--;
        } else{
            pCima = pCima.getpNext();
            size--;
        }
    }

    /**
     * Evalua si la expresión esta correctamente escrita como una expresión postfija/polaca inversa
     * @param exp
     * @return
     */
    public Boolean evaluarPosfija(String exp){
        String[] parts = exp.split("|");
        for (int i = 0; i < parts.length; i++) {
            if(parts[i].equals("+") || parts[i].equals("-") || parts[i].equals("*") || parts[i].equals("/") || parts[i].equals("^")){  
                String parte2 = this.getpCima().getData();
                this.Desapilar();
                String parte1 = this.getpCima().getData();
                this.Desapilar();
                String parte3 = parte1 + parte2 + parts[i];
                this.Apilar(parte3);
            }else{
                this.Apilar(parts[i]);
            }
        }
        if(this.getpCima().getData().equals(exp) && this.getSize() == 1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Convierte una expresion infija a una expresión polaca inversa/postfija
     * @param exp
     * @return
     */
    public String infijaToPosfija(String exp){
        String[] parts = exp.split("|");
        String salida = "";
        for (int i = 0; i < parts.length; i++) {
            if(parts[i].equals("+") || parts[i].equals("-")){  
                if(this.getpCima() != null && (this.getpCima().getData().equals("*") || this.getpCima().getData().equals("/") || this.getpCima().getData().equals("^") || this.getpCima().getData().equals("+") || this.getpCima().getData().equals("-"))){
                    while(this.getpCima() != null && (this.getpCima().getData().equals("*") || this.getpCima().getData().equals("/") || this.getpCima().getData().equals("^") || this.getpCima().getData().equals("+") || this.getpCima().getData().equals("-"))){
                        salida = salida + this.getpCima().getData();
                        this.Desapilar();
                    }
                    this.Apilar(parts[i]);
                }else{
                    this.Apilar(parts[i]);
                }

            }else if(parts[i].equals("*") || parts[i].equals("/")){
                if(this.getpCima() != null && (this.getpCima().getData().equals("^") || this.getpCima().getData().equals("*") || this.getpCima().getData().equals("/"))){
                    while(this.getpCima() != null && (this.getpCima().getData().equals("^") || this.getpCima().getData().equals("*") || this.getpCima().getData().equals("/"))){
                        salida = salida + this.getpCima().getData();
                        this.Desapilar();
                    }
                    this.Apilar(parts[i]);
                }else{
                    this.Apilar(parts[i]);
                }

            }else if(parts[i].equals("^")){
                this.Apilar(parts[i]);

            }else if(parts[i].equals("(")){
                this.Apilar(parts[i]);

            }else if(parts[i].equals(")")){
                Nodo aux = this.getpCima();
                while(!aux.getData().equals("(") && !this.esVacio()){
                    salida = salida + aux.getData();
                    aux = aux.getpNext();
                    this.Desapilar();
                }
                if(this.getpCima().getData().equals("(")){
                    this.Desapilar();
                }

            }else{
                salida = salida + parts[i];

            }
        }
        Nodo fin = this.getpCima();
        while(fin != null){
            salida = salida + fin.getData();
            fin = fin.getpNext();
            this.Desapilar();
        }

        return salida;
    }

}
