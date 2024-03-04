/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frames_PanelsGestor;

import DAO.Tablas;
import Informacion.SolAlumnos;
import Informacion.SolicitudesInfo;
import Interfaces.DAOSolicitudesRetiroCurso;

import Interfaces.DAOsolRetiroCursoImplements;
import Interfaces.DAOSsolicitudRetiroAlumnoImplement;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Administrador
 */
public class RevisarRetiroCurso extends javax.swing.JPanel {

    Tablas Tbl = new Tablas();
    int fila;
    DAOSsolicitudRetiroAlumnoImplement DAOrA = new DAOSsolicitudRetiroAlumnoImplement();
    SolicitudesInfo Si = new SolicitudesInfo();
    SolAlumnos Sa = new SolAlumnos();

    public RevisarRetiroCurso() {
        initComponents();
        Tbl.CargarTablaSolicitudDoc(TblSolDoc, "solretiroalumno", null);
        CmbBoxEstado.setEnabled(false);
        TxtAreaMotivo.setEditable(false);
        BtnProcesar.setEnabled(false);
    }

    public void mostrarTipo(JPanel j) {

        j.setSize(880, 370);
        j.setLocation(0, 0);

        PnlReaction2.removeAll();
        PnlReaction2.add(j, BorderLayout.CENTER);
        PnlReaction2.revalidate();
        PnlReaction2.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlReaction2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblSolDoc = new javax.swing.JTable();
        LblIDSolicitud = new javax.swing.JLabel();
        LblSeccion = new javax.swing.JLabel();
        LblAlumno = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtAreaMotivo = new javax.swing.JTextArea();
        LblImagen = new javax.swing.JLabel();
        BtnProcesar = new javax.swing.JButton();
        CmbBoxEstado = new javax.swing.JComboBox<>();

        PnlReaction2.setBackground(new java.awt.Color(57, 91, 126));

        TblSolDoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "IDSolicitud", "Seccion", "Cod Alumno", "Motivo", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblSolDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TblSolDocMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TblSolDoc);

        LblIDSolicitud.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        LblIDSolicitud.setForeground(new java.awt.Color(255, 255, 255));
        LblIDSolicitud.setText("-");
        LblIDSolicitud.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID de Solicitud", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        LblSeccion.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        LblSeccion.setForeground(new java.awt.Color(255, 255, 255));
        LblSeccion.setText("-");
        LblSeccion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nro de Seccion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        LblAlumno.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        LblAlumno.setForeground(new java.awt.Color(255, 255, 255));
        LblAlumno.setText("-");
        LblAlumno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Codigo del Docente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Gill Sans MT", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("INFORMACION");

