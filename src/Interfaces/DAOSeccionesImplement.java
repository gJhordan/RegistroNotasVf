package Interfaces;

import CONECT.Conexion;

import Informacion.Horario;
import Informacion.Secciones;
import Informacion.ValoresEstaticos;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class DAOSeccionesImplement implements DAOSecciones {

    Secciones Secca = ValoresEstaticos.VES;

    @Override
    public void registrarSeccion(Secciones seccion, Horario horarios) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        try {
            System.out.println(Secca.getSeccionID());
            int iddocente = obetenerIDs(seccion, "docentes", "docente_id", "CodigoUsu", Secca.getCodigoDocenteSeccion());
            int idcurso = obetenerIDs(seccion, "cursos", "curso_id", "nombre_curso", Secca.getNombreSeccion());

            ps = (PreparedStatement) con.prepareStatement("INSERT INTO secciones (seccion_id, periodo_id, docente_id, id_horario, curso_id, IDNotas) VALUES (" + Secca.getSeccionID() + ", " + Secca.getPeriodoSeccionIP() + ", " + iddocente + ", " + Secca.getSeccionID() + ", " + idcurso + ", " + Secca.getSeccionID() + ");");
            //System.out.println("antesdejecutar final c: " + idcurso);
            //System.out.println("antesdejecutar final d: " + iddocente);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Nuevo Curso Registrado en el periodo " + Secca.getPeriodoSeccion());
            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORFINAL");
            System.out.println("ERRORSQL: " + e);
        }
    }

    @Override
    public int comparar(Secciones seccion) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        int ComparacionR;
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT seccion_id from secciones where seccion_id = ? ;");
            ps.setInt(1, seccion.getSeccionID());
            rs = ps.executeQuery();
            rs.next();
            ComparacionR = rs.getRow();
            con.close();
            return ComparacionR;
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
            return 9;
        }
    }

    @Override
    public void cargar(Secciones seccion, JComboBox cmb) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT nombre_curso from cursos where ciclo_curso = ?;");
            ps.setInt(1, seccion.getCicloSeccion());
            rs = ps.executeQuery();
            while (rs.next()) {
                cmb.addItem(rs.getString(1));

            }

            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
    }

    @Override
    public int obtenerSesiones(Secciones seccion) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        int valor = 0;
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT sesiones from cursos where nombre_curso = ?;");
            ps.setString(1, Secca.getNombreSeccion());
            rs = ps.executeQuery();
            rs.next();
            valor = rs.getInt(1);

            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }
        return valor;
    }

    @Override
    public void registrarFormatNotas(Secciones seccion, int valorlista) {

        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        ResultSet rs1;
        try {
            System.out.println(Secca.getNotasTip(valorlista));
            ps1 = (PreparedStatement) con1.prepareStatement("INSERT INTO FormatoNotas (NroNota, IDNotas, nombrenotas, TipoNota, porcnotas) VALUES (?, ?, ?, ?, ?); ");
            ps1.setInt(1, (valorlista + 1));
            ps1.setInt(2, Secca.getSeccionID());
            ps1.setString(3, Secca.getNotasNombres()[valorlista]);
            ps1.setString(4, Secca.getNotasTip(valorlista));
            ps1.setInt(5, Secca.getNotasPorcentajes()[valorlista]);
            ps1.executeUpdate();
            con1.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }
    }

    @Override
    public int obetenerIDs(Secciones seccion, String tablasql, String valorSql, String condicionalsql, String igualar) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        int valor = 0;
        //System.out.println("igualar: " + igualar);
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT " + valorSql + "  from " + tablasql + " where " + condicionalsql + " = ? ;");
            ps.setString(1, igualar);
            rs = ps.executeQuery();
            rs.next();
            valor = rs.getInt(1);
            //System.out.println("valor id:" + valor);
            con.close();
        } catch (SQLException e) {
            System.out.println("ERROR IDS");
            System.out.println("ERRORSQL: " + e);
        }
        return valor;
    }

}
