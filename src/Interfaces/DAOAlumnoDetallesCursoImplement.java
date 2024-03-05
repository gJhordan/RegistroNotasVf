/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import CONECT.Conexion;
import Informacion.AlumnoDetallesCurso;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class DAOAlumnoDetallesCursoImplement implements DAOAlumnoDetallesCurso {

    @Override
    public void CargarPeriodosxAlumno(AlumnoDetallesCurso ADC, JComboBox Cmb) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        try {
            //System.out.println("en el ciclos"+nombreCarrera);
            ps = (PreparedStatement) con.prepareStatement("SELECT DISTINCT p.periodo_id, p.nombre_periodo FROM periodos p INNER JOIN secciones s ON p.periodo_id = s.periodo_id INNER JOIN seccionxalumno sa ON s.seccion_id = sa.seccion_id WHERE s.id_estado_seccion = 1 AND sa.alumno_id = ? AND sa.id_estado_seccionxalumno = 3;");
            ps.setInt(1, ADC.getAlumnoID());
            rs = ps.executeQuery();

            while (rs.next()) {
                Cmb.addItem(rs.getString(2));
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
    }

    @Override
    public void CargarSeccionesxAlumno(AlumnoDetallesCurso ADC, JTable tabla) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT periodo_id FROM Periodos WHERE nombre_periodo = ?;");
            ps.setString(1, ADC.getNomPeriodo());
            rs = ps.executeQuery();

            while (rs.next()) {
                ADC.setPeriodoID(rs.getInt(1));
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setRowCount(0);

        int columnas, b = 0;
        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        ResultSet rs1;
        ResultSetMetaData rsmd1;
        try {
            ps1 = (PreparedStatement) con1.prepareStatement("SELECT c.nombre_curso, s.seccion_id, CONCAT(d.nombre, ' ', d.ApellidoP, ' ', d.ApellidoM) AS nombre_docente FROM cursos c INNER JOIN secciones s ON c.curso_id = s.curso_id INNER JOIN docentes d ON s.docente_id = d.docente_id INNER JOIN seccionxalumno sa ON s.seccion_id = sa.seccion_id WHERE sa.alumno_id = ? AND sa.id_estado_seccionxalumno = 3 AND s.periodo_id = ?;");
            ps1.setInt(1, ADC.getAlumnoID());
            ps1.setInt(2, ADC.getPeriodoID());
            rs1 = ps1.executeQuery();
            rsmd1 = rs1.getMetaData();
            columnas = rsmd1.getColumnCount();

            while (rs1.next()) {
                Object[] fila = new Object[columnas];
                for (int indice = 0; indice < columnas; indice++) {
                    fila[indice] = rs1.getObject(indice + 1);
                }
                modeloTabla.addRow(fila);
                b++;
            }
            ADC.setNroCursos(b);
            con1.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
    }

    @Override
    public void CargarNotasxSeccion(AlumnoDetallesCurso ADC) {

        Connection con3 = Conexion.conect();
        PreparedStatement ps3;
        ResultSet rs3;
        try {
            int Valor = 0;
            ps3 = (PreparedStatement) con3.prepareStatement("SELECT nombrenotas, porcnotas FROM formatonotas WHERE IDNotas = ? ORDER BY NroNota;");
            ps3.setInt(1, ADC.getNroseccionAl());
            rs3 = ps3.executeQuery();
            while (rs3.next()) {
                ADC.setNotasNombres((Valor), rs3.getString(1));
                ADC.setNotasPorcentajes((Valor), rs3.getInt(2));
                Valor++;
            }

            con3.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }

        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        ResultSet rs1;
        try {
            ps1 = (PreparedStatement) con1.prepareStatement("SELECT NroNota, nota FROM seccionxalumnoxnotas WHERE seccion_id = ? AND alumno_id = ?;");
            ps1.setInt(1, ADC.getNroseccionAl());
            ps1.setInt(2, ADC.getAlumnoID());
            rs1 = ps1.executeQuery();
            int a = 0;
            while (rs1.next()) {
                ADC.setNotas((rs1.getInt(1) - 1), rs1.getDouble(2));
                a++;
            }
            ADC.setNroNotasRegistradas(a);
            if (a != 4) {
                for (int i = a; i < 4; i++) {
                    ADC.setNotas(i, 99);
                }
            }

            con1.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
        Connection con2 = Conexion.conect();
        PreparedStatement ps2;
        ResultSet rs2;
        try {
            ps2 = (PreparedStatement) con2.prepareStatement("SELECT promedio_final FROM seccionxalumno WHERE seccion_id = ? AND alumno_id = ?;");
            ps2.setInt(1, ADC.getNroseccionAl());
            ps2.setInt(2, ADC.getAlumnoID());
            rs2 = ps2.executeQuery();
            while (rs2.next()) {
                if (rs2.getObject(1) != null) {
                    ADC.setPF(rs2.getDouble(1));
                } else {
                    ADC.setPF(99);
                }

            }
            con2.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
    }

    @Override
    public void GuardarPromedios(AlumnoDetallesCurso ADC) {
        Connection con2 = Conexion.conect();
        PreparedStatement ps2;
        ResultSet rs2;
        try {
            double ponderado = 0, pf = 0;
            double val = 0;
            ps2 = (PreparedStatement) con2.prepareStatement("SELECT sa.promedio_final FROM seccionxalumno sa JOIN secciones s ON sa.seccion_id = s.seccion_id WHERE sa.alumno_id = ? AND s.periodo_id = ? AND sa.id_estado_seccionxalumno = 3;");
            ps2.setInt(1, ADC.getAlumnoID());
            ps2.setInt(2, ADC.getPeriodoID());
            rs2 = ps2.executeQuery();
            while (rs2.next()) {
                System.out.println(ponderado);
                if (rs2.getObject(1) != null) {
                    ponderado = ponderado + rs2.getDouble(1);
                    System.out.println(ponderado);
                    val++;
                }
            }
            System.out.println(ponderado);
            if (val == ADC.getNroCursos()) {
                pf = ponderado / val;

                ADC.setPonderado(pf);
            }
            con2.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }

    }

}
