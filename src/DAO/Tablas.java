/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CONECT.Conexion;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class Tablas {

    //declara variable ResultSetMetaData
    int columnas;

    public void CargarTablaPeriodos(JTable tabla, String nombretabla, String nombrecondicional) {
         Connection con = Conexion.conect();
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel(); //para usar el diseño de la tabla creada
        modeloTabla.setRowCount(0);// para que cada que se inicie el programa muestre la informacion sin acumularlo

        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT `nombre_periodo`, `estado` FROM `" + nombretabla +"`;");
         

            rs = ps.executeQuery();

            rs = ps.executeQuery();//para realizar una consulta en una base de datos
            rsmd = rs.getMetaData(); //para traer los metadatos de la consulta ( proporciona información sobre la estructura y los tipos de datos de las columnas en los resultados de la consulta)
            columnas = rsmd.getColumnCount();//para obtener el numero de columnas 

            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int indice = 0; indice < columnas; indice++) {
                    fila[indice] = rs.getObject(indice + 1); // se utiliza para recorrer las filas de un objeto ResultSet.
                }
                modeloTabla.addRow(fila); // se utiliza para agregar una nueva fila a un modelo de tabla existente
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }

    }
  
    public void CargarTablaSolicitudDoc(JTable tabla, String nombretabla, String nombrecondicional) {
         Connection con = Conexion.conect();
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel(); //para usar el diseño de la tabla creada
        modeloTabla.setRowCount(0);// para que cada que se inicie el programa muestre la informacion sin acumularlo

        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM `" + nombretabla +"` WHERE estado_sol = 'Pendiente' ;");
         

            rs = ps.executeQuery();

            rs = ps.executeQuery();//para realizar una consulta en una base de datos
            rsmd = rs.getMetaData(); //para traer los metadatos de la consulta ( proporciona información sobre la estructura y los tipos de datos de las columnas en los resultados de la consulta)
            columnas = rsmd.getColumnCount();//para obtener el numero de columnas 

            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int indice = 0; indice < columnas; indice++) {
                    fila[indice] = rs.getObject(indice + 1); // se utiliza para recorrer las filas de un objeto ResultSet.
                }
                modeloTabla.addRow(fila); // se utiliza para agregar una nueva fila a un modelo de tabla existente
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }

    }
}
