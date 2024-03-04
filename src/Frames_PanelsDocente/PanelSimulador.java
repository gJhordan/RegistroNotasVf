/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frames_PanelsDocente;

import Informacion.DocentexSecciones;
import Informacion.EstadoPeriodos;
import Informacion.Usuario;
import Informacion.ValoresEstaticos;
import Interfaces.DAODocentexSeccionesImplement;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 *
 * @author medal
 */
public class PanelSimulador extends javax.swing.JPanel {

    DocentexSecciones DxS = new DocentexSecciones();
    DocentexSecciones EDxS = ValoresEstaticos.VEDxS;
    Usuario Usua = ValoresEstaticos.Usu;
    EstadoPeriodos VEPST = ValoresEstaticos.VEPST;
    DAODocentexSeccionesImplement DAODxS = new DAODocentexSeccionesImplement();

    public PanelSimulador() {
        initComponents();

        DxS.setDocenteID(Usua.getID());
        DxS.setPeriodoID(VEPST.getIdp());
        DxS.setNombreCurso(EDxS.getNombreCurso());
        DxS.setNroseccionDoc(EDxS.getNroseccionDoc());
        DxS.setNombreCurso(EDxS.getNombreCurso());
        DxS.setNroseccionDoc(EDxS.getNroseccionDoc());
        DxS.setAlumnoID(EDxS.getAlumnoID());
        DxS.setNCMAlumno(EDxS.getNCMAlumno());
        DxS.setAlumnoID(EDxS.getAlumnoID());
        DxS.setCodAlumno(EDxS.getCodAlumno());
        EDxS.setNCMAlumno(DxS.getNCMAlumno());
        EDxS.setDocenteID(DxS.getDocenteID());
        EDxS.setPeriodoID(DxS.getPeriodoID());
       
        DxS.setNotasNombresF(EDxS.getNotasNombresF());
        DxS.setNotasPorcentajesF(EDxS.getNotasPorcentajesF());
        DxS.setNotasTiposF(EDxS.getNotasTiposF());

        //llenar label nombre notas
//        DAODxS.CargarNombresTiposyPorcentajes(DxS, ERROR);
        lblNombreN1.setText(DxS.getNotasNombres(0));
        lblNombreN2.setText(DxS.getNotasNombres(1));
        lblNombreN3.setText(DxS.getNotasNombres(2));
        lblNombreN4.setText(DxS.getNotasNombres(3));
        //llenar porcentajes de notas
        lblPorc1.setText(Integer.toString(EDxS.getNotasPorcentajes(0)));
        lblPorc2.setText(Integer.toString(EDxS.getNotasPorcentajes(1)));
        lblPorc3.setText(Integer.toString(EDxS.getNotasPorcentajes(2)));
        lblPorc4.setText(Integer.toString(EDxS.getNotasPorcentajes(3)));
        //llenar label's datos alumno
        lblCodigoA.setText(DxS.getCodAlumno());
        lblNombre.setText(DxS.getNCMAlumno());
        //bloquear label de Nota esperada
        lblNotaEsperada.setVisible(false);
        lblInfo.setVisible(false);

        sld1.setValue(sld1.getMaximum());
        lblNota1.setText("" + sld1.getValue());
        sld2.setValue(sld2.getMaximum());
        lblNota2.setText("" + sld2.getValue());
        sld3.setValue(sld3.getMaximum());
        lblNota3.setText("" + sld3.getValue());
        sld4.setValue(sld4.getMaximum());
        lblNota4.setText("" + sld4.getValue());

        for (int i = 0; i < 4; i++) {
            DAODxS.CargarNombresTiposyPorcentajes(DxS, i);
        }
        EDxS.setNotasNombresF(DxS.getNotasNombresF());
        EDxS.setNotasPorcentajesF(DxS.getNotasPorcentajesF());
        EDxS.setNotasTiposF(DxS.getNotasTiposF());

        CargarLabelNota();
       }

    public void mostrarTipo(JPanel j) {

        j.setSize(1160, 537);
        j.setLocation(0, 0);

        pnlSimulador.removeAll();
        pnlSimulador.add(j, BorderLayout.CENTER);
        pnlSimulador.revalidate();
        pnlSimulador.repaint();
    }

    public static boolean Existe(double nota) {
        boolean existe;
        existe = (nota != 99);
        return existe;
    }

