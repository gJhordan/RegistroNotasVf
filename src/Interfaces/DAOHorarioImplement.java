/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author Administrador
 */
public class DAOHorarioImplement implements DAOHorario {

   
    Secciones Secca = ValoresEstaticos.VES;

    @Override
    public void RegistrarHorario(Horario horario, int valorlista) {
         Connection con = Conexion.conect();
    PreparedStatement ps;
    ResultSet rs;
        try {
            System.out.println(Secca.getSeccionID());
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO horarios (id_horario, dia_semana, turno, nrosesion) VALUES (?, ?, ?, ?); ");
            ps.setInt(1, Secca.getSeccionID());
            ps.setString(2, horario.getDiasemana()[valorlista]);
            ps.setString(3, horario.getTurno()[valorlista]);
            ps.setInt(4, horario.getNrosesion()[valorlista]);

            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }
    }

    @Override
    public int CargarDocentesxHorario(Horario horario, JComboBox combo) {

        String[] Listaturnos = horario.getTurno();
        String[] Lista = horario.getDiasemana();
         Connection con = Conexion.conect();
    PreparedStatement ps;
    ResultSet rs;
        try {
            /*System.out.println(Lista[0]);
            System.out.println(Listaturnos[0]);
            System.out.println(Lista[1]);
            System.out.println(Listaturnos[1]);*/
            ps = (PreparedStatement) con.prepareStatement("SELECT DISTINCT d.CodigoUsu FROM docentes d LEFT JOIN secciones s ON d.docente_id = s.docente_id LEFT JOIN horarios h ON s.id_horario = h.id_horario WHERE d.docente_id NOT IN (    SELECT s.docente_id   FROM secciones s  JOIN horarios h ON s.id_horario = h.id_horario WHERE (h.dia_semana = ? AND h.turno = ?) OR (h.dia_semana = ? AND h.turno = ?)) OR s.docente_id IS NULL;");
            ps.setString(1, Lista[0]);
            ps.setString(2, Listaturnos[0]);
            ps.setString(3, Lista[1]);
            ps.setString(4, Listaturnos[1]);

            rs = ps.executeQuery();

            while (rs.next()) {
                combo.addItem(rs.getString(1));
                // System.out.println("En el carreras: "+rs.getString(1));

            }
            int i = combo.getItemCount();
            if (i == 0) {
                JOptionPane.showMessageDialog(null, "No existen docentes disponibles en ese horario, escoja otro");
            }

            con.close();
            return i;
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
            return -1;
        }
    }

}
