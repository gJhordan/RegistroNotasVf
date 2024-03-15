/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frames_PanelsGenerales;

import Informacion.Alumno;
import Interfaces.Carreras;
import Interfaces.DAOAlumnoImplement;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author USUARIO
 */
public class PanelRegistroAlumno extends javax.swing.JPanel {

    DAOAlumnoImplement DAOa = new DAOAlumnoImplement();
    Carreras C = new Carreras();
    Alumno alumno = new Alumno();
    int valCarrera = 0;

    /**
     * Creates new form PanelRegistroAlumno
     */
    public PanelRegistroAlumno() {
        initComponents();
        C.RellenarCmbcarrera(CmbBox_Carreras);
        //System.out.println((String) CmbBox_Carreras.getSelectedItem());
        alumno.setNombreCarrera((String) CmbBox_Carreras.getSelectedItem());
       alumno.setCarrera(C.DefinirCodigoCarrera(alumno.getNombreCarrera()));
        C.RellenarCiclo(CmbBoxCiclos, alumno.getCarrera());
        alumno.setCiclo((int) CmbBoxCiclos.getSelectedItem());
        valCarrera = 1;
    }

    public void Limpiar(JTextField texto) {
        texto.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlRegAlumno = new javax.swing.JPanel();
        BtnRegistrar = new javax.swing.JButton();
        TxtNombreAlumno = new javax.swing.JTextField();
        TxtApellidoPAlumno = new javax.swing.JTextField();
        TxtApellidoMAlumno = new javax.swing.JTextField();
        TxtNroDocAlumno = new javax.swing.JTextField();
        TxtEdadAlumno = new javax.swing.JTextField();
        TxtTelefonoAlumno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        TxtCorreoPAlumno = new javax.swing.JTextField();
        CmbBoxCiclos = new javax.swing.JComboBox<>();
        CmbBox_Carreras = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        CheckBeca = new javax.swing.JCheckBox();

        setPreferredSize(new java.awt.Dimension(490, 556));

        PnlRegAlumno.setBackground(new java.awt.Color(0, 153, 204));
        PnlRegAlumno.setForeground(new java.awt.Color(255, 255, 255));
        PnlRegAlumno.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnRegistrar.setBackground(new java.awt.Color(0, 102, 204));
        BtnRegistrar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        BtnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        BtnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/hacerotros32x32.png"))); // NOI18N
        BtnRegistrar.setText("Registrar");
        BtnRegistrar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 5, 1, 1, new java.awt.Color(0, 0, 0)));
        BtnRegistrar.setBorderPainted(false);
        BtnRegistrar.setIconTextGap(15);
        BtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarActionPerformed(evt);
            }
        });
        PnlRegAlumno.add(BtnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 494, 127, 40));

        TxtNombreAlumno.setForeground(new java.awt.Color(0, 0, 0));
        TxtNombreAlumno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombres:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ebrima", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        TxtNombreAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNombreAlumnoKeyTyped(evt);
            }
        });
        PnlRegAlumno.add(TxtNombreAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 188, 38));

        TxtApellidoPAlumno.setForeground(new java.awt.Color(0, 0, 0));
        TxtApellidoPAlumno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellido Paterno:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ebrima", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        TxtApellidoPAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtApellidoPAlumnoKeyTyped(evt);
            }
        });
        PnlRegAlumno.add(TxtApellidoPAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 188, 38));

        TxtApellidoMAlumno.setForeground(new java.awt.Color(0, 0, 0));
        TxtApellidoMAlumno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellido Materno:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ebrima", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        TxtApellidoMAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtApellidoMAlumnoKeyTyped(evt);
            }
        });
        PnlRegAlumno.add(TxtApellidoMAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 188, 38));

        TxtNroDocAlumno.setForeground(new java.awt.Color(0, 0, 0));
        TxtNroDocAlumno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nro de Documento:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ebrima", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        TxtNroDocAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNroDocAlumnoKeyTyped(evt);
            }
        });
        PnlRegAlumno.add(TxtNroDocAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 188, 38));

        TxtEdadAlumno.setForeground(new java.awt.Color(0, 0, 0));
        TxtEdadAlumno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edad:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ebrima", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        TxtEdadAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtEdadAlumnoActionPerformed(evt);
            }
        });
        TxtEdadAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtEdadAlumnoKeyTyped(evt);
            }
        });
        PnlRegAlumno.add(TxtEdadAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 188, 38));

        TxtTelefonoAlumno.setForeground(new java.awt.Color(0, 0, 0));
        TxtTelefonoAlumno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telefono:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ebrima", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        TxtTelefonoAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtTelefonoAlumnoKeyTyped(evt);
            }
        });
        PnlRegAlumno.add(TxtTelefonoAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 188, 38));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DATOS DEL ALUMNO");
        PnlRegAlumno.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 43, -1, -1));

        TxtCorreoPAlumno.setForeground(new java.awt.Color(0, 0, 0));
        TxtCorreoPAlumno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Correo Personal:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ebrima", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        TxtCorreoPAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCorreoPAlumnoKeyTyped(evt);
            }
        });
        PnlRegAlumno.add(TxtCorreoPAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 188, 38));

        CmbBoxCiclos.setBackground(new java.awt.Color(255, 255, 255));
        CmbBoxCiclos.setForeground(new java.awt.Color(0, 0, 0));
        CmbBoxCiclos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ciclo:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        PnlRegAlumno.add(CmbBoxCiclos, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 70, 50));

        CmbBox_Carreras.setBackground(new java.awt.Color(255, 255, 255));
        CmbBox_Carreras.setForeground(new java.awt.Color(0, 0, 0));
        CmbBox_Carreras.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Carrera:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        CmbBox_Carreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbBox_CarrerasActionPerformed(evt);
            }
        });
        PnlRegAlumno.add(CmbBox_Carreras, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 140, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/estudiante.png"))); // NOI18N
        PnlRegAlumno.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 190, 240));

        CheckBeca.setBackground(new java.awt.Color(255, 255, 255));
        CheckBeca.setForeground(new java.awt.Color(0, 0, 0));
        CheckBeca.setText("Becado");
        PnlRegAlumno.add(CheckBeca, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlRegAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlRegAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarActionPerformed
        int lleno, llenofinal = 0, edadaux;

        lleno = llenouno(TxtApellidoMAlumno);
        llenofinal = llenofinal + lleno;
        lleno = llenouno(TxtApellidoPAlumno);
        llenofinal = llenofinal + lleno;
        lleno = llenouno(TxtCorreoPAlumno);
        llenofinal = llenofinal + lleno;
        lleno = llenouno(TxtEdadAlumno);
        llenofinal = llenofinal + lleno;
        lleno = llenouno(TxtNombreAlumno);
        llenofinal = llenofinal + lleno;
        lleno = llenouno(TxtNroDocAlumno);
        llenofinal = llenofinal + lleno;
        lleno = llenouno(TxtTelefonoAlumno);
        llenofinal = llenofinal + lleno;
        if (llenofinal == 7) {

            edadaux = Integer.parseInt(TxtEdadAlumno.getText());
            if (edadaux <= 80 && edadaux >= 16) {
                alumno.setNombre(TxtNombreAlumno.getText());
                alumno.setApeP(TxtApellidoPAlumno.getText());
                alumno.setEdad(edadaux);
                alumno.setApeM(TxtApellidoMAlumno.getText());
                alumno.setDNI(TxtNroDocAlumno.getText());
                alumno.setCorreopersonal(TxtCorreoPAlumno.getText());
                alumno.setTelefono(TxtTelefonoAlumno.getText());
           alumno.setNombreCarrera((String) CmbBox_Carreras.getSelectedItem());
       alumno.setCarrera(C.DefinirCodigoCarrera(alumno.getNombreCarrera()));
                alumno.setCiclo((int) CmbBoxCiclos.getSelectedItem());
                alumno.setEstado("Activo");
                alumno.setRol("Alumno");
                if (alumno.getTelefono().length() == 9) {
                    if (alumno.getDNI().length() == 8) {
                        if (CheckBeca.isSelected()) {
                            alumno.setValBeca("1");
                        } else {
                            alumno.setValBeca("2");
                        }
                        alumno.setCodigoUsu(GenerarCodigo(alumno.getDNI(), alumno.getEdad()));
                        alumno.setClave(GenerarClave(alumno.getDNI(), alumno.getEdad()));

                        DAOa.registrar(alumno);
                        if (alumno.getCiclo() != 1) {
                            DAOa.ConvalidarCursos(alumno);
                            JOptionPane.showMessageDialog(null, "Este alumno es de nuevo ingreso por ello se estan \n convalidando todos sus cursos de ciclos pasados");
                        }
                        CmbBox_Carreras.setSelectedIndex(0);
                        CmbBoxCiclos.setSelectedIndex(0);
                        Limpiar(TxtEdadAlumno);
                        Limpiar(TxtNombreAlumno);
                        Limpiar(TxtApellidoPAlumno);
                        Limpiar(TxtApellidoMAlumno);
                        Limpiar(TxtNroDocAlumno);
                        Limpiar(TxtCorreoPAlumno);
                        Limpiar(TxtTelefonoAlumno);
                    } else {
                        JOptionPane.showMessageDialog(null, "El DNI debe tener solo 8 digitos");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El telefono debe tener solo 9 digitos");
                }

            } else {
                JOptionPane.showMessageDialog(null, "La edad del alumno debe ser entre 16 a 80 años");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Aun no se han completado todos los campos");
        }

    }//GEN-LAST:event_BtnRegistrarActionPerformed

    private void CmbBox_CarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbBox_CarrerasActionPerformed
        if (valCarrera == 1) {
            CmbBoxCiclos.removeAllItems();
            alumno.setNombreCarrera((String) CmbBox_Carreras.getSelectedItem());
       alumno.setCarrera(C.DefinirCodigoCarrera(alumno.getNombreCarrera()));
            // System.out.println(alumno.getCarrera());
            C.RellenarCiclo(CmbBoxCiclos, alumno.getCarrera());
        }


    }//GEN-LAST:event_CmbBox_CarrerasActionPerformed

    private void TxtEdadAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtEdadAlumnoKeyTyped
        char caracter = evt.getKeyChar();            // 2.almacenando una tecla presiona

        if ((caracter < '0' || caracter > '9')
                && (caracter != KeyEvent.VK_BACK_SPACE)) {// 3. si se cumple 
            evt.consume();                                // no dejara esribir  
        }
    }//GEN-LAST:event_TxtEdadAlumnoKeyTyped

    private void TxtNroDocAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNroDocAlumnoKeyTyped
        if (TxtNroDocAlumno.getText().length() > 7) {      // 1.si se pasa de 6 valores
            evt.consume();                           //   ya no dejara escirbir
        }
        char caracter = evt.getKeyChar();            // 2.almacenando una tecla presiona

        if ((caracter < '0' || caracter > '9')
                && (caracter != KeyEvent.VK_BACK_SPACE)) {// 3. si se cumple 
            evt.consume();                                // no dejara esribir  
        }
    }//GEN-LAST:event_TxtNroDocAlumnoKeyTyped

    private void TxtNombreAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNombreAlumnoKeyTyped
        if (TxtNombreAlumno.getText().length() > 49) {
            evt.consume();
        }
        char c = evt.getKeyChar();

        if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_TxtNombreAlumnoKeyTyped

    private void TxtApellidoPAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtApellidoPAlumnoKeyTyped
        if (TxtApellidoPAlumno.getText().length() > 49) {
            evt.consume();
        }
        char c = evt.getKeyChar();

        if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_TxtApellidoPAlumnoKeyTyped

    private void TxtApellidoMAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtApellidoMAlumnoKeyTyped
        if (TxtApellidoMAlumno.getText().length() > 49) {
            evt.consume();
        }
        char c = evt.getKeyChar();

        if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_TxtApellidoMAlumnoKeyTyped

    private void TxtCorreoPAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCorreoPAlumnoKeyTyped
        char c = evt.getKeyChar();
        if (TxtCorreoPAlumno.getText().length() > 29) {
            evt.consume();
        }
        if (!Character.isLetterOrDigit(c) && c != '@' && c != '.' && c != '_' && c != '-' && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }
    }//GEN-LAST:event_TxtCorreoPAlumnoKeyTyped

    private void TxtTelefonoAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtTelefonoAlumnoKeyTyped
        if (TxtTelefonoAlumno.getText().length() > 8) {      // 1.si se pasa de 6 valores
            evt.consume();                           //   ya no dejara escirbir
        }
        char caracter = evt.getKeyChar();            // 2.almacenando una tecla presiona

        if ((caracter < '0' || caracter > '9')
                && (caracter != KeyEvent.VK_BACK_SPACE)) {// 3. si se cumple 
            evt.consume();                                // no dejara esribir  
        }
    }//GEN-LAST:event_TxtTelefonoAlumnoKeyTyped

    private void TxtEdadAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtEdadAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtEdadAlumnoActionPerformed
    public String GenerarCodigo(String DNI, int Edad) {
        // NuevoCodigo = Integer.toString(NCaux);
        String NuevoCodigo;
        int auxComp;
        int DNIaux, NCaux, Aleatorio;
        int val1, val2;

        if (DNI == null || Edad == 0) {
            NuevoCodigo = null;
        } else {
            DNIaux = Integer.parseInt(DNI);
            val1 = DNIaux;
            val2 = Edad;
            do {
                DNIaux = val1;
                Edad = val2;
                Aleatorio = (int) (Math.random() * (9000 - 1000 + 1)) + 1000;
                NCaux = (DNIaux + Edad) - Aleatorio;
                //System.out.println("Antes: "+NCaux);
                NCaux = NCaux % 1000000;
                //System.out.println("Despues: "+NCaux);
                String numeroFormateado = String.format("%06d", NCaux);
                // System.out.println(numeroFormateado);
                NuevoCodigo = "U" + numeroFormateado;
                alumno.setCodigoUsu(NuevoCodigo);
                auxComp = DAOa.comparar(alumno);
            } while (auxComp == 1 || NuevoCodigo.length() > 7);

        }
        return NuevoCodigo;
    }

    public String GenerarClave(String DNI, int Edad) {
        String NuevaClave;
        int DNIaux, NCaux, Aleatorio;
        if (DNI == null || Edad == 0) {
            NuevaClave = null;
        } else {
            DNIaux = Integer.parseInt(DNI);
            Aleatorio = (int) (Math.random() * (9000 - 1000 + 1)) + 1000;
            NCaux = (DNIaux + Edad) - (int) Aleatorio;
            NuevaClave = Integer.toString(NCaux);
        }

        return NuevaClave;
    }

    public int llenouno(JTextField TextoCanal) {
        String val;
        val = TextoCanal.getText();
        int b;
        if (val.isEmpty()) {
            b = 0;
        } else {
            b = 1;
        }
        return b;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRegistrar;
    private javax.swing.JCheckBox CheckBeca;
    private javax.swing.JComboBox<String> CmbBoxCiclos;
    private javax.swing.JComboBox<String> CmbBox_Carreras;
    private javax.swing.JPanel PnlRegAlumno;
    private javax.swing.JTextField TxtApellidoMAlumno;
    private javax.swing.JTextField TxtApellidoPAlumno;
    private javax.swing.JTextField TxtCorreoPAlumno;
    private javax.swing.JTextField TxtEdadAlumno;
    private javax.swing.JTextField TxtNombreAlumno;
    private javax.swing.JTextField TxtNroDocAlumno;
    private javax.swing.JTextField TxtTelefonoAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