    private void PromedioSimulado() {
        int porcentaje1 = DxS.getNotasPorcentajes(0);
        int porcentaje2 = DxS.getNotasPorcentajes(1);
        int porcentaje3 = DxS.getNotasPorcentajes(2);
        int porcentaje4 = DxS.getNotasPorcentajes(3);

        double valorLbl1 = Double.parseDouble(lblNota1.getText());
        double valorLbl2 = Double.parseDouble(lblNota2.getText());
        double valorLbl3 = Double.parseDouble(lblNota3.getText());
        double valorLbl4 = Double.parseDouble(lblNota4.getText());

        // Multiplicamos cada valor por el porcentaje
        valorLbl1 *= (porcentaje1 / 100.0);
        valorLbl2 *= (porcentaje2 / 100.0);
        valorLbl3 *= (porcentaje3 / 100.0);
        valorLbl4 *= (porcentaje4 / 100.0);

        double promedio = Math.round((valorLbl1 + valorLbl2 + valorLbl3 + valorLbl4) * 100.0) / 100.0;
        lblPromSim.setText(Double.toString(promedio));

        // Mostrar "Aprobado" o "Desaprobado" en una etiqueta y aplicar el formato visual
        if (promedio > 11.5) {
            lblMensaje.setText("Aprobado");
            lblMensaje.setForeground(Color.WHITE);
            lblMensaje.setBackground(new Color(0, 128, 0)); // Verde oscuro
            lblNotaEsperada.setVisible(false);
            lblInfo.setVisible(false);
        } else {
            lblMensaje.setText("Desaprobado");
            lblMensaje.setForeground(Color.WHITE);
            lblMensaje.setBackground(new Color(139, 0, 0)); // Rojo oscuro
            
        //Mostrar cuánto le falta para aprobar
        double valorNecesitado = Math.round((11.6-(valorLbl1+valorLbl2+valorLbl3))* 100.0) / 100.0;
        double notaEsperada = (valorNecesitado*100)/porcentaje4;
        if(notaEsperada > 20){
        lblNotaEsperada.setVisible(false);
        lblInfo.setVisible(false);
        }else if (notaEsperada<=20){
        lblNotaEsperada.setVisible(true);
        lblInfo.setVisible(true);
        lblNotaEsperada.setText(Double.toString(notaEsperada));
        }
        }
        lblMensaje.setOpaque(true);
    }

    private void PromedioActual() {
        CargarLabelNota();

        double porcentaje1 = DxS.getNotasPorcentajes(0);
        double porcentaje2 = DxS.getNotasPorcentajes(1);
        double porcentaje3 = DxS.getNotasPorcentajes(2);
        double porcentaje4 = DxS.getNotasPorcentajes(3);

        // Variables para almacenar los valores de los sliders bloqueados
        double valorSliderBloqueado1;
        double valorSliderBloqueado2;
        double valorSliderBloqueado3;
        double valorSliderBloqueado4;
        // Calcular el promedio solo para sliders bloqueados
        int slidersBloqueados = 0;
        double sumaValoresSlidersBloqueados = 0;

        if (!sld1.isEnabled()) {
            slidersBloqueados++;
            valorSliderBloqueado1 = Double.parseDouble(lblNota1.getText());
            sumaValoresSlidersBloqueados += valorSliderBloqueado1 * (porcentaje1 / 100.0);
        }

        if (!sld2.isEnabled()) {
            slidersBloqueados++;
            valorSliderBloqueado2 = Double.parseDouble(lblNota2.getText());
            sumaValoresSlidersBloqueados += valorSliderBloqueado2 * (porcentaje2 / 100.0);
        }

        if (!sld3.isEnabled()) {
            slidersBloqueados++;
            valorSliderBloqueado3 = Double.parseDouble(lblNota3.getText());
            sumaValoresSlidersBloqueados += valorSliderBloqueado3 * (porcentaje3 / 100.0);
        }

        if (!sld4.isEnabled()) {
            slidersBloqueados++;
            valorSliderBloqueado4 = Double.parseDouble(lblNota4.getText());
            sumaValoresSlidersBloqueados += valorSliderBloqueado4 * (porcentaje4 / 100.0);
        }
        // Calcular el promedio solo si hay al menos un slider bloqueado
        if (slidersBloqueados > 0) {
            double promedioAct = sumaValoresSlidersBloqueados;
            // Hacer algo con el promedio, por ejemplo, mostrarlo
            lblPromAct.setText(Double.toString(promedioAct));
        }
    }

