
package DAO;


import CONECT.Conexion;
import Informacion.EstadoPeriodos;
import Informacion.ValoresEstaticos;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class TablaAlumnosActivos {
     EstadoPeriodos VEPST = ValoresEstaticos.VEPST;
   
    int columnas;

    public void CargarTabla(JTable tabla, String nombretabla, String nombrecondicional) {
         Connection con = Conexion.conect();
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd; //declara variable ResultSetMetaData
        DefaultTableModel jTableAlumnosA = (DefaultTableModel) tabla.getModel(); //para usar el diseño de la tabla creada
        jTableAlumnosA.setRowCount(0);// para que cada que se inicie el programa muestre la informacion sin acumularlo

        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT apellidop, apellidom, nombres, CodigoUsu, ciclo, estado FROM alumnos WHERE estado = 'Activo' AND alumno_id IN (SELECT alumno_id FROM seccionxalumno WHERE id_estado_seccionxalumno = 3 AND seccion_id IN (SELECT seccion_id FROM secciones WHERE id_estado_seccion = 1 AND periodo_id = ?));;");
              ps.setInt(1, VEPST.getIdp());
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();

            Object[][] data = new Object[100][columnas]; // Ajusta el tamaño del arreglo según tus necesidades

            int row = 0;

            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int indice = 0; indice < columnas; indice++) {
                    fila[indice] = rs.getObject(indice + 1);
                }
                
                data[row] = fila;
                row++;
            }

            // Ordena los datos utilizando Quicksort
            QuickSort.ordenar(data, 0, row - 1);

            for (int i = 0; i < row; i++) {
                jTableAlumnosA.addRow(data[i]);
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }
    }
}