        TxtAreaMotivo.setBackground(new java.awt.Color(0, 0, 0));
        TxtAreaMotivo.setColumns(20);
        TxtAreaMotivo.setForeground(new java.awt.Color(255, 0, 51));
        TxtAreaMotivo.setRows(5);
        TxtAreaMotivo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Motivo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(204, 0, 0))); // NOI18N
        jScrollPane2.setViewportView(TxtAreaMotivo);

        BtnProcesar.setBackground(new java.awt.Color(153, 0, 26));
        BtnProcesar.setFont(new java.awt.Font("Eras Light ITC", 1, 12)); // NOI18N
        BtnProcesar.setForeground(new java.awt.Color(255, 255, 255));
        BtnProcesar.setText("Procesar");
        BtnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnProcesarActionPerformed(evt);
            }
        });

        CmbBoxEstado.setBackground(new java.awt.Color(255, 255, 255));
        CmbBoxEstado.setForeground(new java.awt.Color(0, 0, 0));
        CmbBoxEstado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado de la Solicitud", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        CmbBoxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbBoxEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnlReaction2Layout = new javax.swing.GroupLayout(PnlReaction2);
        PnlReaction2.setLayout(PnlReaction2Layout);
        PnlReaction2Layout.setHorizontalGroup(
            PnlReaction2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlReaction2Layout.createSequentialGroup()
                .addGroup(PnlReaction2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlReaction2Layout.createSequentialGroup()
                        .addGap(590, 590, 590)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PnlReaction2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(PnlReaction2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PnlReaction2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PnlReaction2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PnlReaction2Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(LblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PnlReaction2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BtnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(PnlReaction2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(PnlReaction2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LblAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PnlReaction2Layout.createSequentialGroup()
                                        .addGroup(PnlReaction2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LblIDSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LblSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(CmbBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(2, 2, 2))
        );
        PnlReaction2Layout.setVerticalGroup(
            PnlReaction2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlReaction2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(PnlReaction2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PnlReaction2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(PnlReaction2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PnlReaction2Layout.createSequentialGroup()
                                .addComponent(LblIDSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(LblSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(LblAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PnlReaction2Layout.createSequentialGroup()
                                .addComponent(CmbBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(LblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlReaction2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlReaction2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TblSolDocMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblSolDocMousePressed
        fila = TblSolDoc.getSelectedRow();

        if (fila != -1) {
            CmbBoxEstado.removeAllItems();
            CmbBoxEstado.setEnabled(true);
            String sIDSol = TblSolDoc.getValueAt(fila, TblSolDoc.getColumnModel().getColumnIndex("IDSolicitud")).toString();
            String sSeccion = TblSolDoc.getValueAt(fila, TblSolDoc.getColumnModel().getColumnIndex("Seccion")).toString();
            String CodDoc = TblSolDoc.getValueAt(fila, TblSolDoc.getColumnModel().getColumnIndex("Cod Alumno")).toString();
            String Motivo = TblSolDoc.getValueAt(fila, TblSolDoc.getColumnModel().getColumnIndex("Motivo")).toString();
            String Estado = TblSolDoc.getValueAt(fila, TblSolDoc.getColumnModel().getColumnIndex("Estado")).toString();
            int IDSol = Integer.parseInt(sIDSol);
            int Seccion = Integer.parseInt(sSeccion);
            LblIDSolicitud.setText(sIDSol);
            LblSeccion.setText(sSeccion);
            LblAlumno.setText(CodDoc);
// Asignar un valor a CodigoUsuAlum en SolAlumnos
            Sa.setCodigoUsuAlum(LblAlumno.getText());
            int numeroSeccion = Integer.parseInt(LblSeccion.getText());
            Sa.setNroSeccion(numeroSeccion);

            
            TxtAreaMotivo.setText(Motivo);
            if (Estado.equals("Pendiente")) {
                CmbBoxEstado.addItem("Pendiente");
                CmbBoxEstado.addItem("Rechazado");
                CmbBoxEstado.addItem("Procesado");
                CmbBoxEstado.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_TblSolDocMousePressed

    private void CmbBoxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbBoxEstadoActionPerformed
        String estadonuevo = (String) CmbBoxEstado.getSelectedItem();
        if (estadonuevo != null) {
            if (!estadonuevo.equals("Pendiente")) {
                BtnProcesar.setEnabled(true);
            }else{
                  BtnProcesar.setEnabled(false);
            }
        }
    }//GEN-LAST:event_CmbBoxEstadoActionPerformed

    private void BtnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProcesarActionPerformed
        String estadonuevo = (String) CmbBoxEstado.getSelectedItem();

        if (estadonuevo.equals("Rechazado")) {
            Si.setIDSol(Integer.parseInt(LblIDSolicitud.getText()));  
            Si.setEstado(estadonuevo);
            DAOrA.cambiarEstadoSolicitudAlumno(Si);
            JOptionPane.showMessageDialog(null, "Solicitud Rechazada");
            Tbl.CargarTablaSolicitudDoc(TblSolDoc, "solretiroalumno", null);
            CmbBoxEstado.setEnabled(false);
            BtnProcesar.setEnabled(false);
        } else if (estadonuevo.equals("Procesado")) {
            Si.setIDSol(Integer.parseInt(LblIDSolicitud.getText()));  
            Si.setEstado(estadonuevo);
            DAOrA.cambiarEstadoSolicitudAlumno(Si);
            DAOrA.cambiarEstadoCuentaAlumno(Sa);
            JOptionPane.showMessageDialog(null, "Solicitud Procesado Exitosamente!!");
            Tbl.CargarTablaSolicitudDoc(TblSolDoc, "solretiroalumno", null);
            CmbBoxEstado.setEnabled(false);
            BtnProcesar.setEnabled(false);
        }

    }//GEN-LAST:event_BtnProcesarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnProcesar;
    private javax.swing.JComboBox<String> CmbBoxEstado;
    private javax.swing.JLabel LblAlumno;
    private javax.swing.JLabel LblIDSolicitud;
    private javax.swing.JLabel LblImagen;
    private javax.swing.JLabel LblSeccion;
    private javax.swing.JPanel PnlReaction2;
    private javax.swing.JTable TblSolDoc;
    private javax.swing.JTextArea TxtAreaMotivo;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
