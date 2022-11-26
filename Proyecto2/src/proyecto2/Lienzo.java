/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Clase para dibujar el arbol binario
 * @author veronica
 */
public class Lienzo extends JPanel{
    private Arbol objArbol;

    /**
     *
     */
    public static final int Diametro = 20;

    /**
     *
     */
    public static final int Radio = Diametro/2;

    /**
     *
     */
    public static final int Ancho = 30;

    /**
     *
     * @param objArbol
     */
    public void setObjArbol(Arbol objArbol) {
        this.objArbol = objArbol;
        repaint();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        pintar(g, getWidth()/2 + 5, 20, objArbol.getRaiz(), objArbol);

    }

    /**
    * Método para dibujar el arbol binario
    * @param g
    * @param x
    * @param y
    * @param n
    * @param a
     * @return
     */
    private void pintar(Graphics g, int x, int y, NodoAB n, Arbol a){
        if(n == null){
            g.drawString("Recorridos:", 20, 400);
            g.drawString("Inorden: " + a.inorden(), 20, 425);
            g.drawString("Preorden: " + a.preorden(), 20, 450);
            g.drawString("Posorden: " + a.postOrden(), 20, 475);
        }else{
            int extra = n.nodosCompletos(n) * (Ancho/2);
            g.setColor(Color.white);
            g.fillOval(x, y, Diametro, Diametro);
            g.setColor(Color.black);
            g.drawString(n.getData().toString(), x + 8, y + 16);
            if(n.getHijo_izq() != null){
                g.drawLine(x + Radio, y + Radio, x - Ancho - extra + Radio, y  + Ancho + Radio);
                g.setColor(Color.white);
                g.fillOval(x, y, Diametro, Diametro);
                g.setColor(Color.black);
                g.drawString(n.getData().toString(), x + 8, y + 16);
            }
            if(n.getHijo_der() != null){
                g.drawLine(x + Radio, y + Radio, x + Ancho + extra + Radio, y  + Ancho + Radio);
                g.setColor(Color.white);
                g.fillOval(x, y, Diametro, Diametro);
                g.setColor(Color.black);
                g.drawString(n.getData().toString(), x + 8, y + 16);
            }
            pintar(g, x - Ancho - extra, y + Ancho, n.getHijo_izq(), a);
            pintar(g, x + Ancho + extra, y + Ancho, n.getHijo_der(), a);
        }
    }

    
}
