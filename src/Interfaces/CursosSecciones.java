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

public class CursosSecciones {

    Usuario Usua = ValoresEstaticos.Usu;
    Secciones Secca = ValoresEstaticos.VES;

    public void RellenarCursos(JComboBox cursosCombo) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        try {
            System.out.println(Usua.getID());
            ps = (PreparedStatement) con.prepareStatement("SELECT distinct nombre_curso FROM cursos INNER JOIN secciones ON cursos.curso_id = secciones.curso_id  Where docente_id = ?;");
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

    public void RellenarSeccion(JComboBox seccionesCombo, String selectedCurso) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = (PreparedStatement) con.prepareStatement("select seccion_id from secciones INNER JOIN cursos ON cursos.curso_id = secciones.curso_id where cursos.nombre_curso = ? and secciones.docente_id=?;");
            ps.setString(1, selectedCurso);
            ps.setInt(2, Usua.getID());
            rs = ps.executeQuery();
            while (rs.next()) {
                seccionesCombo.addItem(rs.getString(1));
            }
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
            ps = (PreparedStatement) con.prepareStatement("SELECT seccion_id, estado_sol FROM solcambiodocente WHERE seccion_id = ?;");
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
