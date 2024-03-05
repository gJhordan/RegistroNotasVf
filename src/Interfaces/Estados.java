/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import CONECT.Conexion;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Informacion.ValoresEstaticos;
import Informacion.EstadoPeriodos;
import Informacion.Secciones;

/**
 *
 * @author Administrador
 */
public class Estados {


    Secciones Secca = ValoresEstaticos.VES;
    EstadoPeriodos VEPST = ValoresEstaticos.VEPST;

    public void CambiarPeriodo(String nombre, String estado) {
            Connection con = Conexion.conect();
    PreparedStatement ps;
    ResultSet rs;
        try {
            ps = (PreparedStatement) con.prepareStatement("UPDATE `periodos` SET `estado` = ? WHERE `nombre_periodo` = ? ;");
            ps.setString(1, estado);
            ps.setString(2, nombre);
            ps.executeUpdate();
            if (estado.equals("Matricula Abierta")) {
                ps = (PreparedStatement) con.prepareStatement("UPDATE `periodos` SET `ValidadorMtrcl` = '" + 1 + "' WHERE `nombre_periodo` = ? ;");
                ps.setString(1, nombre);
                ps.executeUpdate();
            }
            ps = (PreparedStatement) con.prepareStatement("UPDATE `periodos` SET `estado` = 'Cerrado' WHERE `estado` <> 'Finalizado' AND `nombre_periodo` <> ? ;");
            ps.setString(1, nombre);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }

    }

    public void DefinirPeriodo() {
            Connection con = Conexion.conect();
    PreparedStatement ps;
    ResultSet rs;
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT `periodo_id`,`nombre_periodo`, `estado` FROM `periodos` WHERE `estado` <> 'Finalizado' LIMIT 1;");

            rs = ps.executeQuery();
            while (rs.next()) {

                VEPST.setIdp(rs.getInt(1));
                VEPST.setNombrep(rs.getString(2));
                VEPST.setEstadop(rs.getString(3));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }

    }

    public int LlamarPeriodosRegistrables() {
            Connection con = Conexion.conect();
    PreparedStatement ps;
    ResultSet rs;
        int respuesta;
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT `periodo_id` FROM `periodos` WHERE `estado` = 'Prematricula' OR `estado` = 'Matricula Abierta';");
            rs = ps.executeQuery();
            rs.next();
            respuesta = rs.getRow();
            con.close();

        } catch (SQLException e) {
            respuesta = -1;
            System.out.println("ERRORSQL: " + e);
        }
        return respuesta;
    }

    public String LlamarNamePeriodosRegistrables() {
            Connection con = Conexion.conect();
    PreparedStatement ps;
    ResultSet rs;
        String respuesta;
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT `periodo_id`, `nombre_periodo` FROM `periodos` WHERE `estado` = 'Prematricula' OR `estado` = 'Matricula Abierta';");
            rs = ps.executeQuery();
            rs.next();
            Secca.setPeriodoSeccionIP(rs.getInt(1));
            respuesta = rs.getString(2);
            con.close();

        } catch (SQLException e) {
            respuesta = null;
            System.out.println("ERRORSQL: " + e);
        }
        return respuesta;
    }

    public int ValidarMatricula() {
            Connection con = Conexion.conect();
    PreparedStatement ps;
    ResultSet rs;
        int respuesta;
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT `periodo_id` FROM `periodos` WHERE `ValidadorMtrcl` = '1' AND periodo_id = ?;");
            ps.setInt(1, VEPST.getIdp());

            rs = ps.executeQuery();
            rs.next();
            respuesta = rs.getRow();
            con.close();

        } catch (SQLException e) {
            respuesta = -1;
            System.out.println("ERRORSQL: " + e);
        }
        return respuesta;
    }

    public void SeccionesxNotasTipoParticipacion() {

        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        try {
            ps1 = (PreparedStatement) con1.prepareStatement("INSERT INTO auxiliarnotapart (alumno_id, NroNota, IDNotas, nroparticipaciones, estadonota) SELECT sa.alumno_id, fn.NroNota, fn.IDNotas, 0 AS nroparticipaciones, '1' AS estadonota FROM seccionxalumno sa JOIN secciones s ON sa.seccion_id = s.seccion_id JOIN formatonotas fn ON s.IDNotas = fn.IDNotas WHERE s.periodo_id = ? AND sa.id_estado_seccionxalumno = 3 AND fn.TipoNota = 'Participacion';");
            ps1.setInt(1, VEPST.getIdp());
            ps1.executeUpdate();
            con1.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }
    }

    public void actualizarCiclo() {
        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        try {
            ps1 = (PreparedStatement) con1.prepareStatement("UPDATE alumnos AS a INNER JOIN (SELECT sa.alumno_id FROM seccionxalumno AS sa INNER JOIN secciones AS sec ON sa.seccion_id = sec.seccion_id WHERE sec.periodo_id = ? GROUP BY sa.alumno_id HAVING SUM(CASE WHEN sa.promedio_final > 11.6 THEN 1 ELSE 0 END) = COUNT(*)) AS subquery ON a.alumno_id = subquery.alumno_id SET a.ciclo = a.ciclo + 1;");
            ps1.setInt(1, VEPST.getIdp());
            ps1.executeUpdate();
             con1.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }
    }

    public void actualizarBecas() {
        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        try {
            ps1 = (PreparedStatement) con1.prepareStatement("UPDATE alumnos AS a INNER JOIN (SELECT sa.alumno_id,CAST(SUM(sa.promedio_final) / COUNT(DISTINCT sa.seccion_id) AS DECIMAL(10, 2)) AS promedio_alumno FROM seccionxalumno AS sa INNER JOIN secciones AS sec ON sa.seccion_id = sec.seccion_id WHERE sec.periodo_id = ? GROUP BY sa.alumno_id) AS subquery ON a.alumno_id = subquery.alumno_id SET a.valBeca = CASE WHEN subquery.promedio_alumno >= 16 THEN 1 ELSE 2 END;");
            ps1.setInt(1, VEPST.getIdp());
            ps1.executeUpdate();
             con1.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }
    }

    public void actualizarPagos() {
        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        try {
            ps1 = (PreparedStatement) con1.prepareStatement("UPDATE alumnos SET estadoPago = 'Pendiente';");
            ps1.executeUpdate();
             con1.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }
    }

    public void actualizarSecciones() {
        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        try {
            ps1 = (PreparedStatement) con1.prepareStatement("UPDATE secciones SET id_estado_seccion = 2 WHERE periodo_id = ? AND id_estado_seccion <> 3");
            ps1.setInt(1, VEPST.getIdp());
            ps1.executeUpdate();
             con1.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }

    }
}
