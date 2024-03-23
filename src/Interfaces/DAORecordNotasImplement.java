package Interfaces;


import CONECT.Conexion;
import Informacion.Usuario;
import Informacion.ValoresEstaticos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAORecordNotasImplement implements DAORecordNotas {
    Usuario Usua = ValoresEstaticos.Usu;

    @Override
    public void CargarRecordNotas(JTable tabla) {
        Connection con = Conexion.conect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd1;
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setRowCount(0);
        int columnas;
        
        
        try {
            ps = con.prepareStatement("SELECT c.curso_id, c.nombre_curso, c.ciclo_curso, rn.VecesCursado, rn.estado " +
                    "FROM cursos c " +
                    "JOIN recordnotas rn ON c.curso_id = rn.curso_id " +
                    "WHERE rn.alumno_id = ?");
            ps.setInt(1, Usua.getID());
            rs = ps.executeQuery();
            rsmd1 = rs.getMetaData();
            columnas = rsmd1.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int indice = 0; indice < columnas; indice++) {
                    fila[indice] = rs.getObject(indice + 1);
                }
                modeloTabla.addRow(fila);              
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e);
            }
        }
    }
}
