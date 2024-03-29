/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames_PanelsDocente;


import Informacion.DocentexSecciones;
import Informacion.EstadoPeriodos;
import Informacion.Usuario;
import Informacion.ValoresEstaticos;
import Interfaces.DAODocentexSeccionesImplement;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author medal
 */
public class VistaReporteNotasxseccion extends javax.swing.JFrame {

    Usuario Usua = ValoresEstaticos.Usu;

    EstadoPeriodos VEPST = ValoresEstaticos.VEPST;
    DocentexSecciones DxS = new DocentexSecciones();
    DocentexSecciones EDxS = ValoresEstaticos.VEDxS;
    DAODocentexSeccionesImplement DAODxS = new DAODocentexSeccionesImplement();
    private String[] encabezados;
    /**
     * Creates new form VistaReporteNotasxseccion
     */
    public VistaReporteNotasxseccion() {
        initComponents();
        DxS.setDocenteID(Usua.getID());
        DxS.setPeriodoID(VEPST.getIdp());
        DxS.setDocenteID(Usua.getID());
        DxS.setPeriodoID(VEPST.getIdp());
        EDxS.setDocenteID(DxS.getDocenteID());
        EDxS.setPeriodoID(DxS.getPeriodoID());
        DxS.setNroseccionDoc(EDxS.getNroseccionDoc());
        DxS.setNroseccionDoc(EDxS.getNroseccionDoc());
        DxS.setNroNotasRegistradasxAlumno(EDxS.getNroNotasRegistradasxAlumno());
        DxS.setNroNotasRegistradasxAlumno(EDxS.getNroNotasRegistradasxAlumno());
        DAODxS.CargarTablaReporte(DxS,tblVista);
        lblSeccion.setText(Integer.toString(EDxS.getNroseccionDoc())+" ["+VEPST.getNombrep()+"]");
        DxS.setNotasNombresF(EDxS.getNotasNombresF());
        EDxS.setNotasNombresF(DxS.getNotasNombresF());
        CargarEstado();
        CargarEncabezado();  
    }
 
    private void CargarEncabezado(){
        encabezados = new String[4];
        DxS.setNotasNombresF(EDxS.getNotasNombresF());
                for (int i = 0; i < 4; i++) {
            DAODxS.CargarNombresTiposyPorcentajes(DxS, i);
            encabezados[i] = DxS.getNotasNombres(i);
        }   
                for (int i = 2; i < 6; i++) {
        String nuevoEncabezado = encabezados[i - 2];
        tblVista.getColumnModel().getColumn(i).setHeaderValue(nuevoEncabezado);
    }
            
            EDxS.setNotasNombresF(DxS.getNotasNombresF());
    }
    private void CargarEstado(){
        int filas = tblVista.getRowCount();
        DefaultTableModel model = (DefaultTableModel) tblVista.getModel();
       
        for (int i = 0; i < filas; i++) {

            String Promedio = tblVista.getValueAt(i, tblVista.getColumnModel().getColumnIndex("Promedio")).toString();
            Double rPromedio = Double.valueOf(Promedio);
            //Estado alumno
           
            if (rPromedio > 11.6) {
                String estadoAlumno = "Aprobado";
                model.setValueAt(estadoAlumno, i, model.findColumn("Estado"));
            } else if (rPromedio < 11.6) {
                String estadoAlumno = "Desaprobado";
                model.setValueAt(estadoAlumno, i, model.findColumn("Estado"));
            }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVista = new javax.swing.JTable();
        btnCerrarVentana = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblSeccion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 430));

        tblVista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombres y Apellidos", "", "", "", "", "Promedio", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tblVista);

        btnCerrarVentana.setBackground(new java.awt.Color(0, 153, 204));
        btnCerrarVentana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cerrarventana32x32.png"))); // NOI18N
        btnCerrarVentana.setBorder(null);
        btnCerrarVentana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarVentanaActionPerformed(evt);
            }
        });

        btnExportar.setBackground(new java.awt.Color(153, 153, 0));
        btnExportar.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/exportar.png"))); // NOI18N
        btnExportar.setText("Exportar");
        btnExportar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Vista Previa del Reporte de Notas");

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setText("Sección:");

        lblSeccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSeccion.setForeground(new java.awt.Color(255, 255, 255));
        lblSeccion.setText("-");
        lblSeccion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sección", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        lblSeccion.setPreferredSize(new java.awt.Dimension(230, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(248, 248, 248)
                        .addComponent(btnCerrarVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(378, 378, 378))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrarVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExportar)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarVentanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarVentanaActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarVentanaActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        // TODO add your handling code here:
        try {  
            DefaultTableModel modelo = (DefaultTableModel) tblVista.getModel();
            tblVista.setModel(modelo);
        DAODxS.ExportarTabla(tblVista, "Reporte_Notas_seccion_"+lblSeccion.getText());
        
        String rutaArchivo = new File("Reporte_Notas_seccion_"+lblSeccion.getText()+".xls").getAbsolutePath();

            // Abrir el archivo con la aplicación predeterminada
            File archivo = new File(rutaArchivo);
            Desktop.getDesktop().open(archivo);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(VistaReporteNotasxseccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_btnExportarActionPerformed

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
            java.util.logging.Logger.getLogger(VistaReporteNotasxseccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaReporteNotasxseccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaReporteNotasxseccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaReporteNotasxseccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaReporteNotasxseccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarVentana;
    private javax.swing.JButton btnExportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSeccion;
    private javax.swing.JTable tblVista;
    // End of variables declaration//GEN-END:variables
}
