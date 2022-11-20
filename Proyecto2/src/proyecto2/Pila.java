/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import javax.swing.JOptionPane;

/**
 *
 * @author veronica
 */
public class Pila <T> {
    private Nodo <T> pCima;
    private Integer size;

    public Pila(){
        this.pCima = null;
        this.size = 0;
    }

    public Nodo<T> getpCima() {
        return pCima;
    }

    public void setpCima(Nodo<T> pCima) {
        this.pCima = pCima;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public boolean esVacio() {
        return pCima == null;
    }

    public void Vaciar() {
        this.pCima = null;
        this.size = 0;
    } 

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
            System.out.println("funciona");
            return true;
        }else{
            return false;
        }
    }

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
