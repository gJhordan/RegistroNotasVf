/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import CONECT.Conexion;
import Informacion.Alumno;
import Informacion.Docente;
import Informacion.Usuario;
import Informacion.ValoresEstaticos;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class DefinirInformacionUsuario {


   
    Usuario Usua = ValoresEstaticos.Usu;
    Docente DocS = ValoresEstaticos.Doc;
    Alumno AluS = ValoresEstaticos.Alu;

    public void DefinirUsuario(String CodUsuario) {
Connection con = Conexion.conect();
    PreparedStatement ps;
    ResultSet rs;
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT `CodigoUsu`,`RolUsu` FROM `usuarios` WHERE `CodigoUsu` = ? ;");

            ps.setString(1, CodUsuario);
            ps.executeQuery();
            rs = ps.executeQuery();

            while (rs.next()) {
                Usua.setCodigoUsu(rs.getString(1));
                Usua.setRol(rs.getString(2));
            }

            if (Usua.getRol().equals("Administrador")) {
                con.close();
            } else {
                if (Usua.getRol().equals("Docente")) {
                    DefinirDocente(CodUsuario);
                } else {
                    DefinirAlumno(CodUsuario);
                }

            }

        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }

    }

    public void DefinirDocente(String CodUsuario) {
        Connection con = Conexion.conect();
    PreparedStatement ps;
    ResultSet rs;
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM docentes WHERE `CodigoUsu` = ? ;");

            ps.setString(1, CodUsuario);
            ps.executeQuery();
            rs = ps.executeQuery();

            while (rs.next()) {
                Usua.setID(rs.getInt(1));
                Usua.setNombre(rs.getString(2));
                Usua.setApeP(rs.getString(3));
                Usua.setApeM(rs.getString(4));
                Usua.setCorreopersonal(rs.getString(7));
                Usua.setTelefono(rs.getString(8));
                DocS.setEspecializacion(rs.getString(10));

            }
            Usua.setNombrecompleto();
            con.close();

        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }

    }

    public void DefinirAlumno(String CodUsuario) {
        Connection con = Conexion.conect();
    PreparedStatement ps;
    ResultSet rs;
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT a.*, ca.nombre_carrera FROM alumnos a JOIN carreras ca ON a.codigo_carrera = ca.codigo_carrera WHERE a.Codigousu = ? ;");

            ps.setString(1, CodUsuario);
            ps.executeQuery();
            rs = ps.executeQuery();

            while (rs.next()) {
                Usua.setID(rs.getInt(1));
                Usua.setApeP(rs.getString(2));
                Usua.setApeM(rs.getString(3));
                Usua.setNombre(rs.getString(4));
                Usua.setTelefono(rs.getString(7));
                Usua.setCorreopersonal(rs.getString(8));
                
                AluS.setCarrera(rs.getInt(10));
//                System.out.println(AluS.getCarrera());
                AluS.setCiclo(rs.getInt(11));
                 AluS.setNombreCarrera(rs.getString(15));
//            System.out.println(AluS.getNombreCarrera());
            }
            Usua.setNombrecompleto();
            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }

    }
}
