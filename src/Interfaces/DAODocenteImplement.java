/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import CONECT.Conexion;
import Informacion.Docente;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class DAODocenteImplement implements DAODocente {

    @Override
    public void registrar(Docente docente) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO usuarios (CodigoUsu, ClaveUsu, RolUsu) VALUES( ? , ? , ? );");
            ps.setString(1, docente.getCodigoUsu());
            ps.setString(2, docente.getClave());
            ps.setString(3, docente.getRol());
            ps.executeUpdate();

            ps = (PreparedStatement) con.prepareStatement("INSERT INTO docentes (nombre, ApellidoP, ApellidoM, edad, DNIDocente, correo, telefono, estado, Profesión, CodigoUsu, Especializacion, DuracionContrato) VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ?, ? , ? );");
            ps.setString(1, docente.getNombre());
            ps.setString(2, docente.getApeP());
            ps.setString(3, docente.getApeM());
            ps.setInt(4, docente.getEdad());
            ps.setString(5, docente.getDNI());
            ps.setString(6, docente.getCorreopersonal());
            ps.setString(7, docente.getTelefono());
            ps.setString(8, docente.getEstado());
            ps.setString(9, docente.getTitulo());
            ps.setString(10, docente.getCodigoUsu());
            ps.setString(11, docente.getEspecializacion());
            ps.setString(12, docente.getContrato());
            ps.executeUpdate();
            System.out.println(docente.getCodigoUsu());
            System.out.println(docente.getClave());
            JOptionPane.showMessageDialog(null, "Cuenta de Docente Creada\nCodigo Generado: " + docente.getCodigoUsu() + "\nClave Generada: " + docente.getClave());
            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }

    }

    @Override
    public int comparar(Docente docente) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        int ComparacionR;
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT CodigoUsu from usuarios where CodigoUsu = ? ;");
            ps.setString(1, docente.getCodigoUsu());
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
    public void modificar(Docente docente) {

    }

    @Override
    public void CargarDocentesDisponibles(Docente docente) {
    }

    @Override
    public void DefinirDocente(Docente docente) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        try {
            //     System.out.println(docente.getCodigoUsu());
            ps = (PreparedStatement) con.prepareStatement("SELECT `nombre`,`ApellidoP`, `ApellidoM`, `Profesión` FROM `docentes` WHERE `CodigoUsu` = ? ;");
            ps.setString(1, docente.getCodigoUsu());
            ps.executeQuery();

            rs = ps.executeQuery();
            while (rs.next()) {
                docente.setNombre(rs.getString(1));
                docente.setApeP(rs.getString(2));
                docente.setApeM(rs.getString(3));
                docente.setEspecializacion(rs.getString(4));
            }
            docente.setNombrecompleto();
            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }
    }

}
