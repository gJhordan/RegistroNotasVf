/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import CONECT.Conexion;
import Informacion.Alumno;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class DAOAlumnoImplement implements DAOAlumno {

    @Override
    public void registrar(Alumno alumno) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO usuarios (CodigoUsu, ClaveUsu, RolUsu) VALUES( ? , ? , ? );");
            ps.setString(1, alumno.getCodigoUsu());
            ps.setString(2, alumno.getClave());
            ps.setString(3, alumno.getRol());
            ps.executeUpdate();

            ps = (PreparedStatement) con.prepareStatement("INSERT INTO alumnos (apellidop, apellidom, nombres, edad, DNIAlumno, telefono, correo, estado, codigo_carrera, ciclo, CodigoUsu, valBeca) VALUES(? ,? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?);");
            ps.setString(1, alumno.getApeP());
            ps.setString(2, alumno.getApeM());
            ps.setString(3, alumno.getNombre());
            ps.setInt(4, alumno.getEdad());
            ps.setString(5, alumno.getDNI());
            ps.setString(6, alumno.getTelefono());
            ps.setString(7, alumno.getCorreopersonal());
            ps.setString(8, alumno.getEstado());
            ps.setInt(9, alumno.getCarrera());
            ps.setInt(10, alumno.getCiclo());
            ps.setString(11, alumno.getCodigoUsu());
            ps.setString(12, alumno.getValBeca());
            ps.executeUpdate();
            System.out.println(alumno.getCodigoUsu());
            System.out.println(alumno.getClave());
            JOptionPane.showMessageDialog(null, "Cuenta de Alumno Creada\nCodigo Generado: " + alumno.getCodigoUsu() + "\nClave Generada: " + alumno.getClave());
            con.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);
        }
    }

    @Override
    public int comparar(Alumno alumno) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
        ResultSet rs;
        int ComparacionR;
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT CodigoUsu from usuarios where CodigoUsu = ? ;");
            ps.setString(1, alumno.getCodigoUsu());
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
    public String[] validarPagoMatricula(Alumno alumpago) {
        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        ResultSet rs1;
        String[] resultados = new String[2];

        try {
            ps1 = (PreparedStatement) con1.prepareStatement("SELECT alumno_id FROM alumnos WHERE CodigoUsu = ?;");
            ps1.setString(1, alumpago.getCodigoUsu());
            rs1 = ps1.executeQuery();

            while (rs1.next()) {
                alumpago.setID(rs1.getInt(1));
//                System.out.println(alumpago.getID());

            }

        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
        try {
            // Obtener valBeca usando el ID del alumno
            ps1 = (PreparedStatement) con1.prepareStatement("SELECT valBeca, estadoPago FROM alumnos WHERE alumno_id = ?;");
            ps1.setInt(1, alumpago.getID());
            rs1 = ps1.executeQuery();

            while (rs1.next()) {
                // Obtener y mostrar el valBeca
                alumpago.setValBeca(rs1.getString("valBeca"));
                resultados[0] = alumpago.getValBeca();
//                System.out.println("valBeca: " + resultados[0]);

                alumpago.setEstadoPago(rs1.getString("estadoPago"));

                resultados[1] = alumpago.getEstadoPago();
            }
            con1.close();
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e);
        }

        return resultados;
    }

    @Override
    public void actualizarEstadoPago(Alumno alumpago, String nuevoEstado) {
        Connection con1 = Conexion.conect();
        PreparedStatement ps1;

        try {
            String sql = "UPDATE alumnos SET estadoPago = ? WHERE alumno_id = ?";
            ps1 = (PreparedStatement) con1.prepareStatement(sql);
            ps1.setString(1, nuevoEstado);
            ps1.setInt(2, alumpago.getID());
            ps1.executeUpdate();
            con1.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el estado de pago: " + e);
        }
    }

    @Override
    public void ConvalidarCursos(Alumno alumno) {
        Connection con = Conexion.conect();
        PreparedStatement ps;
     
           try {
            String sql = "INSERT INTO recordnotas (curso_id, alumno_id, VecesCursado, estado) SELECT c.curso_id, (SELECT alumno_id from alumnos where CodigoUsu = ?) AS alumno_id, 1 AS VecesCursado, 'C' AS estado FROM cursos c WHERE c.ciclo_curso BETWEEN 1 AND ?;";
            ps = (PreparedStatement) con.prepareStatement(sql);
           
            ps.setString(1, alumno.getCodigoUsu());
             ps.setInt(2, alumno.getCiclo()-1);
            ps.executeUpdate();
            con.close();
          
        } catch (SQLException e) {
            System.out.println("Error al actualizar el record de notas: " + e);
        }
        
    }
}
