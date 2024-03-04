/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frames_PanelsDocente;


import DAO.HorarioCicloSeccion;
import Frames_PanelsDocente.*;
import Informacion.Docente;
import Informacion.DocentexSecciones;
import Informacion.EstadoPeriodos;
import Informacion.NotasDetalles;
import Informacion.Usuario;
import Informacion.ValoresEstaticos;
import Interfaces.DAODocentexSeccionesImplement;
import Interfaces.DAONotasDetallesImplement;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author medal
 */
public class PanelDetallesCurso extends javax.swing.JPanel {

    Usuario Usua = ValoresEstaticos.Usu;
    Docente DocS = ValoresEstaticos.Doc;
    EstadoPeriodos VEPST = ValoresEstaticos.VEPST;
    DocentexSecciones DxS = new DocentexSecciones();
    DocentexSecciones EDxS = ValoresEstaticos.VEDxS;
    DAODocentexSeccionesImplement DAODxS = new DAODocentexSeccionesImplement();

    HorarioCicloSeccion HS = new HorarioCicloSeccion();
    NotasDetalles ND = new NotasDetalles();
    NotasDetalles END = ValoresEstaticos.VEND;

    public PanelDetallesCurso() {
        initComponents();
        DxS.setDocenteID(Usua.getID());
        DxS.setPeriodoID(VEPST.getIdp());
        DxS.setNombreCurso(EDxS.getNombreCurso());
        DxS.setNroseccionDoc(EDxS.getNroseccionDoc());
        DxS.setNombreCurso(EDxS.getNombreCurso());
        DxS.setNroseccionDoc(EDxS.getNroseccionDoc());
        EDxS.setDocenteID(DxS.getDocenteID());
        EDxS.setPeriodoID(DxS.getPeriodoID());
        lblHorario.setText(HS.CargarHorario(DxS.getNroseccionDoc(), null));
        lblCurso.setText(DxS.getNombreCurso());
        lblSeccion.setText(Integer.toString(DxS.getNroseccionDoc()));
        DAODxS.CargarAlumnosxSeccion(DxS, tblDetallesCurso);
        DAODxS.DefinirNroNotasSubidas(DxS);
        if (DxS.getNroNotaActual()==4) {
            DxS.setValidador(1);
        }
        for (int i = 0; i < 4; i++) {
            DAODxS.CargarNombresTiposyPorcentajes(DxS, i);
            
        }
        EDxS.setNotasNombresF(DxS.getNotasNombresF());
        EDxS.setNotasPorcentajesF(DxS.getNotasPorcentajesF());
        EDxS.setNotasTiposF(DxS.getNotasTiposF());
        LblNota1Texto.setText(DxS.getNotasNombres(0));
        LblNota2Texto.setText(DxS.getNotasNombres(1));
        LblNota3Texto.setText(DxS.getNotasNombres(2));
        LblNota4Texto.setText(DxS.getNotasNombres(3));
        txtBuscador.getDocument().addDocumentListener(new DocumentListener() {
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

    private void filtrarTabla() {
        String filtro = txtBuscador.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>((DefaultTableModel) tblDetallesCurso.getModel());
        tblDetallesCurso.setRowSorter(rowSorter);

        if (filtro.length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
//            int columnaFiltro = tblDetallesCurso.getColumnModel().getColumnIndex("Nombres y Apellidos");
//            rowSorter.setRowFilter(RowFilter.regexFilter(filtro, columnaFiltro));
            RowFilter<Object, Object> rowFilter = RowFilter.regexFilter("(?i)" + filtro);
            rowSorter.setRowFilter(rowFilter);
        }
    }

    class Render extends DefaultTableCellRenderer {

        private final JButton button = new JButton("Simular");

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (column == table.getColumnCount() - 2) { // Penúltima columna
                button.setText("Simular");
            } else if (column == table.getColumnCount() - 1) { // Última columna
                button.setText("Registrar");
            }
            button.setBackground(new Color(55, 156, 22));
            button.setForeground(Color.WHITE);
            return button;
        }
    }

    class ButtonEditor extends DefaultCellEditor {

        private final JButton button;

        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.setBackground(new Color(55, 156, 22));
            button.setForeground(Color.WHITE);
            button.addActionListener(e -> fireEditingStopped());
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (column == table.getColumnCount() - 2) {
                button.setText("Simular");
            } else if (column == table.getColumnCount() - 1) {
                button.setText("Registrar");
            }

            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                // Realiza acciones al hacer clic en el botón
                String buttonText = button.getText();
                if (buttonText.equals("Simular")) {
                    // Acciones para Simular

                    PanelSimulador pSim = new PanelSimulador();
                    mostrarTipo(pSim);
                } else if (buttonText.equals("Registrar")) {
                    // Acciones para Registrar
                    if (VEPST.getEstadop().equals("En Curso")) {
                        RegistroDeNotas rNotas = new RegistroDeNotas();
                        rNotas.setVisible(true);
                        rNotas.setLocationRelativeTo(rNotas);
                    } else {
                        JOptionPane.showMessageDialog(null, "El periodo actual no se encuentra habilitado para registrar notas");

                    }

                }
            }
            isPushed = false;
            return button.getText();
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

    }

    public boolean Existe(double nota) {
        boolean existe;
        existe = (nota != 99);
//        System.out.println(nota);
        return existe;
    }

    public void mostrarTipo(JPanel j) {

        j.setSize(1160, 537);
        j.setLocation(0, 0);

        PnlDetallesCurso.removeAll();
        PnlDetallesCurso.add(j, BorderLayout.CENTER);
        PnlDetallesCurso.revalidate();
        PnlDetallesCurso.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlDetallesCurso = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblSeccion = new javax.swing.JLabel();
        lblCurso = new javax.swing.JLabel();
        lblHorario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetallesCurso = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        LblNota1Texto = new javax.swing.JLabel();
        LblNota2Texto = new javax.swing.JLabel();
        LblNota3Texto = new javax.swing.JLabel();
        LblNota4Texto = new javax.swing.JLabel();
        LblNota1 = new javax.swing.JLabel();
        LblNota2 = new javax.swing.JLabel();
        LblNota4 = new javax.swing.JLabel();
        LblNota3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        LblNotaF = new javax.swing.JLabel();
        BtnExpNotas = new javax.swing.JButton();
        BtnSubirNota = new javax.swing.JButton();
        txtBuscador = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        PnlDetallesCurso.setBackground(new java.awt.Color(0, 153, 204));
        PnlDetallesCurso.setPreferredSize(new java.awt.Dimension(1160, 537));

        jPanel2.setBackground(new java.awt.Color(153, 102, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(1148, 63));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Detalles del Curso");

        jButton1.setBackground(new java.awt.Color(153, 102, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/flecha_ant__1.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 382, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(442, 442, 442))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(248, 248, 212));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setText("Sección:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 34, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel3.setText("Curso:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 33, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel4.setText("Horario:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(822, 35, -1, -1));

        lblSeccion.setBackground(new java.awt.Color(255, 255, 255));
        lblSeccion.setBorder(javax.swing.BorderFactory.createTitledBorder("Sección"));
        lblSeccion.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel3.add(lblSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 16, -1, -1));

        lblCurso.setBackground(new java.awt.Color(255, 255, 255));
        lblCurso.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblCurso.setBorder(javax.swing.BorderFactory.createTitledBorder("Curso"));
        lblCurso.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel3.add(lblCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 16, 232, -1));

        lblHorario.setBackground(new java.awt.Color(255, 255, 255));
        lblHorario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblHorario.setBorder(javax.swing.BorderFactory.createTitledBorder("Horario"));
        lblHorario.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel3.add(lblHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(895, 16, 226, -1));

        tblDetallesCurso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        tblDetallesCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombres y Apellidos", "Simulador", "Registrar Nota"
            }
        ));
        tblDetallesCurso.setGridColor(new java.awt.Color(102, 102, 102));
        tblDetallesCurso.setRowHeight(30);
        tblDetallesCurso.setShowGrid(true);
        tblDetallesCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDetallesCursoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDetallesCurso);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 683, 290));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/wwww.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 15, 106, 51));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/wh.png"))); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(698, 16, 90, 43));

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(255, 204, 102), null));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/clipp__1.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Vista previa del avance del Alumno:");

        LblNota1Texto.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        LblNota1Texto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblNota1Texto.setText("Nota1:");
        LblNota1Texto.setPreferredSize(new java.awt.Dimension(150, 30));

        LblNota2Texto.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        LblNota2Texto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblNota2Texto.setText("Nota2:");
        LblNota2Texto.setPreferredSize(new java.awt.Dimension(150, 30));

        LblNota3Texto.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        LblNota3Texto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblNota3Texto.setText("Nota3:");
        LblNota3Texto.setPreferredSize(new java.awt.Dimension(150, 30));

        LblNota4Texto.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        LblNota4Texto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblNota4Texto.setText("Nota4:");
        LblNota4Texto.setPreferredSize(new java.awt.Dimension(150, 30));

        LblNota1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        LblNota1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblNota1.setText("-");
        LblNota1.setPreferredSize(new java.awt.Dimension(40, 30));

        LblNota2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        LblNota2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblNota2.setText("-");
        LblNota2.setPreferredSize(new java.awt.Dimension(40, 30));

        LblNota4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        LblNota4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblNota4.setText("-");
        LblNota4.setPreferredSize(new java.awt.Dimension(40, 30));

        LblNota3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        LblNota3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblNota3.setText("-");
        LblNota3.setPreferredSize(new java.awt.Dimension(40, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(LblNota1Texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(LblNota1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8))
                        .addGap(67, 67, 67)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LblNota2Texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(LblNota2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LblNota3Texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(LblNota3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LblNota4Texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(LblNota4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblNota1Texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(LblNota1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblNota2Texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(LblNota2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblNota3Texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(LblNota3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblNota4Texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(LblNota4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 84, 388, -1));

        jPanel4.setBackground(new java.awt.Color(204, 255, 153));

        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 102, 0));
        jLabel18.setText("Promedio:");

        LblNotaF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LblNotaF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblNotaF.setText("-");
        LblNotaF.setPreferredSize(new java.awt.Dimension(50, 40));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(28, 28, 28)
                .addComponent(LblNotaF, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(LblNotaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 321, 388, -1));

        BtnExpNotas.setBackground(new java.awt.Color(153, 0, 51));
        BtnExpNotas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BtnExpNotas.setText("Exportar Notas");
        BtnExpNotas.setBorder(null);
        BtnExpNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExpNotasActionPerformed(evt);
            }
        });
        jPanel3.add(BtnExpNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(956, 405, 134, 39));

        BtnSubirNota.setBackground(new java.awt.Color(0, 153, 255));
        BtnSubirNota.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BtnSubirNota.setText("Subir Notas");
        BtnSubirNota.setBorder(null);
        BtnSubirNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSubirNotaActionPerformed(evt);
            }
        });
        jPanel3.add(BtnSubirNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(757, 405, 130, 39));

        txtBuscador.setPreferredSize(new java.awt.Dimension(70, 40));
        txtBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorActionPerformed(evt);
            }
        });
        txtBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscadorKeyTyped(evt);
            }
        });
        jPanel3.add(txtBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 560, -1));

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Buscar Alumno:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 80, -1));

        javax.swing.GroupLayout PnlDetallesCursoLayout = new javax.swing.GroupLayout(PnlDetallesCurso);
        PnlDetallesCurso.setLayout(PnlDetallesCursoLayout);
        PnlDetallesCursoLayout.setHorizontalGroup(
            PnlDetallesCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlDetallesCursoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(PnlDetallesCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnlDetallesCursoLayout.setVerticalGroup(
            PnlDetallesCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlDetallesCursoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlDetallesCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PnlDetallesCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDetallesCursoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetallesCursoMousePressed
        // TODO add your handling code here:
        int fila = tblDetallesCurso.getSelectedRow();

        if (fila != -1) {
            String Codigo = tblDetallesCurso.getValueAt(fila, tblDetallesCurso.getColumnModel().getColumnIndex("Codigo")).toString();
            String NombreC = tblDetallesCurso.getValueAt(fila, tblDetallesCurso.getColumnModel().getColumnIndex("Nombres y Apellidos")).toString();
            DxS.setCodAlumno(Codigo);
            DAODxS.CargarNotasFinalesAlumno(DxS);
            //Aqui se define de forma estatica el id del alumno y el nombre completo y se guarda en caso 
            //cambies a otro panel como Rgistrar o Simular, claro que en el otro panel lo tienes que invocar
            EDxS.setAlumnoID(DxS.getAlumnoID());
            EDxS.setNCMAlumno(NombreC);
            EDxS.setCodAlumno(DxS.getCodAlumno());
            EDxS.setNroNotasRegistradasxAlumno(DxS.getNroNotasRegistradasxAlumno());
            EDxS.setNroAlumnos(DxS.getNroAlumnos());
            //Validar 5 notas esto lo podrias replicar en el simulador
            for (int i = 0; i < 4; i++) {
                EDxS.setNotas(i, DxS.getNotas(i));
            }
            EDxS.setPF(DxS.getPF());
            if (Existe(DxS.getNotas(0))) {
                LblNota1.setText(Double.toString(EDxS.getNotas(0)));
            } else {
                LblNota1.setText("-");
            }
            if (Existe(DxS.getNotas(1))) {
                LblNota2.setText(Double.toString(EDxS.getNotas(1)));
            } else {
                LblNota2.setText("-");
            }
            if (Existe(DxS.getNotas(2))) {
                LblNota3.setText(Double.toString(EDxS.getNotas(2)));
            } else {
                LblNota3.setText("-");
            }
            if (Existe(DxS.getNotas(3))) {
                LblNota4.setText(Double.toString(EDxS.getNotas(3)));
            } else {
                LblNota4.setText("-");
            }
            if (Existe(DxS.getPF())) {
                LblNotaF.setText(Double.toString(DxS.getPF()));
            } else {
                LblNotaF.setText("-");
            }

        }

        tblDetallesCurso.getColumnModel().getColumn(tblDetallesCurso.getColumnCount() - 1).setCellRenderer(new Render());
        tblDetallesCurso.getColumnModel().getColumn(tblDetallesCurso.getColumnCount() - 1).setCellEditor(new ButtonEditor(new JCheckBox()));

        tblDetallesCurso.getColumnModel().getColumn(tblDetallesCurso.getColumnCount() - 2).setCellRenderer(new Render());
        tblDetallesCurso.getColumnModel().getColumn(tblDetallesCurso.getColumnCount() - 2).setCellEditor(new ButtonEditor(new JCheckBox()));
    }//GEN-LAST:event_tblDetallesCursoMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PanelVerCurso pVC = new PanelVerCurso();
        mostrarTipo(pVC);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BtnExpNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExpNotasActionPerformed
 
        if (DxS.getNroNotaActual() == 4 || VEPST.getEstadop().equals("Finalizado")) {
               VistaReporteNotasxseccion irRegN = new VistaReporteNotasxseccion();
            irRegN.setVisible(true);
            } else {

            JOptionPane.showMessageDialog(null, "El periodo actual no se encuentra habilitado para exportar notas\nEspere a que finalice el periodo");

        }
    }//GEN-LAST:event_BtnExpNotasActionPerformed

    private void BtnSubirNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSubirNotaActionPerformed
        if (VEPST.getEstadop().equals("En Curso")) {
            DAODxS.SubirNotas(DxS, ND);
            if (DxS.getNroNotaActual() == 4 && DxS.getValidador()==0) {
                for (int i = 0; i < DxS.getNroAlumnos(); i++) {
                    DAODxS.InsertarPromedioFinal(DxS, i);
                       DxS.setValidador(1);
                }
            }

        } else {

            JOptionPane.showMessageDialog(null, "El periodo actual no se encuentra habilitado para subir notas");

        }


    }//GEN-LAST:event_BtnSubirNotaActionPerformed

    private void txtBuscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
            evt.consume(); // Ignora el evento si no es una letra o un espacio
        }
    }//GEN-LAST:event_txtBuscadorKeyTyped

    private void txtBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnExpNotas;
    private javax.swing.JButton BtnSubirNota;
    private javax.swing.JLabel LblNota1;
    private javax.swing.JLabel LblNota1Texto;
    private javax.swing.JLabel LblNota2;
    private javax.swing.JLabel LblNota2Texto;
    private javax.swing.JLabel LblNota3;
    private javax.swing.JLabel LblNota3Texto;
    private javax.swing.JLabel LblNota4;
    private javax.swing.JLabel LblNota4Texto;
    private javax.swing.JLabel LblNotaF;
    private javax.swing.JPanel PnlDetallesCurso;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblSeccion;
    private javax.swing.JTable tblDetallesCurso;
    private javax.swing.JTextField txtBuscador;
    // End of variables declaration//GEN-END:variables
}
