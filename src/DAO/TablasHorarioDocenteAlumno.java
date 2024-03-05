/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CONECT.Conexion;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import Informacion.Usuario;
import Informacion.EstadoPeriodos;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class TablasHorarioDocenteAlumno {

   //declara variable ResultSetMetaData
    int columnas;

public DefaultTableModel cargarTabla(JTable tabla, String nombretabla, String nombrecondicional, Usuario usuario,EstadoPeriodos estPe) {
      Connection con = Conexion.conect();
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setRowCount(0);

        try {
            // Asumiendo que `docente_id` está en la tabla `secciones` y `CodigoUsu` en la tabla `docentes`.
            String consulta = "SELECT s.seccion_id, c.nombre_curso, h.dia_semana, h.turno,p.nombre_periodo "
                    + "FROM secciones s "
                    + "JOIN cursos c ON s.curso_id = c.curso_id "
                    + "JOIN horarios h ON s.id_horario = h.id_horario "
                    + "JOIN Docentes d ON s.docente_id = d.docente_id "
                    + "JOIN periodos p ON s.periodo_id = p.periodo_id " 
                    + "JOIN Usuarios u ON d.CodigoUsu = ? "
                    + "WHERE u.CodigoUsu = ? AND p.nombre_periodo = ?";

            ps = (PreparedStatement) con.prepareStatement(consulta);
            ps.setString(1, usuario.getCodigoUsu());
            ps.setString(2, usuario.getCodigoUsu());
            ps.setString(3, estPe.getNombrep());

            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int indice = 0; indice < columnas; indice++) {
                    fila[indice] = rs.getObject(indice + 1);
                }
                modeloTabla.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e);
        }
        return modeloTabla;
    }
public DefaultTableModel cargarTablaAlumno(JTable tabla, String nombretabla, String nombrecondicional, Usuario usuario, EstadoPeriodos estPe) {
    Connection con = Conexion.conect();
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setRowCount(0);

    try {
        String consulta = "SELECT s.seccion_id, c.nombre_curso, h.dia_semana, h.turno,p.nombre_periodo " +
            "FROM usuarios u " +
            "JOIN alumnos a ON u.CodigoUsu = a.CodigoUsu " +
            "JOIN seccionxalumno sa ON a.alumno_id = sa.alumno_id " +
            "JOIN secciones s ON sa.seccion_id = s.seccion_id " +
            "JOIN horarios h ON s.id_horario = h.id_horario " +
            "JOIN periodos p ON s.periodo_id = p.periodo_id " +
            "JOIN cursos c ON s.curso_id = c.curso_id "+
            "WHERE u.CodigoUsu = ? AND p.nombre_periodo = ?"+
            "AND sa.id_estado_seccionxalumno = 3";
        
        ps = (PreparedStatement) con.prepareStatement(consulta);
        ps.setString(1, usuario.getCodigoUsu());
        ps.setString(2, estPe.getNombrep());

        rs = ps.executeQuery();
        rsmd = rs.getMetaData();
        columnas = rsmd.getColumnCount();

        while (rs.next()) {
            Object[] fila = new Object[columnas];
            for (int indice = 0; indice < columnas; indice++) {
                fila[indice] = rs.getObject(indice + 1);
            }
            modeloTabla.addRow(fila);
        }
        con.close();
    } catch (SQLException e) {
        System.out.println("ERROR SQL: " + e);
    }
        return modeloTabla;
}
}