    private void CargarLabelNota() {
        DAODxS.CargarNotasFinalesAlumno(DxS);
        for (int i = 0; i < 4; i++) {
            EDxS.setNotas(i, DxS.getNotas(i));
        }
        if (Existe(DxS.getNotas(0))) {
            lblNota1.setText(Double.toString(EDxS.getNotas(0)));
            sld1.setEnabled(false);
        }

        if (Existe(DxS.getNotas(1))) {
            lblNota2.setText(Double.toString(EDxS.getNotas(1)));
            sld2.setEnabled(false);
        }

        if (Existe(DxS.getNotas(2))) {
            lblNota3.setText(Double.toString(EDxS.getNotas(2)));
            sld3.setEnabled(false);
        }

        if (Existe(DxS.getNotas(3))) {
            lblNota4.setText(Double.toString(EDxS.getNotas(3)));
            sld4.setEnabled(false);
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

        pnlSimulador = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblCodigoA = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblNombreN1 = new javax.swing.JLabel();
        lblNombreN2 = new javax.swing.JLabel();
        lblNombreN3 = new javax.swing.JLabel();
        lblNombreN4 = new javax.swing.JLabel();
        lblNota1 = new javax.swing.JLabel();
        lblNota2 = new javax.swing.JLabel();
        lblNota3 = new javax.swing.JLabel();
        lblNota4 = new javax.swing.JLabel();
        sld1 = new javax.swing.JSlider();
        sld2 = new javax.swing.JSlider();
        sld3 = new javax.swing.JSlider();
        sld4 = new javax.swing.JSlider();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        lblPromAct = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblPromSim = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        btnSimulador = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        lblPorc4 = new javax.swing.JLabel();
        lblPorc1 = new javax.swing.JLabel();
        lblPorc2 = new javax.swing.JLabel();
        lblPorc3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();
        lblNotaEsperada = new javax.swing.JLabel();

        pnlSimulador.setBackground(new java.awt.Color(0, 153, 204));
        pnlSimulador.setPreferredSize(new java.awt.Dimension(1160, 537));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 255));
        jLabel1.setText("Simulador");

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 255, 255));
        jLabel2.setText("de Notas");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Aquí podrás calcular las próximas");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("notas correspondientes al alumo:");

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 204));
        jLabel5.setText("Código del Alumno:");

        lblCodigoA.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblCodigoA.setForeground(new java.awt.Color(255, 255, 204));
        lblCodigoA.setText("-");
        lblCodigoA.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Código", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 204))); // NOI18N
        lblCodigoA.setPreferredSize(new java.awt.Dimension(150, 50));

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 204));
        jLabel9.setText("Nombres:");

        lblNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 204));
        lblNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombres", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 204))); // NOI18N
        lblNombre.setPreferredSize(new java.awt.Dimension(170, 50));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/wwww.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(57, 57, 57))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel26))
                            .addComponent(jLabel4)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCodigoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCodigoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(20, 130, 130));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/profee.png"))); // NOI18N

        lblNombreN1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblNombreN1.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreN1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombreN1.setText("Nota1:");
        lblNombreN1.setPreferredSize(new java.awt.Dimension(150, 50));

        lblNombreN2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblNombreN2.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreN2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombreN2.setText("Nota2:");
        lblNombreN2.setPreferredSize(new java.awt.Dimension(150, 50));

        lblNombreN3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblNombreN3.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreN3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombreN3.setText("Nota3:");
        lblNombreN3.setPreferredSize(new java.awt.Dimension(150, 50));

        lblNombreN4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblNombreN4.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreN4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombreN4.setText("Nota4:");
        lblNombreN4.setPreferredSize(new java.awt.Dimension(150, 50));

        lblNota1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblNota1.setForeground(new java.awt.Color(255, 255, 255));
        lblNota1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNota1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        lblNota1.setPreferredSize(new java.awt.Dimension(70, 50));

        lblNota2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblNota2.setForeground(new java.awt.Color(255, 255, 255));
        lblNota2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNota2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        lblNota2.setPreferredSize(new java.awt.Dimension(70, 50));

        lblNota3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblNota3.setForeground(new java.awt.Color(255, 255, 255));
        lblNota3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNota3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        lblNota3.setPreferredSize(new java.awt.Dimension(70, 50));

        lblNota4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblNota4.setForeground(new java.awt.Color(255, 255, 255));
        lblNota4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNota4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        lblNota4.setPreferredSize(new java.awt.Dimension(70, 50));

        sld1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sld1.setForeground(new java.awt.Color(255, 255, 0));
        sld1.setMajorTickSpacing(5);
        sld1.setMaximum(20);
        sld1.setMinorTickSpacing(1);
        sld1.setSnapToTicks(true);
        sld1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sld1StateChanged(evt);
            }
        });

        sld2.setForeground(new java.awt.Color(255, 255, 0));
        sld2.setMajorTickSpacing(1);
        sld2.setMaximum(20);
        sld2.setMinorTickSpacing(1);
        sld2.setSnapToTicks(true);
        sld2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sld2StateChanged(evt);
            }
        });

        sld3.setForeground(new java.awt.Color(255, 255, 0));
        sld3.setMajorTickSpacing(1);
        sld3.setMaximum(20);
        sld3.setMinorTickSpacing(1);
        sld3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sld3StateChanged(evt);
            }
        });

        sld4.setForeground(new java.awt.Color(255, 255, 0));
        sld4.setMajorTickSpacing(1);
        sld4.setMaximum(20);
        sld4.setMinorTickSpacing(1);
        sld4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sld4StateChanged(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("%");
        jLabel16.setMaximumSize(new java.awt.Dimension(11, 13));
        jLabel16.setPreferredSize(new java.awt.Dimension(11, 20));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("%");
        jLabel17.setPreferredSize(new java.awt.Dimension(30, 20));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("%");
        jLabel18.setPreferredSize(new java.awt.Dimension(30, 20));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("%");
        jLabel19.setPreferredSize(new java.awt.Dimension(30, 20));

        jPanel4.setBackground(new java.awt.Color(153, 51, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel20.setText("Promedio ACTUAL:");

        lblPromAct.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPromAct.setForeground(new java.awt.Color(255, 255, 255));
        lblPromAct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPromAct.setText("-");
        lblPromAct.setPreferredSize(new java.awt.Dimension(70, 50));

        jLabel23.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel23.setText("Promedio SIMULADO:");

        lblPromSim.setBackground(new java.awt.Color(255, 255, 204));
        lblPromSim.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPromSim.setForeground(new java.awt.Color(255, 255, 255));
        lblPromSim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPromSim.setText("-");
        lblPromSim.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        lblPromSim.setPreferredSize(new java.awt.Dimension(70, 50));

        lblMensaje.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensaje.setText("-");
        lblMensaje.setPreferredSize(new java.awt.Dimension(103, 50));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(lblPromAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(lblPromSim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPromAct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel23)
                    .addComponent(lblPromSim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnSimulador.setBackground(new java.awt.Color(102, 0, 0));
        btnSimulador.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnSimulador.setForeground(new java.awt.Color(255, 255, 255));
        btnSimulador.setText("Simular");
        btnSimulador.setPreferredSize(new java.awt.Dimension(180, 40));
        btnSimulador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimuladorActionPerformed(evt);
            }
        });

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/lnn.png"))); // NOI18N

        lblPorc4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPorc4.setForeground(new java.awt.Color(255, 255, 255));
        lblPorc4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPorc4.setText("-");
        lblPorc4.setPreferredSize(new java.awt.Dimension(15, 20));

        lblPorc1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPorc1.setForeground(new java.awt.Color(255, 255, 255));
        lblPorc1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPorc1.setText("-");
        lblPorc1.setPreferredSize(new java.awt.Dimension(15, 20));

        lblPorc2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPorc2.setForeground(new java.awt.Color(255, 255, 255));
        lblPorc2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPorc2.setText("-");
        lblPorc2.setPreferredSize(new java.awt.Dimension(15, 20));

        lblPorc3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPorc3.setForeground(new java.awt.Color(255, 255, 255));
        lblPorc3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPorc3.setText("-");
        lblPorc3.setPreferredSize(new java.awt.Dimension(15, 20));

        jButton2.setBackground(new java.awt.Color(20, 130, 130));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/flecha_ant__1.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblInfo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblInfo.setForeground(new java.awt.Color(0, 0, 102));
        lblInfo.setText("El alumno, para aprobar necesita obtener en la última nota, un puntaje de:");

        lblNotaEsperada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNotaEsperada.setForeground(new java.awt.Color(0, 0, 102));
        lblNotaEsperada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNotaEsperada.setText("-");
        lblNotaEsperada.setPreferredSize(new java.awt.Dimension(40, 18));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton2)
                        .addGap(49, 49, 49)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel11)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNombreN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNombreN3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNombreN4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNota3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNota4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNota2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblNombreN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNota1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(91, 91, 91)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(sld1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPorc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(sld4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblPorc4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(sld2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblPorc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(sld3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblPorc3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel27))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNotaEsperada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(btnSimulador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNombreN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNota1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(258, 258, 258))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblNota2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblNombreN3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblNota3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lblNombreN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombreN4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNota4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sld1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPorc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(sld2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPorc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(sld3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPorc3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(83, 83, 83))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel27)
                                .addGap(60, 60, 60)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sld4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPorc4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimulador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInfo)
                    .addComponent(lblNotaEsperada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlSimuladorLayout = new javax.swing.GroupLayout(pnlSimulador);
        pnlSimulador.setLayout(pnlSimuladorLayout);
        pnlSimuladorLayout.setHorizontalGroup(
            pnlSimuladorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSimuladorLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSimuladorLayout.setVerticalGroup(
            pnlSimuladorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSimuladorLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlSimuladorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSimulador, javax.swing.GroupLayout.DEFAULT_SIZE, 1185, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSimulador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sld1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sld1StateChanged
        JSlider source = (JSlider) evt.getSource();
        lblNota1.setText("" + source.getMaximum());
        if (!source.getValueIsAdjusting()) {
            int valorSlider = source.getValue();
            lblNota1.setText("" + valorSlider);
        }
    }//GEN-LAST:event_sld1StateChanged

    private void sld2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sld2StateChanged
        JSlider source = (JSlider) evt.getSource();
        lblNota2.setText("" + source.getMaximum());
        if (!source.getValueIsAdjusting()) {
            int valorSlider = source.getValue();
            lblNota2.setText("" + valorSlider);
        }
    }//GEN-LAST:event_sld2StateChanged

    private void sld3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sld3StateChanged
        JSlider source = (JSlider) evt.getSource();
//        lblNota3.setText("" + source.getMaximum());
        if (!source.getValueIsAdjusting()) {
            int valorSlider = source.getValue();
            lblNota3.setText("" + valorSlider);
        }
    }//GEN-LAST:event_sld3StateChanged

    private void sld4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sld4StateChanged
        JSlider source = (JSlider) evt.getSource();
        lblNota4.setText("" + source.getMaximum());
        if (!source.getValueIsAdjusting()) {
            int valorSlider = source.getValue();
            lblNota4.setText("" + valorSlider);
        }
    }//GEN-LAST:event_sld4StateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        PanelDetallesCurso pDC = new PanelDetallesCurso();
        mostrarTipo(pDC);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSimuladorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimuladorActionPerformed
        // TODO add your handling code here:
        PromedioSimulado();
        PromedioActual();
        CargarLabelNota();
    }//GEN-LAST:event_btnSimuladorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimulador;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblCodigoA;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreN1;
    private javax.swing.JLabel lblNombreN2;
    private javax.swing.JLabel lblNombreN3;
    private javax.swing.JLabel lblNombreN4;
    private javax.swing.JLabel lblNota1;
    private javax.swing.JLabel lblNota2;
    private javax.swing.JLabel lblNota3;
    private javax.swing.JLabel lblNota4;
    private javax.swing.JLabel lblNotaEsperada;
    private javax.swing.JLabel lblPorc1;
    private javax.swing.JLabel lblPorc2;
    private javax.swing.JLabel lblPorc3;
    private javax.swing.JLabel lblPorc4;
    private javax.swing.JLabel lblPromAct;
    private javax.swing.JLabel lblPromSim;
    private javax.swing.JPanel pnlSimulador;
    private javax.swing.JSlider sld1;
    private javax.swing.JSlider sld2;
    private javax.swing.JSlider sld3;
    private javax.swing.JSlider sld4;
    // End of variables declaration//GEN-END:variables
}
