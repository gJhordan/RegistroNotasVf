/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frames_PanelsDocente;

import Frames_PanelsDocente.*;
import Informacion.DocentexSecciones;
import Informacion.EstadoPeriodos;
import Informacion.NotasDetalles;
import Informacion.ValoresEstaticos;
import Interfaces.DAODocentexSeccionesImplement;
import Interfaces.DAONotasDetallesImplement;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author medal
 */
public class PanelNotaUnica extends javax.swing.JPanel {

    NotasDetalles ND = new NotasDetalles();
    NotasDetalles END = ValoresEstaticos.VEND;

    DAONotasDetallesImplement DAOND = new DAONotasDetallesImplement();

    /**
     * Creates new form PanelNotaUnica
     */
    public PanelNotaUnica() {
        initComponents();
        ND.setNroseccionDoc(END.getNroseccionDoc());
        ND.setAlumnoID(END.getAlumnoID());
        ND.setNroNota(END.getNroNota());
        ND.setPorcentaje(END.getPorcentaje());
        LblPorcentaje.setText("" + ND.getPorcentaje() + "%");
        DAOND.ObtenerUnicaxAlumno(ND);
        if (ND.getNotaUnica() != 99) {
            TxtNota.setText("" + ND.getNotaUnica());
        }

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
        jLabel4 = new javax.swing.JLabel();
        TxtNota = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        LblPorcentaje = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(560, 384));

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Nota Unica:");
        jLabel4.setPreferredSize(new java.awt.Dimension(170, 40));

        TxtNota.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        TxtNota.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtNota.setBorder(null);
        TxtNota.setPreferredSize(new java.awt.Dimension(60, 40));
        TxtNota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNotaKeyTyped(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Guardar");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setPreferredSize(new java.awt.Dimension(150, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/regn__1.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(139, 69, 34));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        LblPorcentaje.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        LblPorcentaje.setForeground(new java.awt.Color(255, 255, 255));
        LblPorcentaje.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblPorcentaje.setText("-");
        LblPorcentaje.setPreferredSize(new java.awt.Dimension(170, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(TxtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LblPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!TxtNota.getText().isEmpty()) {
            if (TxtNota.getText().length() <= 4) {
                ND.setNotaUnica(Double.parseDouble(TxtNota.getText()));
                if (ND.getNotaUnica() >= 0 && ND.getNotaUnica() <= 20) {
                    DAOND.ActualizarUnicaxAlumno(ND);
                    DAOND.ObtenerUnicaxAlumno(ND);
                    TxtNota.setText("" + ND.getNotaUnica());
                    JOptionPane.showMessageDialog(null, "Nota Guardada");
                } else {
                    JOptionPane.showMessageDialog(null, "Ingresó una nota no valida");
                    if (ND.getNotaUnica() != 99) {
                        TxtNota.setText("" + ND.getNotaUnica());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingresó una nota no valida");
                if (ND.getNotaUnica() != 99) {
                    TxtNota.setText("" + ND.getNotaUnica());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Existen campos vacios");
            if (ND.getNotaUnica() != 99) {
                TxtNota.setText("" + ND.getNotaUnica());
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void TxtNotaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNotaKeyTyped
        char caracter = evt.getKeyChar();            // 2.almacenando una tecla presiona

        if ((caracter < '0' || caracter > '9')
                && (caracter != KeyEvent.VK_BACK_SPACE)) {// 3. si se cumple 
            evt.consume();                                // no dejara esribir  
        }
    }//GEN-LAST:event_TxtNotaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblPorcentaje;
    private javax.swing.JTextField TxtNota;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
