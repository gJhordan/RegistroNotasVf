/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import CONECT.Conexion;
import Informacion.SolDocentes;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class DAOSolicitudesImplement implements DAOSolicitudes {

    @Override
    public void cambiarEstadoSolicitudDocente(SolDocentes SolDoc) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = (PreparedStatement) con.prepareStatement("UPDATE solcambiodocente SET estado_sol  = ? WHERE Id_SolDocente = ? ");
            ps.setString(1, SolDoc.getEstado());
            ps.setInt(2, SolDoc.getIDSol());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }
    }

    @Override
    public void ActualizarDocente(SolDocentes SolDoc) {

        Connection con2 = Conexion.conect();
        PreparedStatement ps2;
        ResultSet rs2;
        try {
            ps2 = (PreparedStatement) con2.prepareStatement("UPDATE secciones SET docente_id = ? WHERE seccion_id = ? ; ;");
            ps2.setInt(1, SolDoc.getIDDoc());
            ps2.setInt(2, SolDoc.getNroSeccion());
            ps2.executeUpdate();
            con2.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }

    }

    @Override
    public void ObtenerInfoCurso(SolDocentes SolDoc) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT nombre_curso FROM cursos INNER JOIN secciones ON cursos.curso_id = secciones.curso_id  Where secciones.seccion_id = ? ;");
            ps.setInt(1, SolDoc.getNroSeccion());
            rs = ps.executeQuery();
            rs.next();
            SolDoc.setNombreCurso(rs.getString(1));
            con.close();

        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }
    }

    @Override
    public void ObtenerInfoDocente(SolDocentes SolDoc) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        try {
            //     System.out.println(docente.getCodigoUsu());
            ps = (PreparedStatement) con.prepareStatement("SELECT `nombre`,`ApellidoP`, `ApellidoM`, `Profesión`, `docente_id` FROM `docentes` WHERE `CodigoUsu` = ? ;");
            ps.setString(1, SolDoc.getCodDocenteNuevo());
            rs = ps.executeQuery();
            rs.next();
            SolDoc.setNmcDocenteNuevo(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            SolDoc.setEspecializacionDocNuevo(rs.getString(4));
            SolDoc.setIDDoc(rs.getInt(5));
            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }
    }

    @Override
    public int ObtenerDocentesDisponibles(SolDocentes SolDoc, JComboBox Combo) {
        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        ResultSet rs1;
        try {
            ps1 = (PreparedStatement) con1.prepareStatement("SELECT DISTINCT d.CodigoUsu FROM docentes d LEFT JOIN secciones s ON d.docente_id = s.docente_id LEFT JOIN horarios h ON s.id_horario = h.id_horario WHERE d.docente_id NOT IN (    SELECT s.docente_id   FROM secciones s  JOIN horarios h ON s.id_horario = h.id_horario WHERE (h.dia_semana = ? AND h.turno = ?) OR (h.dia_semana = ? AND h.turno = ?)) OR s.docente_id IS NULL;");
            ps1.setString(1, SolDoc.getDiasemanaEsp(0));
            ps1.setString(2, SolDoc.getTurnoEsp(0));
            ps1.setString(3, SolDoc.getDiasemanaEsp(1));
            ps1.setString(4, SolDoc.getTurnoEsp(1));

            rs1 = ps1.executeQuery();
            // System.out.println("paso el 2da select");
            while (rs1.next()) {
                //   System.out.println("En el carreras: " + rs1.getString(1));
                Combo.addItem(rs1.getString(1));

            }
            // System.out.println("paso el combo");
            int i = Combo.getItemCount();
            if (i == 0) {
                JOptionPane.showMessageDialog(null, "No existen docentes disponibles en el horario del curso");
            }
            //   System.out.println("paso el if igual 0");
            con1.close();
            // System.out.println("paso el close");
            return i;
        } catch (SQLException e) {
            //System.out.println("b");
            System.out.println("ERRORSQL: " + e);
            return -1;
        }
    }

    @Override
    public void getHorarios(SolDocentes SolDoc) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        int num = 0;
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT dia_semana, turno FROM horarios  WHERE id_horario = ? ;");
            ps.setInt(1, SolDoc.getNroSeccion());
            rs = ps.executeQuery();
            while (rs.next()) {
                SolDoc.setDiasemanaEsp(num, rs.getString(1));
                SolDoc.setTurnoEsp(num, rs.getString(2));
                num++;
            }
            if (num == 1) {
                SolDoc.setDiasemanaEsp(1, "nada");
                SolDoc.setTurnoEsp(1, "nada");
            }
            con.close();
        } catch (SQLException e) {

            System.out.println("ERRORSQL: " + e);

        }
    }

}
