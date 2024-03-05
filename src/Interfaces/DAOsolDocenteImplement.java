package Interfaces;


import CONECT.Conexion;
import Informacion.EnviarSolicitudDocente;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class DAOsolDocenteImplement implements DAOsolDocente {

 
    
    
    @Override
    public void registrar(EnviarSolicitudDocente soldocente) {
           Connection con = Conexion.conect();
    PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO solcambiodocente (seccion_id, CodigoUsu, motivo_sol, estado_sol) VALUES (?, ?, ?, ?);");

            ps.setString(1, soldocente.getSeccion());
            ps.setString(2, soldocente.getCodDocente());
            ps.setString(3, soldocente.getMotivo());
            ps.setString(4, "Pendiente");
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Solicitud registrada Correctamente " );
            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }
    }
}
    