/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import CONECT.Conexion;
import Informacion.SolAlumnos;
import Informacion.SolicitudesInfo;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Luis
 */
public class DAOSsolicitudRetiroAlumnoImplement {

    public void cambiarEstadoSolicitudAlumno(SolicitudesInfo SolReAlum) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement("UPDATE solretiroalumno SET estado_sol  = ? WHERE idSolAlumno = ? ");
            ps.setString(1, SolReAlum.getEstado());
            ps.setInt(2, SolReAlum.getIDSol());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }
    }

    public void cambiarEstadoCuentaAlumno(SolAlumnos SolActAlum) {
        Connection con = Conexion.conect();

        try {
            String consultaAlumnoId = "SELECT alumno_id FROM alumnos WHERE CodigoUsu = ?";
            String consultaEstadoSeccion = "SELECT id_estado_seccionxalumno FROM seccionxalumno WHERE alumno_id = ? AND seccion_id = ?";
            String updateEstado = "UPDATE seccionxalumno SET id_estado_seccionxalumno = 2 WHERE alumno_id = ? AND seccion_id = ?";

            PreparedStatement psAlumno = (PreparedStatement) con.prepareStatement(consultaAlumnoId);
            psAlumno.setString(1, SolActAlum.getCodigoUsuAlum());
            ResultSet rsAlumno = psAlumno.executeQuery();

            if (rsAlumno.next()) {
                int alumnoId = rsAlumno.getInt("alumno_id");

                PreparedStatement psEstadoSeccion = (PreparedStatement) con.prepareStatement(consultaEstadoSeccion);
                psEstadoSeccion.setInt(1, alumnoId);
                psEstadoSeccion.setInt(2, SolActAlum.getNroSeccion());
                ResultSet rsEstadoSeccion = psEstadoSeccion.executeQuery();

                if (rsEstadoSeccion.next()) {
                    PreparedStatement psUpdateEstado = (PreparedStatement) con.prepareStatement(updateEstado);
                    psUpdateEstado.setInt(1, alumnoId);
                    psUpdateEstado.setInt(2, SolActAlum.getNroSeccion());
                    psUpdateEstado.executeUpdate();
                    psUpdateEstado.close();
                }
                con.close();
            }
            psAlumno.close();
        } catch (SQLException e) {
            // Manejo de errores
              System.out.println("ERRORSQL: " + e);
        }
    }
}
