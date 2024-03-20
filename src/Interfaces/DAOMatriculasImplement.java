/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import CONECT.Conexion;
import Informacion.Matriculas;
import Informacion.ValoresEstaticos;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Hashtable;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class DAOMatriculasImplement implements DAOMatriculas {

    Matriculas VEMS = ValoresEstaticos.VEM;
    Hashtable<Integer, String[]> tempHT = new Hashtable<>();

    @Override
    public void CargarCursosDisponibles(Matriculas matri, JTable tabla) {
        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        ResultSet rs1;
        ResultSetMetaData rsmd1;
        int columnas1;
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setRowCount(0);

        try {
             ps1 = (PreparedStatement) con1.prepareStatement("SELECT c.curso_id, c.nombre_curso, COUNT(*) AS cantidad_resultados FROM cursos c JOIN secciones s ON c.curso_id = s.curso_id LEFT JOIN seccionxalumno sx ON s.seccion_id = sx.seccion_id AND sx.alumno_id = ? WHERE s.periodo_id = ? AND s.id_estado_seccion = 1 AND sx.seccion_id IS NULL  AND s.nroinscritos < 10 AND c.curso_id NOT IN (SELECT DISTINCT c2.curso_id FROM cursos c2 JOIN secciones s2 ON c2.curso_id = s2.curso_id JOIN seccionxalumno sx2 ON s2.seccion_id = sx2.seccion_id WHERE sx2.alumno_id = ?) AND ((c.curso_id NOT IN (SELECT DISTINCT curso_id FROM recordnotas WHERE alumno_id = ?)) OR (c.curso_id NOT IN (SELECT DISTINCT curso_id FROM recordnotas WHERE alumno_id = ? AND estado IN ('C', 'A')) AND c.curso_id IN (SELECT DISTINCT curso_id FROM recordnotas WHERE alumno_id = ? AND estado = 'D'))) AND (c.curso_desbloqueador_id = 0 OR EXISTS (SELECT 1 FROM cursos c_desbloq JOIN recordnotas rn ON c_desbloq.curso_id = rn.curso_id WHERE c.curso_desbloqueador_id = c_desbloq.curso_id AND rn.alumno_id = ? AND rn.estado IN ('A', 'C'))) AND c.ciclo_curso <= (SELECT cantidad_ciclos FROM carreras WHERE codigo_carrera = (SELECT codigo_carrera FROM alumnos WHERE alumno_id = ?)) GROUP BY c.curso_id, c.nombre_curso;");
            ps1.setInt(1, matri.getAlumnoid());
            ps1.setInt(2, matri.getPeriodoid());
            ps1.setInt(3, matri.getAlumnoid());
            ps1.setInt(4, matri.getAlumnoid());
            ps1.setInt(5, matri.getAlumnoid());
            ps1.setInt(6, matri.getAlumnoid());
            ps1.setInt(7, matri.getAlumnoid());
            ps1.setInt(8, matri.getAlumnoid());
            rs1 = ps1.executeQuery();
          
            rsmd1 = rs1.getMetaData();
            columnas1 = rsmd1.getColumnCount();

            while (rs1.next()) {
                Object[] fila = new Object[columnas1];
                for (int indice = 0; indice < columnas1; indice++) {
                    fila[indice] = rs1.getObject(indice + 1);
                }
                modeloTabla.addRow(fila);
            }
            con1.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
    }

    @Override
    public void CargarSeccionesDisponibles(Matriculas matri, JTable tabla) {
        Connection con2 = Conexion.conect();
        PreparedStatement ps2;
        ResultSet rs2;
        ResultSetMetaData rsmd2;
        int columnas1, nrosession;
        String horarioconca = "";
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setRowCount(0);

        try {
            ps2 = (PreparedStatement) con2.prepareStatement("SELECT s.seccion_id, CONCAT(d.nombre, ' ', d.ApellidoP, ' ', d.ApellidoM) AS nombre_docente, CONCAT(h1.dia_semana, '-', h1.turno) AS sesion1, CONCAT(h2.dia_semana, '-', h2.turno) AS sesion2, CASE WHEN h1.id_horario IS NOT NULL AND h2.id_horario IS NOT NULL THEN 2 WHEN h1.id_horario IS NOT NULL THEN 1 ELSE 0 END AS cantidad_sesiones FROM cursos c JOIN secciones s ON c.curso_id = s.curso_id LEFT JOIN seccionxalumno sx ON s.seccion_id = sx.seccion_id AND sx.alumno_id = ?   LEFT JOIN docentes d ON s.docente_id = d.docente_id LEFT JOIN horarios h1 ON s.id_horario = h1.id_horario AND h1.nrosesion = 1 LEFT JOIN horarios h2 ON s.id_horario = h2.id_horario AND h2.nrosesion = 2 WHERE s.periodo_id = ? AND s.id_estado_seccion = '1' AND c.curso_id = ? AND s.nroinscritos < 10 AND sx.seccion_id IS NULL;");
            ps2.setInt(1, matri.getAlumnoid());
            ps2.setInt(2, matri.getPeriodoid());
            
            ps2.setInt(3, matri.getCursoID());

            rs2 = ps2.executeQuery();
            rsmd2 = rs2.getMetaData();
            columnas1 = rsmd2.getColumnCount();
            System.out.println(columnas1);
            while (rs2.next()) {

                nrosession = rs2.getInt("cantidad_sesiones");
                System.out.println(nrosession);
                Object[] fila = new Object[columnas1];
                for (int i = 0; i < columnas1; i++) {
                    if (nrosession == 1) {
                        if (i == 0 || i == 1 || i == 2) {
                            fila[i] = rs2.getObject(i + 1);
                        }
                    } else {
                        if (i == 0 || i == 1) {
                            fila[i] = rs2.getObject(i + 1);
                        } else {
                            if (i == 2) {
                                horarioconca = rs2.getString(i + 1);
                            } else {
                                if (i == 3) {
                                    horarioconca = horarioconca + " y " + rs2.getString(i + 1);
                                    System.out.println(horarioconca);
                                    fila[i - 1] = horarioconca;
                                }
                            }
                        }

                    }

                }
                modeloTabla.addRow(fila);
            }
            con2.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }

    }

    @Override
    public void CargarSeccionesMatriculadas(Matriculas matri, JTable tabla) {
        Connection con2 = Conexion.conect();
        PreparedStatement ps2;
        ResultSet rs2;
        ResultSetMetaData rsmd2;
        int columnas1, nrosession, itemp = 0;
        String horarioconca = "";
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setRowCount(0);

        try {
            ps2 = (PreparedStatement) con2.prepareStatement(" SELECT s.seccion_id, CONCAT(h1.dia_semana, '-', h1.turno) AS sesion1, CONCAT(h2.dia_semana, '-', h2.turno) AS sesion2, CONCAT(d.nombre, ' ', d.ApellidoP, ' ', d.ApellidoM) AS nombre_docente, c.nombre_curso, CASE WHEN h1.id_horario IS NOT NULL AND h2.id_horario IS NOT NULL THEN 2 WHEN h1.id_horario IS NOT NULL THEN 1 ELSE 0 END AS cantidad_sesiones FROM seccionxalumno sa JOIN secciones s ON sa.seccion_id = s.seccion_id JOIN cursos c ON s.curso_id = c.curso_id JOIN docentes d ON s.docente_id = d.docente_id LEFT JOIN horarios h1 ON s.id_horario = h1.id_horario AND h1.nrosesion = 1 LEFT JOIN horarios h2 ON s.id_horario = h2.id_horario AND h2.nrosesion = 2 WHERE sa.alumno_id = ? AND s.periodo_id = ? AND s.id_estado_seccion = '1';");
            ps2.setInt(1, matri.getAlumnoid());
            ps2.setInt(2, matri.getPeriodoid());
           

            rs2 = ps2.executeQuery();
            rsmd2 = rs2.getMetaData();
            columnas1 = rsmd2.getColumnCount();
            System.out.println(columnas1);
            Arrays.fill(VEMS.getHorarioF(), null);
            while (rs2.next()) {
                nrosession = rs2.getInt("cantidad_sesiones");

                if (nrosession == 1) {
                    VEMS.setHorarioEsp(itemp, rs2.getString("sesion1"));
                    System.out.println("NRO1" + VEMS.getHorarioEsp(itemp));
                    itemp++;
                } else {
                    VEMS.setHorarioEsp(itemp, rs2.getString("sesion1"));
                    VEMS.setHorarioEsp((itemp + 1), rs2.getString("sesion2"));
                    System.out.println("NRO2S1" + VEMS.getHorarioEsp(itemp));
                    System.out.println("NRO2S2" + VEMS.getHorarioEsp(itemp + 1));
                    itemp = itemp + 2;
                }

                System.out.println("NroSecciones: " + nrosession);
                Object[] fila = new Object[columnas1];
                for (int i = 0; i < columnas1; i++) {
                    if (nrosession == 1) {
                        if (i == 0 || i == 1) {
                            fila[i] = rs2.getObject(i + 1);
                        }
                        if (i == 2 || i == 3) {
                            fila[i] = rs2.getObject(i + 2);
                        }
                    } else {
                        if (i == 3 || i == 4) {
                            fila[i - 1] = rs2.getObject(i + 1);
                        }
                        if (i == 0) {
                            fila[i] = rs2.getObject(i + 1);

                        } else {
                            if (i == 1) {
                                horarioconca = rs2.getString(i + 1);
                            } else {
                                if (i == 2) {
                                    horarioconca = horarioconca + " y " + rs2.getString(i + 1);
                                    System.out.println(horarioconca);
                                    fila[i - 1] = horarioconca;
                                }
                            }
                        }

                    }

                }
                modeloTabla.addRow(fila);
            }
            con2.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
    }

    @Override
    public void EliminarSeccionesMatriculadas(Matriculas matri) {
        Connection con2 = Conexion.conect();
        PreparedStatement ps2;
        try {
            System.out.println("SEccE: " + matri.getNroseccion());
            System.out.println("AlidE: " + matri.getAlumnoid());
            ps2 = (PreparedStatement) con2.prepareStatement("DELETE FROM seccionxalumno WHERE seccion_id = ? AND alumno_id = ?;");
            ps2.setInt(1, matri.getNroseccion());
            ps2.setInt(2, matri.getAlumnoid());

            int filasAfectadas = ps2.executeUpdate();

            System.out.println("Filas afectadas: " + filasAfectadas);
            ps2.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
         try {
            ps2 = (PreparedStatement) con2.prepareStatement("UPDATE secciones SET nroinscritos = nroinscritos - 1 WHERE seccion_id = ?;");
            System.out.println("SEcc: " + matri.getNroseccion());
            ps2.setInt(1, matri.getNroseccion());

            ps2.executeUpdate();

            con2.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
    }

    @Override
    public void AgregarSeccionesMatriculadas(Matriculas matri) {
        Connection con2 = Conexion.conect();
        PreparedStatement ps2;
        try {
            ps2 = (PreparedStatement) con2.prepareStatement("  INSERT INTO seccionxalumno (seccion_id, alumno_id, id_estado_seccionxalumno) VALUES (?, ?, 3) ON DUPLICATE KEY UPDATE promedio_final = VALUES(promedio_final);");
            System.out.println("SEcc: " + matri.getNroseccion());
            System.out.println("Alid: " + matri.getAlumnoid());
            ps2.setInt(1, matri.getNroseccion());
            ps2.setInt(2, matri.getAlumnoid());
            ps2.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
        try {
            ps2 = (PreparedStatement) con2.prepareStatement("UPDATE secciones SET nroinscritos = nroinscritos + 1 WHERE seccion_id = ?;  ");
            System.out.println("SEcc: " + matri.getNroseccion());
            ps2.setInt(1, matri.getNroseccion());

            ps2.executeUpdate();

            con2.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
    }

    @Override
    public void IncrementarAlumnos(Matriculas matri) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void DisminuirAlumnos(Matriculas matri) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
