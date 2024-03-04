/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frames_PanelsGenerales;


import DAO.TablasHorarioDocenteAlumno;
import Informacion.EstadoPeriodos;
import Informacion.Usuario;
import Informacion.ValoresEstaticos;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class HorarioSemanal extends javax.swing.JPanel {
    Usuario Usua = ValoresEstaticos.Usu;
    EstadoPeriodos estPe = ValoresEstaticos.VEPST;


    public HorarioSemanal() {
        initComponents();
        initRoles(Usua.getRol());
       
            txtBusqueda.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            filtrarTabla();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            filtrarTabla();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            filtrarTabla();
        }
    });
    
    }

     private void initRoles(String Roles) {
        switch (Roles) {
            case "Administrador":
                break;
            case "Docente":
                jPanelBase.setBackground(new Color(0, 153, 204));
                jPaneltabla.setBackground(new Color(120, 40, 238));
                JlTitulo.setBackground(new Color(0, 153, 204));
                jfondoTitutlo.setBackground(new Color(120, 40, 238));
                
                
                JlTitulo.setText("Horario Semanal Docente");
                jLblImangen.setIcon(new ImageIcon(getClass().getResource("/resources/Horario Docente.png")));
                
                TablasHorarioDocenteAlumno tablasHorarioDocente = new TablasHorarioDocenteAlumno();
                DefaultTableModel modeloTabla = tablasHorarioDocente.cargarTabla(jTableHorarios, "bdregistronotas", "", Usua,estPe);
                jTableHorarios.setModel(modeloTabla);

                break;
            case "Alumno":
                jPanelBase.setBackground(new Color(0, 102, 51));
                jPaneltabla.setBackground(new Color(51, 204, 0));
                jfondoTitutlo.setBackground(new Color(51, 204, 0));
                JlTitulo.setBackground(new Color(0, 102, 51));
                
                
                JlTitulo.setText("Horario Semanal Alumno");
                jLblImangen.setIcon(new ImageIcon(getClass().getResource("/resources/Horario Alumno.png")));
                
                TablasHorarioDocenteAlumno tablasHorarioDocente2 = new TablasHorarioDocenteAlumno();
                DefaultTableModel modeloTabla2 = tablasHorarioDocente2.cargarTablaAlumno(jTableHorarios, "bdregistronotas", "", Usua,estPe);
                jTableHorarios.setModel(modeloTabla2);
                break;
            default:
                JOptionPane.showMessageDialog(null, "ERROR 876121: Contacte con Soporte Tecnico");
                break;
        }
     }private void filtrarTabla() {
    TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTableHorarios.getModel());
    jTableHorarios.setRowSorter(sorter);

    String text = txtBusqueda.getText();
    if (text.trim().length() == 0) {
        sorter.setRowFilter(null);
    } else {
        // Filtrar por la columna "Curso"
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 1));
    }
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBase = new javax.swing.JPanel();
        jfondoTitutlo = new javax.swing.JPanel();
        JlTitulo = new javax.swing.JLabel();
        jPaneltabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableHorarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBusqueda = new javax.swing.JTextArea();
        jLblImangen = new javax.swing.JLabel();

        jPanelBase.setBackground(new java.awt.Color(57, 91, 126));
        jPanelBase.setMaximumSize(new java.awt.Dimension(1160, 537));
        jPanelBase.setMinimumSize(new java.awt.Dimension(1160, 537));

        jfondoTitutlo.setBackground(new java.awt.Color(0, 102, 204));

        JlTitulo.setBackground(new java.awt.Color(0, 153, 204));
        JlTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        JlTitulo.setForeground(new java.awt.Color(255, 255, 255));
        JlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlTitulo.setToolTipText("");
        JlTitulo.setBorder(new javax.swing.border.MatteBorder(null));
        JlTitulo.setOpaque(true);

        javax.swing.GroupLayout jfondoTitutloLayout = new javax.swing.GroupLayout(jfondoTitutlo);
        jfondoTitutlo.setLayout(jfondoTitutloLayout);
        jfondoTitutloLayout.setHorizontalGroup(
            jfondoTitutloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jfondoTitutloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 1124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jfondoTitutloLayout.setVerticalGroup(
            jfondoTitutloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jfondoTitutloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPaneltabla.setBackground(new java.awt.Color(51, 204, 0));

        jTableHorarios.setBackground(new java.awt.Color(255, 255, 255));
        jTableHorarios.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jTableHorarios.setForeground(new java.awt.Color(0, 0, 0));
        jTableHorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Seccion", "Curso", "Dia", "Turno", "Periodo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableHorarios.setOpaque(false);
        jScrollPane2.setViewportView(jTableHorarios);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Buscar :");

        txtBusqueda.setColumns(20);
        txtBusqueda.setRows(1);
        txtBusqueda.setToolTipText("");
        txtBusqueda.setAutoscrolls(false);
        jScrollPane1.setViewportView(txtBusqueda);

        javax.swing.GroupLayout jPaneltablaLayout = new javax.swing.GroupLayout(jPaneltabla);
        jPaneltabla.setLayout(jPaneltablaLayout);
        jPaneltablaLayout.setHorizontalGroup(
            jPaneltablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneltablaLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPaneltablaLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPaneltablaLayout.setVerticalGroup(
            jPaneltablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneltablaLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPaneltablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jLblImangen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Horario Docente.png"))); // NOI18N
        jLblImangen.setText("jLabel1");

        javax.swing.GroupLayout jPanelBaseLayout = new javax.swing.GroupLayout(jPanelBase);
        jPanelBase.setLayout(jPanelBaseLayout);
        jPanelBaseLayout.setHorizontalGroup(
            jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBaseLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLblImangen, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPaneltabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(jPanelBaseLayout.createSequentialGroup()
                        .addComponent(jfondoTitutlo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(18, Short.MAX_VALUE))))
        );
        jPanelBaseLayout.setVerticalGroup(
            jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jfondoTitutlo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLblImangen, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBaseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPaneltabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLblImangen;
    private javax.swing.JPanel jPanelBase;
    private javax.swing.JPanel jPaneltabla;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableHorarios;
    private javax.swing.JPanel jfondoTitutlo;
    private javax.swing.JTextArea txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
