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
import javax.swing.JComboBox;

/**
 *
 * @author ACER
 */
public class Carreras {

    public void RellenarCmbcarrera(JComboBox combo) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT nombre_carrera from Carreras;");
            rs = ps.executeQuery();
            while (rs.next()) {
                combo.addItem(rs.getString(1));
                // System.out.println("En el carreras: "+rs.getString(1));
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }

    }
    public int DefinirCodigoCarrera(String nombre){
         Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        int id=-1;
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT codigo_carrera from Carreras where nombre_carrera = ?;");
               ps.setString(1, nombre);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
        return id;
    }
    public void RellenarCiclo(JComboBox combo, int idCarrera) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        int ciclos = 0;
        System.out.println(idCarrera);
        try {
            //System.out.println("en el ciclos"+nombreCarrera);
            ps = (PreparedStatement) con.prepareStatement("SELECT cantidad_ciclos from Carreras where codigo_carrera = ? ;");
            ps.setInt(1, idCarrera);
            rs = ps.executeQuery();

            while (rs.next()) {
                ciclos = rs.getInt(1);
            }
            for (int i = 1; i <= ciclos; i++) {
                //  System.out.println(ciclos);
                combo.addItem(i);
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
    }
}
