/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callcenter;

import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Lisa
 */
public class Principal extends javax.swing.JFrame {

    
    public Principal() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barra_menu = new javax.swing.JMenuBar();
        menu_archivo = new javax.swing.JMenu();
        menu_cargarnombres = new javax.swing.JMenuItem();
        menu_cargarrelaciones = new javax.swing.JMenuItem();
        menu_guardarrelaciones = new javax.swing.JMenuItem();
        menu_generarrelaciones = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menu_archivo.setText("Archivo");

        menu_cargarnombres.setText("Cargar Nombres");
        menu_cargarnombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_cargarnombresActionPerformed(evt);
            }
        });
        menu_archivo.add(menu_cargarnombres);

        menu_cargarrelaciones.setText("Cargar Relaciones");
        menu_archivo.add(menu_cargarrelaciones);

        menu_guardarrelaciones.setText("Guardar Relaciones");
        menu_guardarrelaciones.setEnabled(false);
        menu_archivo.add(menu_guardarrelaciones);

        menu_generarrelaciones.setText("Generar Relaciones Aleatorias");
        menu_generarrelaciones.setEnabled(false);
        menu_generarrelaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_generarrelacionesActionPerformed(evt);
            }
        });
        menu_archivo.add(menu_generarrelaciones);

        barra_menu.add(menu_archivo);

        setJMenuBar(barra_menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu_cargarnombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_cargarnombresActionPerformed
        // TODO add your handling code here:
        File archivo = null;
        Scanner sc;
        try{
            JFileChooser jfc = new JFileChooser();
            FileFilter filtro = new FileNameExtensionFilter("Archivos","txt");
            jfc.setFileFilter(filtro);
            int op = jfc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION){
                archivo = jfc.getSelectedFile();
                
                sc = new Scanner(archivo);
                while(sc.hasNext()){
                    String s1 = sc.nextLine();
                    System.out.println(s1);
                    TDAGrafo.Vertice v1 = relaciones.new Vertice(s1);
                    relaciones.addVertex(v1);
                }
                menu_generarrelaciones.setEnabled(true);
            }
            System.out.println(relaciones.getVertexCount());
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_menu_cargarnombresActionPerformed

    private void menu_generarrelacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_generarrelacionesActionPerformed
        // TODO add your handling code here:
        relaciones.setRelations();
        
        for(int i = 0; i<relaciones.getVertexCount(); i++){
            for(int j = 0; j<relaciones.getVertexCount(); j++){
                System.out.println("["+relaciones.relaciones[i][j]+"]");
            }
        }
        JOptionPane.showMessageDialog(this, "Se han generado las relaciones aleatorias");
    }//GEN-LAST:event_menu_generarrelacionesActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barra_menu;
    private javax.swing.JMenu menu_archivo;
    private javax.swing.JMenuItem menu_cargarnombres;
    private javax.swing.JMenuItem menu_cargarrelaciones;
    private javax.swing.JMenuItem menu_generarrelaciones;
    private javax.swing.JMenuItem menu_guardarrelaciones;
    // End of variables declaration//GEN-END:variables
TDAGrafo relaciones = new TDAGrafo();

}
