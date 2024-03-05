/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CONECT.Conexion;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import Informacion.Usuario;
/**
 *
 * @author Luis
 */
public class ActualizarInformacionImplements {
public void actualizarCorreo(String nuevoCorreo, String rol, String codigoUsuario, Usuario usuario) {
    
    Connection con = Conexion.conect();
    PreparedStatement ps;

    
    String tabla = "";
    String columna = "";

    if (rol.equals("Docente")) {
        tabla = "docentes";
        columna = "correo";
    } else if (rol.equals("Alumno")) {
        tabla = "alumnos";
        columna = "correo";
    }

    try {
        ps = (PreparedStatement) con.prepareStatement("UPDATE " + tabla + " SET " + columna + " = ? WHERE codigoUsu = ?");

        ps.setString(1, nuevoCorreo);
        ps.setString(2, usuario.getCodigoUsu());

        ps.executeUpdate();
        con.close();
        } catch (SQLException e) {
        System.out.println("ERRORSQL: " + e);
        }
    }

public void actualizarTelefono(int nuevoTelefono, String rol, String codigoUsuario, Usuario usuario) {
    
        Connection con = Conexion.conect();
        PreparedStatement ps2;

    
    String tabla = "";
    String columna = "";

    if (rol.equals("Docente")) {
        tabla = "docentes";
        columna = "telefono";
    } else if (rol.equals("Alumno")) {
        tabla = "alumnos";
        columna = "telefono";
    }

    try {
        ps2 = (PreparedStatement) con.prepareStatement("UPDATE " + tabla + " SET " + columna + " = ? WHERE codigoUsu = ?");

        ps2.setInt(1, nuevoTelefono);
        ps2.setString(2, usuario.getCodigoUsu());

        ps2.executeUpdate();
        con.close();
        } catch (SQLException e) {
        System.out.println("ERRORSQL: " + e);
        }
    }
}
