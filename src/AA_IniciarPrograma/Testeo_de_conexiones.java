/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package AA_IniciarPrograma;

import CONECT.Conexion;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class Testeo_de_conexiones {

    public static void main(String[] args) {
        for (int i = 0; i < 5000; i++) {
            rapido();
            System.out.println(i);
        }
    }

    public static void rapido() {
        int ComparacionR = 0;
        java.sql.Connection con = Conexion.conect();

        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT CodigoUsu from usuarios where CodigoUsu = ? AND ClaveUsu = ?;");
            ps.setString(1, "a");
            ps.setString(2, "a");
            rs = ps.executeQuery();
            rs.next();
            ComparacionR = rs.getRow();

            con.close();

        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }

    }

}
