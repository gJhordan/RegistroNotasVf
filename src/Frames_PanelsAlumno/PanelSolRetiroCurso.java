/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frames_PanelsAlumno;

import Frames_PanelsDocente.*;
import Informacion.Docente;
import Informacion.Secciones;
import Informacion.EnviarSolicitudDocente;
import Informacion.Usuario;
import Informacion.ValoresEstaticos;
import Interfaces.SolRetiroCurso;
import Interfaces.DAOsolRetiroCursoImplements;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Luis
 */
public class PanelSolRetiroCurso extends javax.swing.JPanel {

    Usuario Usua = ValoresEstaticos.Usu;
//    Docente DocS = ValoresEstaticos.Doc;
    Secciones secciones = new Secciones();
    DAOsolRetiroCursoImplements DAOrC = new DAOsolRetiroCursoImplements();
    SolRetiroCurso Rc = new SolRetiroCurso();
    
    EnviarSolicitudDocente sd = new EnviarSolicitudDocente();
    Docente D = new Docente();
    int valCurso = 0;
    int consulta;

    public PanelSolRetiroCurso() {
        initComponents();

        LblNomDocente.setText(Usua.getNombrecompleto());
        LblCodigoAlumno.setText(Usua.getCodigoUsu());
        JFieldMonto.setText("S/. "+"100");

        Rc.RellenarCursos(CmbCurso);
        sd.setCurso((String) CmbCurso.getSelectedItem());
        
        CmbCurso.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCurso = (String) CmbCurso.getSelectedItem();
                Rc.RellenarSeccion(JFieldSeccion, selectedCurso);
            }
        });

        PlainDocument doc = (PlainDocument) txtMotivo.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (fb.getDocument().getLength() + string.length() > 150) {
                    return;
                }
                super.insertString(fb, offset, string, attr);
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (fb.getDocument().getLength() - length + text.length() > 150) {
                    return;
                }
                super.replace(fb, offset, length, text, attrs);
            }
        });

        txtMotivo.setLineWrap(true);
        txtMotivo.setWrapStyleWord(true);

        txtMotivo.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCharacterCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCharacterCount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCharacterCount();
            }
        });

        // Actualiza el contador de caracteres 
        updateCharacterCount();
    }

    // Método para actualizar el contador de caracteres
    private void updateCharacterCount() {
        int characterCount = txtMotivo.getText().length();
        jLabelCaracteres.setText(characterCount + "/ 150");

    }

    public void Limpiar(JTextArea texto) {
        texto.setText("");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMotivo = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jLabelCaracteres = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CmbCurso = new javax.swing.JComboBox<>();
        LblNomDocente = new javax.swing.JLabel();
        LblCodigoAlumno = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JFieldMonto = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JFieldSeccion = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(1160, 537));
        jPanel1.setMinimumSize(new java.awt.Dimension(1160, 537));
        jPanel1.setPreferredSize(new java.awt.Dimension(1160, 537));

        jLabel18.setBackground(new java.awt.Color(0, 204, 0));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText(" Solicitud de retiro de Curso :");
        jLabel18.setToolTipText("");
        jLabel18.setOpaque(true);

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Pago por retiro de curso:");

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Motivo :");

        txtMotivo.setColumns(20);
        txtMotivo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtMotivo.setRows(5);
        txtMotivo.setTabSize(1);
        txtMotivo.setWrapStyleWord(true);
        txtMotivo.setAutoscrolls(false);
        txtMotivo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(txtMotivo);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/RetirarCurso.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Alumno:");

        jLabel10.setFont(new java.awt.Font("Sitka Subheading", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setText("*opcional*");

        btnRegistrar.setBackground(new java.awt.Color(0, 0, 0));
        btnRegistrar.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabelCaracteres.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCaracteres.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        jLabelCaracteres.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCaracteres.setText("0/150");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Código:");

        CmbCurso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CmbCurso.setBorder(javax.swing.BorderFactory.createTitledBorder("Curso:"));
        CmbCurso.setInheritsPopupMenu(true);
        CmbCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbCursoActionPerformed(evt);
            }
        });

        LblNomDocente.setBackground(new java.awt.Color(255, 255, 255));
        LblNomDocente.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        LblNomDocente.setForeground(new java.awt.Color(255, 255, 255));
        LblNomDocente.setText("-");
        LblNomDocente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alumno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Light", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        LblCodigoAlumno.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        LblCodigoAlumno.setForeground(new java.awt.Color(255, 255, 255));
        LblCodigoAlumno.setText("-");
        LblCodigoAlumno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Código", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Light", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        LblCodigoAlumno.setPreferredSize(new java.awt.Dimension(37, 50));

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Seleccione el curso:");

        JFieldMonto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        JFieldMonto.setForeground(new java.awt.Color(255, 255, 255));
        JFieldMonto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JFieldMonto.setText("-");
        JFieldMonto.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Sección:");

        JFieldSeccion.setEditable(false);
        JFieldSeccion.setBackground(new java.awt.Color(255, 255, 255));
        JFieldSeccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JFieldSeccion.setForeground(new java.awt.Color(0, 0, 0));
        JFieldSeccion.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblCodigoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblNomDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelCaracteres, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(JFieldSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JFieldMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(7, Short.MAX_VALUE))))
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JFieldSeccion)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JFieldMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCaracteres, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(LblNomDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblCodigoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(61, 61, 61))))
        );

        CmbCurso.getAccessibleContext().setAccessibleName("Curso: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        sd.setCurso((String) CmbCurso.getSelectedItem());
        sd.setSeccion((String) JFieldSeccion.getText());
        secciones.setSeccionID(Integer.parseInt(sd.getSeccion()));
        sd.setCodDocente(LblCodigoAlumno.getText());
        sd.setMotivo(txtMotivo.getText());
        consulta = Rc.EstadoSolicitud(secciones);
        switch (consulta) {
            case 1 ->{
                DAOrC.registrar(sd);
                  CmbCurso.setSelectedIndex(0);
                  Limpiar(txtMotivo);
                break;
            }
            case 0 -> {
                JOptionPane.showMessageDialog(null, "La sección "+sd.getSeccion()+" ya tiene una solicitud en curso.");
                CmbCurso.setSelectedIndex(0);
                Limpiar(txtMotivo);
                break;
            }
            case -1 ->
                System.out.println("Error SQL al buscar la solicitud.");
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void CmbCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbCursoActionPerformed
        if (valCurso == 1) {
            sd.setCurso((String) CmbCurso.getSelectedItem());
            }
    }//GEN-LAST:event_CmbCursoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbCurso;
    private javax.swing.JLabel JFieldMonto;
    private javax.swing.JTextField JFieldSeccion;
    private javax.swing.JLabel LblCodigoAlumno;
    private javax.swing.JLabel LblNomDocente;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCaracteres;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtMotivo;
    // End of variables declaration//GEN-END:variables

}
