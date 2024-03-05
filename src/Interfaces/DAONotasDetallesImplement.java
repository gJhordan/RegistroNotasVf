/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import CONECT.Conexion;
import Informacion.AlumnoParticipacion;
import Informacion.ValoresEstaticos;
import Informacion.NotasDetalles;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class DAONotasDetallesImplement implements DAONotasDetalles {

    AlumnoParticipacion EAP = ValoresEstaticos.VEAP;

    @Override
    public int ObtenerParticipacionxAlumno(NotasDetalles NotasD) {
        int valor = 0;
        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        ResultSet rs1;
        try {

            ps1 = (PreparedStatement) con1.prepareStatement("SELECT alumno_id, nroparticipaciones, COUNT(*) OVER () AS conteo_resultados FROM auxiliarnotapart WHERE NroNota = ? and IDNotas = ?;");
            ps1.setInt(1, NotasD.getNroNota());
            ps1.setInt(2, NotasD.getNroseccionDoc());
            rs1 = ps1.executeQuery();
            while (rs1.next()) {
                if (valor == 0) {
                    EAP.definirCantidadAlumnos(rs1.getInt(3));
                }
                EAP.ingresarDatos(valor, rs1.getInt(2), rs1.getInt(1));
                valor++;
            }
            EAP.calcularNotas();
            con1.close();

            return valor;
        } catch (SQLException e) {

            System.out.println("ERRORSQL: " + e);
            return -1;
        }
    }

    @Override
    public int ObtenerPromediosxAlumno(NotasDetalles NotasD) {
        int valor;
        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        ResultSet rs1;
        try {

            ps1 = (PreparedStatement) con1.prepareStatement("SELECT nota1, nota2, nota3, (CASE WHEN nota1 IS NOT NULL THEN 1 ELSE 0 END + CASE WHEN nota2 IS NOT NULL THEN 1 ELSE 0 END + CASE WHEN nota3 IS NOT NULL THEN 1 ELSE 0 END) AS notas_llenas FROM auxiliarnotaprom WHERE alumno_id = ? AND NroNota = ? AND IDNotas = ?;");
            ps1.setInt(1, NotasD.getAlumnoID());
            ps1.setInt(2, NotasD.getNroNota());
            ps1.setInt(3, NotasD.getNroseccionDoc());
            rs1 = ps1.executeQuery();
            if (rs1.next()) {
                valor = rs1.getInt("notas_llenas");

                switch (valor) {
                    case 3:
                        NotasD.setNotasPromedio(0, rs1.getDouble("nota1"));
                        NotasD.setNotasPromedio(1, rs1.getDouble("nota2"));
                        NotasD.setNotasPromedio(2, rs1.getDouble("nota3"));
                        break;
                    case 2:
                        NotasD.setNotasPromedio(0, rs1.getDouble("nota1"));
                        NotasD.setNotasPromedio(1, rs1.getDouble("nota2"));
                        break;
                    case 1:
                        NotasD.setNotasPromedio(0, rs1.getDouble("nota1"));
                        break;

                    default:
                        break;
                }
                con1.close();
                return valor;
            } else {
                ps1.close();
                return 0;
            }

        } catch (SQLException e) {

            System.out.println("ERRORSQL: " + e);
            return -1;
        }
    }

    @Override
    public void ActualizarParticipacionxAlumno(NotasDetalles NotasD) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement("UPDATE auxiliarnotapart SET nroparticipaciones = ? WHERE alumno_id = ? AND NroNota = ? and IDNotas = ?;");
            ps.setInt(1, NotasD.getNroParticipaciones());
            ps.setInt(2, NotasD.getAlumnoID());
            ps.setInt(3, NotasD.getNroNota());
            ps.setInt(4, NotasD.getNroseccionDoc());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }
    }

    @Override
    public void ActualizarPromediosxAlumno(NotasDetalles NotasD) {
        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        Object nota1 = null, nota2 = null, nota3 = null;

        if (NotasD.getNotasPromedio(0) != 99) {
            nota1 = NotasD.getNotasPromedio(0);
        }
        if (NotasD.getNotasPromedio(1) != 99) {
            nota2 = NotasD.getNotasPromedio(1);
        }
        if (NotasD.getNotasPromedio(2) != 99) {
            nota3 = NotasD.getNotasPromedio(2);
        }

        try {
            ps1 = (PreparedStatement) con1.prepareStatement("INSERT INTO auxiliarnotaprom (alumno_id, NroNota, IDNotas, nota1, nota2, nota3, estadonota) VALUES (?, ?, ?, ?, ?, ?, '1') ON DUPLICATE KEY UPDATE nota1 = VALUES(nota1), nota2 = VALUES(nota2), nota3 = VALUES(nota3), estadonota = VALUES(estadonota);");
            ps1.setInt(1, NotasD.getAlumnoID());
            ps1.setInt(2, NotasD.getNroNota());
            ps1.setInt(3, NotasD.getNroseccionDoc());
            ps1.setObject(4, nota1);
            ps1.setObject(5, nota2);
            ps1.setObject(6, nota3);
            ps1.executeUpdate();

            con1.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
    }

    @Override
    public void SubirNotasFinales(NotasDetalles NotasD) {
        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        try {

            ps1 = (PreparedStatement) con1.prepareStatement("INSERT INTO seccionxalumnoxnotas (seccion_id, alumno_id, NroNota, IDNotas, nota) VALUES (?, ?, ?, ?, ?);");
            ps1.setInt(1, NotasD.getNroseccionDoc());
            ps1.setInt(2, NotasD.getAlumnoID());
            ps1.setInt(3, NotasD.getNroNota());
            ps1.setInt(4, NotasD.getNroseccionDoc());
            ps1.setDouble(5, NotasD.getNotaFinal());
            ps1.executeUpdate();

            con1.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
    }

    @Override
    public int ObtenerUnicaxAlumno(NotasDetalles NotasD) {
        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        ResultSet rs1;
        try {

            ps1 = (PreparedStatement) con1.prepareStatement("SELECT nota1unica FROM auxiliarnotaunic WHERE alumno_id = ? AND NroNota = ? AND IDNotas = ?;");
            ps1.setInt(1, NotasD.getAlumnoID());
            ps1.setInt(2, NotasD.getNroNota());
            ps1.setInt(3, NotasD.getNroseccionDoc());
            rs1 = ps1.executeQuery();
            if (rs1.next()) {
                NotasD.setNotaUnica(rs1.getInt(1));
                con1.close();
                return 0;
            } else {
                con1.close();
                return 0;
            }

        } catch (SQLException e) {

            System.out.println("ERRORSQL: " + e);
            return -1;
        }
    }

    @Override
    public void ActualizarUnicaxAlumno(NotasDetalles NotasD) {
        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        Object nota1 = null;

        if (NotasD.getNotaUnica() != 99) {
            nota1 = NotasD.getNotaUnica();
        }

        try {
            ps1 = (PreparedStatement) con1.prepareStatement("INSERT INTO auxiliarnotaunic (alumno_id, NroNota, IDNotas, nota1unica, estadonota) VALUES (?, ?, ?, ?, '1') ON DUPLICATE KEY UPDATE nota1unica = VALUES(nota1unica), estadonota = VALUES(estadonota);");
            ps1.setInt(1, NotasD.getAlumnoID());
            ps1.setInt(2, NotasD.getNroNota());
            ps1.setInt(3, NotasD.getNroseccionDoc());
            ps1.setObject(4, nota1);
            ps1.executeUpdate();

            con1.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
    }

}
