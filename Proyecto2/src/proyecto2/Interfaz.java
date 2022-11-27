/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Alfredo Herrera
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        leerTxt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        leerTxt.setText("Ingresar TXT");
        leerTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leerTxtActionPerformed(evt);
            }
        });
        jPanel1.add(leerTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 120, 30));

        jLabel1.setText("Bienvenido al generador de arboles binarios");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 250, 30));

        jLabel2.setText("para expresiones aritméticas");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void leerTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leerTxtActionPerformed
        // TODO add your handling code here:
        Pila pila = new Pila();
        Arbol arbol = new Arbol();
        Boolean prueba = true;

        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File archivo = fc.getSelectedFile();
        try {
            FileReader fr = new FileReader (archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();

            String[] parts = linea.split("|");
            String prueba1 = parts[0];

            Integer indice = parts.length -1;
            String prueba2 = parts[indice];

            if(prueba1.equals("+") || prueba1.equals("-") || prueba1.equals("*") || prueba1.equals("/") || prueba1.equals("^")){
                NodoAB aux = new NodoAB(parts[0]);
                arbol.setRaiz(aux);
                arbol.preArbol(arbol.getRaiz(), 1, parts);

            }else if(prueba2.equals("+") || prueba2.equals("-") || prueba2.equals("*") || prueba2.equals("/") || prueba2.equals("^")){
                prueba = pila.evaluarPosfija(linea);
                if(prueba == true){
                    arbol = arbol.crearArbol(linea);
                }

            }else{
                String pos = pila.infijaToPosfija(linea);
                System.out.println(pos);
                pila.Vaciar();
                prueba = pila.evaluarPosfija(pos);
                if(prueba == true){
                    arbol = arbol.crearArbol(pos);
                }
            }



            if(prueba == true){
                Lienzo l = new Lienzo();
                Controlador c = new Controlador(l, arbol);
                c.iniciar();
                JFrame ventana = new JFrame();
                ventana.getContentPane().add(l);
                ventana.setDefaultCloseOperation(2);
                ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
                ventana.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Error: Ha ocurrido un error leyendo el archivo de texto o la expresión introducida no es valida");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: Ha ocurrido un error leyendo el archivo de texto o la expresión introducida no es valida");
        }
    }//GEN-LAST:event_leerTxtActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton leerTxt;
    // End of variables declaration//GEN-END:variables
}
