/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Informacion.Usuario;
import CONECT.Conexion;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author ACER
 */
public class DAOLoginImplements implements DAOLogin {


    PreparedStatement ps;
    ResultSet rs;

    @Override
    public int intentarlogin(Usuario usuario) {
        
    java.sql.Connection con = Conexion.conect();
        int ComparacionR;
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT CodigoUsu from usuarios where CodigoUsu = ? AND ClaveUsu = ?;");
            ps.setString(1, usuario.getCodigoUsu());
            ps.setString(2, usuario.getClave());
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
    public void sumarintentos(Usuario usuario) {
        
    java.sql.Connection con = Conexion.conect();
        try {
            int intentos = 0;
            ps = (PreparedStatement) con.prepareStatement("SELECT IntentosUsu from usuarios where CodigoUsu = ? ;");
            ps.setString(1, usuario.getCodigoUsu());

            rs = ps.executeQuery();
            while (rs.next()) {
                intentos = rs.getInt(1);
            }

            ps = (PreparedStatement) con.prepareStatement("UPDATE usuarios SET IntentosUsu = ? where CodigoUsu = ? ;");
            ps.setInt(1, (intentos + 1));
            ps.setString(2, usuario.getCodigoUsu());

            ps.executeUpdate();
            con.close();

        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }
    }

    public int comprobarintentos(Usuario usuario) {
        
    java.sql.Connection con = Conexion.conect();
        int intentos = 0;
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT IntentosUsu from usuarios where CodigoUsu = ? ;");
            ps.setString(1, usuario.getCodigoUsu());
            rs = ps.executeQuery();
            rs = ps.executeQuery();
            while (rs.next()) {
                intentos = rs.getInt(1);
            }
            con.close();
            return intentos;
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
            return 9;
        }
    }

    public int compararusuario(Usuario usuario) {
        
    java.sql.Connection con = Conexion.conect();
        int ComparacionR;
        try {
            ps =  (PreparedStatement) con.prepareStatement("SELECT CodigoUsu from usuarios where CodigoUsu = ? ;");
            ps.setString(1, usuario.getCodigoUsu());
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
}
