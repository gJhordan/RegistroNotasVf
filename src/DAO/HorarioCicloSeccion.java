/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CONECT.Conexion;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class HorarioCicloSeccion {

    public String CargarHorario(int NroSeccion, String ConcaHorario) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        int nrosession;
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT CONCAT(h1.dia_semana, '-', h1.turno) AS sesion1, CONCAT(h2.dia_semana, '-', h2.turno) AS sesion2, CASE WHEN h2.id_horario IS NOT NULL THEN 2 ELSE 1 END AS cantidad_sesiones FROM horarios h1 LEFT JOIN horarios h2 ON h1.id_horario = h2.id_horario AND h2.nrosesion = 2 WHERE h1.id_horario = ? AND h1.nrosesion = 1;");
            ps.setInt(1, NroSeccion);
            rs = ps.executeQuery();

            while (rs.next()) {
                nrosession = rs.getInt("cantidad_sesiones");
                if (nrosession == 1) {
                    ConcaHorario = rs.getString("sesion1");
                } else {
                    ConcaHorario = rs.getString("sesion1") + " y " + rs.getString("sesion2");
                }

            }
            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }
        return ConcaHorario;
    }

    public int CargarCiclo(String CursoNombre) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        int ciclo = 0;
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT ciclo_curso FROM cursos WHERE nombre_curso = ?;");
            ps.setString(1, CursoNombre);
            rs = ps.executeQuery();

            while (rs.next()) {
                ciclo = rs.getInt(1);

            }
            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL NO CARGO CICLO: " + e);
            ciclo = 99;
        }
        return ciclo;
    }
}
