package AA_IniciarPrograma;


import Frames_PanelsGenerales.MenuGeneral;
import Informacion.Usuario;
import Interfaces.DAOLoginImplements;
import Interfaces.DefinirInformacionUsuario;
import Interfaces.Estados;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.awt.Color;
import java.awt.event.KeyEvent;
import static java.awt.image.ImageObserver.HEIGHT;

import javax.swing.JOptionPane;

/**
 *
 * @author jimmy
 */
public class Login extends javax.swing.JFrame {


    DAOLoginImplements DAOl = new DAOLoginImplements();
    Estados E = new Estados();
    DefinirInformacionUsuario DIU = new DefinirInformacionUsuario();
    String Usuario, Contrasena;

    int xMouse, yMouse;

    public Login() {
        initComponents();
     
        this.setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_absoluto = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        botonIniciodeSession = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        TxtPass = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        labelminiTitulo2 = new javax.swing.JLabel();
        labelminiTitulo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        LabelLetraLogin = new javax.swing.JLabel();
        salir = new javax.swing.JLabel();
        labelFond = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        salirPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        panel_absoluto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
        });

        botonIniciodeSession.setBackground(new java.awt.Color(255, 255, 255));
        botonIniciodeSession.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        botonIniciodeSession.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonIniciodeSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logearse32x32.png"))); // NOI18N
        botonIniciodeSession.setText("Ingresar");
        botonIniciodeSession.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonIniciodeSession.setIconTextGap(20);
        botonIniciodeSession.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonIniciodeSessionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonIniciodeSessionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonIniciodeSessionMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonIniciodeSessionMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonIniciodeSession, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botonIniciodeSession, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_absoluto.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 120, 40));
        panel_absoluto.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 310, 10));
        panel_absoluto.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 310, 10));

        TxtPass.setBackground(new java.awt.Color(0,0,0,1));
        TxtPass.setFont(new java.awt.Font("Poppins SemiBold", 0, 15)); // NOI18N
        TxtPass.setForeground(new java.awt.Color(204, 204, 204));
        TxtPass.setText("***************");
        TxtPass.setBorder(null);
        TxtPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TxtPassMousePressed(evt);
            }
        });
        TxtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtPassKeyTyped(evt);
            }
        });
        panel_absoluto.add(TxtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 310, 20));

        txtUsuario.setBackground(new java.awt.Color(0,0,0,1));
        txtUsuario.setFont(new java.awt.Font("Poppins SemiBold", 0, 15)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(204, 204, 204));
        txtUsuario.setText("Ingrese su id de usuario");
        txtUsuario.setToolTipText("");
        txtUsuario.setBorder(null);
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtUsuarioMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUsuarioMousePressed(evt);
            }
        });
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        panel_absoluto.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 310, 20));

        labelminiTitulo2.setFont(new java.awt.Font("DM Sans", 0, 20)); // NOI18N
        labelminiTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        labelminiTitulo2.setText("CONTRASEÑA");
        panel_absoluto.add(labelminiTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        labelminiTitulo1.setFont(new java.awt.Font("DM Sans", 0, 20)); // NOI18N
        labelminiTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        labelminiTitulo1.setText("USUARIO");
        panel_absoluto.add(labelminiTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/unidos.png"))); // NOI18N
        panel_absoluto.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 210, 250));

        LabelLetraLogin.setFont(new java.awt.Font("Poppins Medium", 0, 40)); // NOI18N
        LabelLetraLogin.setForeground(new java.awt.Color(255, 255, 255));
        LabelLetraLogin.setText("SISTEMA DE NOTAS");
        panel_absoluto.add(LabelLetraLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 130));

        salir.setFont(new java.awt.Font("Antipasto Pro ", 0, 24)); // NOI18N
        salir.setText("X");
        salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salirMouseExited(evt);
            }
        });
        panel_absoluto.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 2, 30, 40));

        labelFond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/fondo.jpg"))); // NOI18N
        panel_absoluto.add(labelFond, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 430));

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout salirPanelLayout = new javax.swing.GroupLayout(salirPanel);
        salirPanel.setLayout(salirPanelLayout);
        salirPanelLayout.setHorizontalGroup(
            salirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        salirPanelLayout.setVerticalGroup(
            salirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 697, Short.MAX_VALUE)
                .addComponent(salirPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(salirPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_absoluto.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 30));

        jButton1.setText("jButton1");
        panel_absoluto.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_absoluto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_absoluto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_salirMouseClicked

    private void salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseEntered
        salir.setForeground(Color.white);
    }//GEN-LAST:event_salirMouseEntered

    private void salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseExited
        salir.setForeground(Color.black);
    }//GEN-LAST:event_salirMouseExited

    private void txtUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioMouseEntered

    private void txtUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioMouseExited

    private void txtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMousePressed
        if (txtUsuario.getText().equals("Ingrese su id de usuario")) {
            txtUsuario.setText("");
            txtUsuario.setForeground(Color.black);
        }
        if (String.valueOf(TxtPass.getPassword()).isEmpty()) {
            TxtPass.setText("***************");
            TxtPass.setForeground(Color.white);
        }
    }//GEN-LAST:event_txtUsuarioMousePressed

    private void TxtPassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtPassMousePressed
        if (String.valueOf(TxtPass.getPassword()).equals("***************")) {
            TxtPass.setText("");
            TxtPass.setForeground(Color.black);
        }
        if (txtUsuario.getText().isEmpty()) {
            txtUsuario.setText("Ingrese su id de usuario");
            txtUsuario.setForeground(Color.white);
        }
    }//GEN-LAST:event_TxtPassMousePressed

    private void botonIniciodeSessionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonIniciodeSessionMouseEntered
        jPanel2.setBackground(new Color(200, 200, 200));
    }//GEN-LAST:event_botonIniciodeSessionMouseEntered

    private void botonIniciodeSessionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonIniciodeSessionMouseExited
        jPanel2.setBackground(Color.white);
    }//GEN-LAST:event_botonIniciodeSessionMouseExited

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered

    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited

    }//GEN-LAST:event_jPanel2MouseExited

    private void botonIniciodeSessionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonIniciodeSessionMouseClicked
  
    }//GEN-LAST:event_botonIniciodeSessionMouseClicked

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume(); // Consumir el evento para evitar que el carácter se escriba
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void TxtPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPassKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume(); // Consumir el evento para evitar que el carácter se escriba
        }
    }//GEN-LAST:event_TxtPassKeyTyped

    private void botonIniciodeSessionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonIniciodeSessionMousePressed
            Usuario = txtUsuario.getText();
        Contrasena = TxtPass.getText();
        int vallogin, valusu, intentos;
        Usuario usuario = new Usuario();
        if ((Usuario.isEmpty() || Contrasena.isEmpty() || (Usuario.equals("Ingrese su id de usuario") || Contrasena.equals("***************")))) { //El empty basicamente verifica si el espacio esta vacio
            JOptionPane.showMessageDialog(null, "Existen campos que estan vacíos", "ERROR", HEIGHT);
        } else {
            if (Usuario.length() > 7 || Contrasena.length() > 10) {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña muy extensos", "ERROR", HEIGHT);
            } else {
                usuario.setCodigoUsu(Usuario);
                usuario.setClave(Contrasena);
                valusu = DAOl.compararusuario(usuario);
                if (valusu == 1) {
                    intentos = DAOl.comprobarintentos(usuario);
                    if (intentos >= 3) {
                        JOptionPane.showMessageDialog(null, "CUENTA BLOQUEADA POR EXCESO DE INTENTOS\nCONTACTE CON EL GESTOR");
                    } else {
                        vallogin = DAOl.intentarlogin(usuario);
                        if (vallogin == 1) {
                            E.DefinirPeriodo();
                            DIU.DefinirUsuario(Usuario);
                            JOptionPane.showMessageDialog(null, "Bienvenido");
                           
                            MenuGeneral irMenu = new MenuGeneral();
                            irMenu.setVisible(true);
                            this.dispose();
                        } else {
                            if (!Usuario.equals("A12345")) {
                                 DAOl.sumarintentos(usuario);
                            }
                           
                            JOptionPane.showMessageDialog(null, "Clave Incorrecta!!!");
                            intentos = DAOl.comprobarintentos(usuario);
                            if (intentos >= 3) {
                                JOptionPane.showMessageDialog(null, "CUENTA BLOQUEADA POR EXCESO DE INTENTOS\nCONTACTE CON EL GESTOR");
                            }
                        }
                    }
                    txtUsuario.setText("");
                    TxtPass.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario Inexistente");
                }
            }
        }
    }//GEN-LAST:event_botonIniciodeSessionMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMaterialLighterIJTheme.setup();
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelLetraLogin;
    private javax.swing.JPasswordField TxtPass;
    private javax.swing.JLabel botonIniciodeSession;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelFond;
    private javax.swing.JLabel labelminiTitulo1;
    private javax.swing.JLabel labelminiTitulo2;
    private javax.swing.JPanel panel_absoluto;
    private javax.swing.JLabel salir;
    private javax.swing.JPanel salirPanel;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
