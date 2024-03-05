/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import CONECT.Conexion;
import Informacion.Secciones;
import Informacion.Usuario;
import Informacion.ValoresEstaticos;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Luis
 */
public class SolRetiroCurso {

    Usuario Usua = ValoresEstaticos.Usu;
    Secciones Secca = ValoresEstaticos.VES;

    public void RellenarCursos(JComboBox cursosCombo) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        try {
            System.out.println(Usua.getID());
            ps = (PreparedStatement) con.prepareStatement("SELECT DISTINCT c.nombre_curso "
                    + "FROM seccionxalumno sa "
                    + "INNER JOIN secciones s ON sa.seccion_id = s.seccion_id "
                    + "INNER JOIN cursos c ON s.curso_id = c.curso_id "
                    + "WHERE sa.alumno_id = ?");
            ps.setInt(1, Usua.getID());
            rs = ps.executeQuery();
            while (rs.next()) {
                cursosCombo.addItem(rs.getString(1));
                // System.out.println("En el carreras: "+rs.getString(1));
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
    }

    public void RellenarSeccion(JTextField seccionesTextField, String selectedCurso) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        try {
            StringBuilder secciones = new StringBuilder();
            String query = "SELECT s.seccion_id "
                    + "FROM secciones s "
                    + "JOIN cursos c ON s.curso_id = c.curso_id "
                    + "JOIN seccionxalumno sa ON s.seccion_id = sa.seccion_id "
                    + "WHERE c.nombre_curso = ? AND sa.alumno_id = ?";

            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setString(1, selectedCurso);
            ps.setInt(2, Usua.getID());
            rs = ps.executeQuery();

            while (rs.next()) {
                secciones.append(rs.getString("seccion_id")).append("");
            }

            seccionesTextField.setText(secciones.toString());

            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }
    }

    public int EstadoSolicitud(Secciones seccion) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT seccion_id, estado_sol FROM solretiroalumno WHERE seccion_id = ?;");
            ps.setInt(1, seccion.getSeccionID());
            rs = ps.executeQuery();

            if (rs.next()) {
                // Se encontró un registro con la misma sección en la base de datos
                String estado = rs.getString("estado_sol");
                if (estado.equals("Finalizado")) {
                    // El estado es "Finalizado", por lo que puedes registrar los datos
                    con.close();
                    return 1;
                } else {
                    // El estado no es "Finalizado", no debes registrar los datos
                    con.close();
                    return 0;
                }
            } else {
                con.close();
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
            return -1;
        }

    }
}
