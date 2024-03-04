package Frames_PanelsGenerales;


import DAO.ActualizarInformacionImplements;
import Informacion.Usuario;
import Informacion.ValoresEstaticos;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CambiarInformacion extends javax.swing.JPanel {

    Usuario Usua = ValoresEstaticos.Usu;

    private boolean editandoCorreo = false;
    private boolean editandoTelefono = false;
    private String correoOriginal; // Variable para almacenar el valor original del correo electrónico
    private String telefonoOriginal; // Variable para almacenar el valor original del número de teléfono

    public CambiarInformacion() {
        initComponents();
        initRoles(Usua.getRol());
        LblCodigoUsuario.setEditable(false); // Inicia el campo como no editable al principio
        LblCodigoUsuario.setEditable(false); // Inicia el campo como no editable al principio
        BtonGuardar.setVisible(false); // Oculta el botón de guardar al principio
        BtonCancelar.setVisible(false); // Oculta el botón de guardar al principio

        LblNombre.setText(Usua.getNombre());
        LblApellidoP.setText(Usua.getApeP());
        LblApellidoM.setText(Usua.getApeM());
        LblCodigoUsuario.setText(Usua.getCodigoUsu());
        LblCorreo.setText(Usua.getCorreopersonal());
        TxtTelefono.setText(Usua.getTelefono());  

        // Agregar un FocusListener al campo TxtCorreoElectronico
        LblCodigoUsuario.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                LblCodigoUsuario.selectAll(); // Seleccionar todo el texto al obtener el foco
            }
        });

        // Agregar un FocusListener al campo TxtTelefono
        LblCorreo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                LblCorreo.selectAll(); // Seleccionar todo el texto al obtener el foco
            }
        });
    }

    private void initRoles(String Roles) {
        switch (Roles) {
            case "Administrador":
                break;
            case "Docente":
                jPanelBase.setBackground(new Color(0, 153, 204));
                jInfo.setBackground(new Color(0, 153, 204));
                jFondoInfo.setBackground(new Color(120, 40, 238));
                JlTitulo.setBackground(new Color(0, 153, 204));
                jfondoTitutlo.setBackground(new Color(120, 40, 238));

                jLblImangen.setIcon(new ImageIcon(getClass().getResource("/resources/Docente_Activo.png")));
                jLblRol.setText("Docente");

                break;
            case "Alumno":
                jPanelBase.setBackground(new Color(0, 102, 51));
                jInfo.setBackground(new Color(0, 102, 51));
                jFondoInfo.setBackground(new Color(51, 204, 0));
                jfondoTitutlo.setBackground(new Color(51, 204, 0));
                JlTitulo.setBackground(new Color(0, 102, 51));

                jLblImangen.setIcon(new ImageIcon(getClass().getResource("/resources/Alumno_Activo.png")));
                jLblRol.setText("Alumno");
                break;
            default:
                JOptionPane.showMessageDialog(null, "ERROR 876121: Contacte con Soporte Tecnico");
                break;
        }
    }

    private void resetPanel() {
        // Restaurar la visibilidad y estado de los botones
        BtonGuardar.setVisible(false);
        BtonCancelar.setVisible(false);
        EditarCorreo.setEnabled(true);
        EditarTelefono.setEnabled(true);
        editandoCorreo = false;
        editandoTelefono = false;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBase = new javax.swing.JPanel();
        jfondoTitutlo = new javax.swing.JPanel();
        JlTitulo = new javax.swing.JLabel();
        jFondoInfo = new javax.swing.JPanel();
        jInfo = new javax.swing.JPanel();
        LblNombre = new javax.swing.JTextField();
        TxtTelefono = new javax.swing.JTextField();
        LblApellidoP = new javax.swing.JTextField();
        LblApellidoM = new javax.swing.JTextField();
        LblCodigoUsuario = new javax.swing.JTextField();
        LblCorreo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        EditarCorreo = new javax.swing.JButton();
        EditarTelefono = new javax.swing.JButton();
        BtonGuardar = new javax.swing.JButton();
        BtonCancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLblImangen = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLblRol = new javax.swing.JLabel();

        jPanelBase.setBackground(new java.awt.Color(57, 91, 126));
        jPanelBase.setMaximumSize(new java.awt.Dimension(1160, 537));
        jPanelBase.setMinimumSize(new java.awt.Dimension(1160, 537));

        jfondoTitutlo.setBackground(new java.awt.Color(0, 102, 204));

        JlTitulo.setBackground(new java.awt.Color(0, 153, 204));
        JlTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        JlTitulo.setForeground(new java.awt.Color(255, 255, 255));
        JlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlTitulo.setText("Informacion General");
        JlTitulo.setToolTipText("");
        JlTitulo.setBorder(new javax.swing.border.MatteBorder(null));
        JlTitulo.setOpaque(true);

        javax.swing.GroupLayout jfondoTitutloLayout = new javax.swing.GroupLayout(jfondoTitutlo);
        jfondoTitutlo.setLayout(jfondoTitutloLayout);
        jfondoTitutloLayout.setHorizontalGroup(
            jfondoTitutloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jfondoTitutloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 1118, Short.MAX_VALUE)
                .addContainerGap())
        );
        jfondoTitutloLayout.setVerticalGroup(
            jfondoTitutloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jfondoTitutloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jFondoInfo.setBackground(new java.awt.Color(51, 204, 0));

        jInfo.setBackground(new java.awt.Color(204, 204, 204));
        jInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        LblNombre.setEditable(false);
        LblNombre.setBackground(new java.awt.Color(255, 255, 255));
        LblNombre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        LblNombre.setForeground(new java.awt.Color(0, 0, 0));
        LblNombre.setText("-");
        LblNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblNombre.setOpaque(true);
        LblNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LblNombreActionPerformed(evt);
            }
        });

        TxtTelefono.setEditable(false);
        TxtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        TxtTelefono.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TxtTelefono.setForeground(new java.awt.Color(0, 0, 0));
        TxtTelefono.setText("-");
        TxtTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TxtTelefono.setOpaque(true);

        LblApellidoP.setEditable(false);
        LblApellidoP.setBackground(new java.awt.Color(255, 255, 255));
        LblApellidoP.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        LblApellidoP.setForeground(new java.awt.Color(0, 0, 0));
        LblApellidoP.setText("-");
        LblApellidoP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblApellidoP.setOpaque(true);

        LblApellidoM.setEditable(false);
        LblApellidoM.setBackground(new java.awt.Color(255, 255, 255));
        LblApellidoM.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        LblApellidoM.setForeground(new java.awt.Color(0, 0, 0));
        LblApellidoM.setText("-");
        LblApellidoM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblApellidoM.setOpaque(true);
        LblApellidoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LblApellidoMActionPerformed(evt);
            }
        });

        LblCodigoUsuario.setEditable(false);
        LblCodigoUsuario.setBackground(new java.awt.Color(255, 255, 255));
        LblCodigoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        LblCodigoUsuario.setForeground(new java.awt.Color(0, 0, 0));
        LblCodigoUsuario.setText("-");
        LblCodigoUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblCodigoUsuario.setOpaque(true);
        LblCodigoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LblCodigoUsuarioActionPerformed(evt);
            }
        });

        LblCorreo.setEditable(false);
        LblCorreo.setBackground(new java.awt.Color(255, 255, 255));
        LblCorreo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        LblCorreo.setForeground(new java.awt.Color(0, 0, 0));
        LblCorreo.setText("-");
        LblCorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblCorreo.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Apellido Paterno :");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellido Materno :");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Codigo de Usuario :");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Correo Electronico :");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Telefono :");

        EditarCorreo.setBackground(new java.awt.Color(255, 255, 255));
        EditarCorreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/hacerotros32x32.png"))); // NOI18N
        EditarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarCorreoActionPerformed(evt);
            }
        });

        EditarTelefono.setBackground(new java.awt.Color(255, 255, 255));
        EditarTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/hacerotros32x32.png"))); // NOI18N
        EditarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarTelefonoActionPerformed(evt);
            }
        });

        BtonGuardar.setForeground(new java.awt.Color(0, 0, 0));
        BtonGuardar.setText("Guardar");
        BtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtonGuardarActionPerformed(evt);
            }
        });

        BtonCancelar.setForeground(new java.awt.Color(0, 0, 0));
        BtonCancelar.setText("Cancelar");
        BtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtonCancelarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nombre :");

        javax.swing.GroupLayout jInfoLayout = new javax.swing.GroupLayout(jInfo);
        jInfo.setLayout(jInfoLayout);
        jInfoLayout.setHorizontalGroup(
            jInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInfoLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblApellidoM)
                    .addComponent(LblCodigoUsuario)
                    .addComponent(TxtTelefono)
                    .addComponent(LblCorreo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LblApellidoP)
                    .addComponent(LblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jInfoLayout.createSequentialGroup()
                        .addComponent(EditarCorreo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInfoLayout.createSequentialGroup()
                        .addComponent(EditarTelefono)
                        .addGap(26, 26, 26)
                        .addComponent(BtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jInfoLayout.setVerticalGroup(
            jInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInfoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInfoLayout.createSequentialGroup()
                        .addGroup(jInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblCodigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(EditarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(BtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(EditarTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(BtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jFondoInfoLayout = new javax.swing.GroupLayout(jFondoInfo);
        jFondoInfo.setLayout(jFondoInfoLayout);
        jFondoInfoLayout.setHorizontalGroup(
            jFondoInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFondoInfoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jFondoInfoLayout.setVerticalGroup(
            jFondoInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFondoInfoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLblImangen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Docente_Activo.png"))); // NOI18N
        jLblImangen.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bienvenido/a :");

        jLblRol.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLblRol.setForeground(new java.awt.Color(255, 255, 255));
        jLblRol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblRol.setText("-");

        javax.swing.GroupLayout jPanelBaseLayout = new javax.swing.GroupLayout(jPanelBase);
        jPanelBase.setLayout(jPanelBaseLayout);
        jPanelBaseLayout.setHorizontalGroup(
            jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBaseLayout.createSequentialGroup()
                        .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBaseLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelBaseLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLblImangen, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jFondoInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanelBaseLayout.createSequentialGroup()
                        .addComponent(jfondoTitutlo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(14, Short.MAX_VALUE))))
        );
        jPanelBaseLayout.setVerticalGroup(
            jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jfondoTitutlo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelBaseLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLblImangen, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jFondoInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void LblCodigoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LblCodigoUsuarioActionPerformed

    }//GEN-LAST:event_LblCodigoUsuarioActionPerformed

    private void LblNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LblNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LblNombreActionPerformed

    private void EditarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarCorreoActionPerformed
        editandoCorreo = !editandoCorreo; // Cambiar el estado de edición
        LblCorreo.setEditable(editandoCorreo); // Habilitar o deshabilitar la edición
        LblCorreo.requestFocus(); // Hacer que el cursor se posicione automáticamente en el campo

        if (editandoCorreo) {
            correoOriginal = LblCorreo.getText(); // Guardar el valor original del correo
            EditarTelefono.setEnabled(false); // Deshabilitar el botón EditarTelefono mientras se edita el correo
        } else {
            EditarTelefono.setEnabled(true); // Habilitar el botón EditarTelefono cuando se finaliza la edición del correo
        }   

        // Mostrar o ocultar el botón de guardar según el estado de edición
        BtonGuardar.setVisible(editandoCorreo);
        BtonCancelar.setVisible(editandoCorreo);
        EditarCorreo.setEnabled(false); // Desactivar el botón EditarCorreo mientras se edita

    }//GEN-LAST:event_EditarCorreoActionPerformed

    private void EditarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarTelefonoActionPerformed
        editandoTelefono = !editandoTelefono; // Cambiar el estado de edición
        TxtTelefono.setEditable(editandoTelefono); // Habilitar o deshabilitar la edición
        TxtTelefono.requestFocus(); // Hacer que el cursor se posicione automáticamente en el campo

        if (editandoTelefono) {
            telefonoOriginal = TxtTelefono.getText(); // Guardar el valor original del teléfono
            EditarCorreo.setEnabled(false); // Deshabilitar el botón EditarCorreo mientras se edita el teléfono
        } else {
            EditarCorreo.setEnabled(true); // Habilitar el botón EditarCorreo cuando se finaliza la edición del teléfono
        }

        // Mostrar o ocultar el botón de guardar según el estado de edición
        BtonGuardar.setVisible(editandoTelefono);
        BtonCancelar.setVisible(editandoTelefono);
        EditarTelefono.setEnabled(false); // Desactivar el botón EditarTelefono mientras se edita


    }//GEN-LAST:event_EditarTelefonoActionPerformed

    private void BtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtonGuardarActionPerformed
        if (editandoCorreo) {
            String nuevoCorreo = LblCorreo.getText();
            String codigoUsuario = Usua.getCodigoUsu(); // Asegúrate de tener el código del usuario
            String rolUsuario = Usua.getRol(); // Asegúrate de obtener el rol del usuario
            ActualizarInformacionImplements dao = new ActualizarInformacionImplements();
            dao.actualizarCorreo(nuevoCorreo, rolUsuario, codigoUsuario, Usua);
            editandoCorreo = false;
            resetPanel();
            JOptionPane.showMessageDialog(null, "Cambio realizado");
            Usua.setCorreopersonal(nuevoCorreo);
        }

        if (editandoTelefono) {
            String nuevoTelefonoStr = TxtTelefono.getText();

            // Verificar la longitud del número ingresado
            if (nuevoTelefonoStr.length() != 9) {
                JOptionPane.showMessageDialog(null, "El número de teléfono debe tener 9 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Sale del método si el número no tiene 9 dígitos
            }

            // Convertir a entero si la longitud es correcta
            int nuevoTelefono = Integer.parseInt(nuevoTelefonoStr);

            String codigoUsuario = Usua.getCodigoUsu();
            String rolUsuario = Usua.getRol();
            ActualizarInformacionImplements dao = new ActualizarInformacionImplements();
            dao.actualizarTelefono(nuevoTelefono, rolUsuario, codigoUsuario, Usua);
            editandoTelefono = false;
            resetPanel();
            JOptionPane.showMessageDialog(null, "Cambio realizado");
            LblCorreo.setEditable(false); // Deshabilitar edición después de guardar
            Usua.setTelefono(String.valueOf(nuevoTelefono));
        }

    }//GEN-LAST:event_BtonGuardarActionPerformed

    private void BtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtonCancelarActionPerformed
    if (editandoCorreo) {
        LblCorreo.setText(correoOriginal);
        LblCorreo.setEditable(false);
        EditarCorreo.setEnabled(true);
        editandoCorreo = false;
    }

    if (editandoTelefono) {
        TxtTelefono.setText(telefonoOriginal);
        TxtTelefono.setEditable(false);
        EditarTelefono.setEnabled(true);
        editandoTelefono = false;
    }

    // Habilitar ambos botones de edición al cancelar la edición
    EditarCorreo.setEnabled(true);
    EditarTelefono.setEnabled(true);

    BtonGuardar.setVisible(false);
    BtonCancelar.setVisible(false);
    }//GEN-LAST:event_BtonCancelarActionPerformed

    private void LblApellidoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LblApellidoMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LblApellidoMActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtonCancelar;
    private javax.swing.JButton BtonGuardar;
    private javax.swing.JButton EditarCorreo;
    private javax.swing.JButton EditarTelefono;
    private javax.swing.JLabel JlTitulo;
    private javax.swing.JTextField LblApellidoM;
    private javax.swing.JTextField LblApellidoP;
    private javax.swing.JTextField LblCodigoUsuario;
    private javax.swing.JTextField LblCorreo;
    private javax.swing.JTextField LblNombre;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JPanel jFondoInfo;
    private javax.swing.JPanel jInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLblImangen;
    private javax.swing.JLabel jLblRol;
    private javax.swing.JPanel jPanelBase;
    private javax.swing.JPanel jfondoTitutlo;
    // End of variables declaration//GEN-END:variables
}
