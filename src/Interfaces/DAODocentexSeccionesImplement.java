/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import CONECT.Conexion;
import Informacion.AlumnoParticipacion;
import Informacion.DocentexSecciones;
import Informacion.NotasDetalles;
import Informacion.NotasSubir;
import Informacion.ValoresEstaticos;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Administrador
 */
public class DAODocentexSeccionesImplement implements DAODocentexSecciones {

    DAONotasDetallesImplement DAOND = new DAONotasDetallesImplement();
    AlumnoParticipacion EAP = ValoresEstaticos.VEAP;
    NotasSubir ENS = ValoresEstaticos.VENS;

    @Override
    public void CargarSeccionesdelDocente(DocentexSecciones DxS, JTable tabla) {
        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        ResultSet rs1;
        ResultSetMetaData rsmd1;
        int columnas1;
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setRowCount(0);

        try {
            ps1 = (PreparedStatement) con1.prepareStatement("SELECT c.nombre_curso, s.seccion_id, c.ciclo_curso FROM secciones s JOIN cursos c ON s.curso_id = c.curso_id JOIN docentes d ON s.docente_id = d.docente_id WHERE d.docente_id = ? AND s.periodo_id = ? AND s.id_estado_seccion = '1';");
            ps1.setInt(1, DxS.getDocenteID());
            ps1.setInt(2, DxS.getPeriodoID());
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
    public void CargarAlumnosxSeccion(DocentexSecciones DxS, JTable tabla) {
        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        ResultSet rs1;
        ResultSetMetaData rsmd1;
        int columnas1, a = 0;
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setRowCount(0);

        try {
            ps1 = (PreparedStatement) con1.prepareStatement("SELECT a.CodigoUsu, CONCAT(a.nombres, ' ', a.apellidop, ' ', a.apellidom) AS nombre_completo FROM seccionxalumno sa JOIN alumnos a ON sa.alumno_id = a.alumno_id JOIN secciones s ON sa.seccion_id = s.seccion_id WHERE sa.seccion_id = ? AND sa.id_estado_seccionxalumno = 3;");
            ps1.setInt(1, DxS.getNroseccionDoc());
            rs1 = ps1.executeQuery();
            rsmd1 = rs1.getMetaData();
            columnas1 = rsmd1.getColumnCount();

            while (rs1.next()) {
                Object[] fila = new Object[columnas1];
                for (int indice = 0; indice < columnas1; indice++) {
                    fila[indice] = rs1.getObject(indice + 1);
                }
                modeloTabla.addRow(fila);
                a++;
            }
            DxS.setNroAlumnos(a);
            con1.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
    }

    @Override
    public void CargarNotasFinalesAlumno(DocentexSecciones DxS) {
        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        ResultSet rs1;
        try {
            ps1 = (PreparedStatement) con1.prepareStatement("SELECT alumno_id FROM alumnos WHERE CodigoUsu = ?;");
            ps1.setString(1, DxS.getCodAlumno());
            rs1 = ps1.executeQuery();

            while (rs1.next()) {
                DxS.setAlumnoID(rs1.getInt(1));
//                System.out.println(DxS.getAlumnoID());
            }
            con1.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
        Connection con5 = Conexion.conect();
        PreparedStatement ps5;
        ResultSet rs5;
        try {
            ps5 = (PreparedStatement) con5.prepareStatement("SELECT NroNota, nota FROM seccionxalumnoxnotas WHERE seccion_id = ? AND alumno_id = ?;");
            ps5.setInt(1, DxS.getNroseccionDoc());
            ps5.setInt(2, DxS.getAlumnoID());
            rs5 = ps5.executeQuery();
            int a = 0;
            while (rs5.next()) {
                DxS.setNotas((rs5.getInt(1) - 1), rs5.getDouble(2));
                a++;
            }
            DxS.setNroNotasRegistradasxAlumno(a);
            if (a != 4) {
                for (int i = a; i < 4; i++) {
                    DxS.setNotas(i, 99);
                }
            }

          con1.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
        Connection con2 = Conexion.conect();
        PreparedStatement ps2;
        ResultSet rs2;
        try {

            ps2 = (PreparedStatement) con2.prepareStatement("SELECT promedio_final FROM seccionxalumno WHERE seccion_id = ? AND alumno_id = ?;");
            ps2.setInt(1, DxS.getNroseccionDoc());
            ps2.setInt(2, DxS.getAlumnoID());
            rs2 = ps2.executeQuery();
            while (rs2.next()) {
                if (rs2.getObject(1) != null) {
                    DxS.setPF(rs2.getDouble(1));
                } else {
                    DxS.setPF(99);
                }

            }
 con1.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
    }

    @Override
    public void CargarNombresTiposyPorcentajes(DocentexSecciones DxS, int Valor) {
        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        ResultSet rs1;
        try {
            Valor++;
            ps1 = (PreparedStatement) con1.prepareStatement("SELECT nombrenotas,TipoNota,porcnotas FROM formatonotas WHERE NroNota = ? AND IDNotas = ?;");
            ps1.setInt(1, Valor);
            ps1.setInt(2, DxS.getNroseccionDoc());
            rs1 = ps1.executeQuery();
            while (rs1.next()) {
                DxS.setNotasNombres((Valor - 1), rs1.getString(1));
                DxS.setNotasTipos((Valor - 1), rs1.getString(2));
                DxS.setNotasPorcentajes((Valor - 1), rs1.getInt(3));

            }

             con1.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
    }

    @Override
    public void InsertarPromedioFinal(DocentexSecciones DxS, int i) {
        if (i == 0) {
            CargarNotasFinalesxSeccion(DxS);
        }

        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        try {
            System.out.println(ENS.getNota1(i));
            System.out.println(ENS.getNota2(i));
            System.out.println(ENS.getNota3(i));
            System.out.println(ENS.getNota4(i));
            System.out.println(DxS.getNotasPorcentajes(0));
            System.out.println(DxS.getNotasPorcentajes(1));
            System.out.println(DxS.getNotasPorcentajes(2));
            System.out.println(DxS.getNotasPorcentajes(3));
            double prom = (ENS.getNota1(i) * ((double) DxS.getNotasPorcentajes(0) / 100))
                    + (ENS.getNota2(i) * ((double) DxS.getNotasPorcentajes(1) / 100))
                    + (ENS.getNota3(i) * ((double) DxS.getNotasPorcentajes(2) / 100))
                    + (ENS.getNota4(i) * ((double) DxS.getNotasPorcentajes(3) / 100));
            System.out.println(prom);
            prom = Math.round(prom * 100.0) / 100.0;
            DxS.setPF(prom);
            ps1 = (PreparedStatement) con1.prepareStatement("UPDATE seccionxalumno SET promedio_final = ? WHERE seccion_id = ? AND alumno_id = ?;");
            ps1.setDouble(1, prom);
            ps1.setInt(2, DxS.getNroseccionDoc());
            ps1.setInt(3, ENS.getIdAlumno(i));
            ps1.executeUpdate();

            con1.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
    }

    @Override
    public void SubirNotas(DocentexSecciones DxS, NotasDetalles ND) {
        DefinirNroNotasSubidas(DxS);
        if (DxS.getNroNotaActual() != 4) {
            System.out.println("wa");
            String a = DxS.getNotasTipos(DxS.getNroNotaActual());
            int cantidad = 0;
            switch (a) {
                case "Unica":
                    Connection con2 = Conexion.conect();
                    PreparedStatement ps2;
                    ResultSet rs2;
                    try {
                        ps2 = (PreparedStatement) con2.prepareStatement("SELECT COUNT(DISTINCT ap.alumno_id) AS cantidad_alumnos FROM auxiliarnotaunic ap WHERE ap.IDNotas = ? AND ap.NroNota = ?;");
                        ps2.setInt(1, DxS.getNroseccionDoc());
                        ps2.setInt(2, DxS.getNroNotaActual() + 1);
                        rs2 = ps2.executeQuery();
                        if (rs2.next()) {
                            cantidad = rs2.getInt(1);
                        }
                        con2.close();
                    } catch (SQLException e) {
                        System.out.println("ERRORSQL: " + e);

                    }
                    if (cantidad == DxS.getNroAlumnos()) {
                        Connection con4 = Conexion.conect();
                        PreparedStatement ps4;
                        try {

                            ps4 = (PreparedStatement) con4.prepareStatement("INSERT INTO seccionxalumnoxnotas (seccion_id, alumno_id, NroNota, IDNotas, nota) SELECT anp.IDNotas, anp.alumno_id, anp.NroNota, anp.IDNotas, anp.nota1unica FROM auxiliarnotaunic anp WHERE anp.NroNota = ? AND anp.IDNotas = ?;");
                            ps4.setInt(1, DxS.getNroNotaActual() + 1);
                            ps4.setInt(2, DxS.getNroseccionDoc());
                            ps4.executeUpdate();
                            con4.close();
                            JOptionPane.showMessageDialog(null, "Notas Subidas al sistema");
                            if (DxS.getNroNotaActual() == 3) {
                                DxS.setNroNotaActual(4);
                            }
                        } catch (SQLException e) {
                            System.out.println("ERRORSQL: " + e);

                        }
                        System.out.println("I");
                    } else {
                        JOptionPane.showMessageDialog(null, "Aun no se ha guardado todas las notas");
                    }
                    break;
                case "Promedio":
                    Connection con3 = Conexion.conect();
                    PreparedStatement ps3;
                    ResultSet rs3;
                    try {
                        ps3 = (PreparedStatement) con3.prepareStatement("SELECT COUNT(DISTINCT ap.alumno_id) AS cantidad_alumnos FROM auxiliarnotaprom ap WHERE ap.IDNotas = ? AND ap.NroNota = ? AND ap.nota1 IS NOT NULL AND ap.nota2 IS NOT NULL AND ap.nota3 IS NOT NULL;");
                        ps3.setInt(1, DxS.getNroseccionDoc());
                        ps3.setInt(2, DxS.getNroNotaActual() + 1);
                        rs3 = ps3.executeQuery();
                        if (rs3.next()) {
                            cantidad = rs3.getInt(1);
                            System.out.println("CA: " + cantidad);
                        }
                        con3.close();
                    } catch (SQLException e) {
                        System.out.println("ERRORSQL: " + e);

                    }
                    if (cantidad == DxS.getNroAlumnos()) {
                        Connection con4 = Conexion.conect();
                        PreparedStatement ps4;
                        try {

                            ps4 = (PreparedStatement) con4.prepareStatement("INSERT INTO seccionxalumnoxnotas (seccion_id, alumno_id, NroNota, IDNotas, nota) SELECT anp.IDNotas, anp.alumno_id, anp.NroNota, anp.IDNotas, ROUND((anp.nota1 + anp.nota2 + anp.nota3) / 3, 0) AS promedio FROM auxiliarnotaprom anp WHERE anp.NroNota = ? AND anp.IDNotas = ?;");
                            ps4.setInt(1, DxS.getNroNotaActual() + 1);
                            ps4.setInt(2, DxS.getNroseccionDoc());
                            ps4.executeUpdate();

                            con4.close();
                            JOptionPane.showMessageDialog(null, "Notas Subidas al sistema");
                            if (DxS.getNroNotaActual() == 3) {
                                DxS.setNroNotaActual(4);
                            }
                        } catch (SQLException e) {
                            System.out.println("ERRORSQL: " + e);

                        }
                        System.out.println("Ipro");
                    } else {
                        JOptionPane.showMessageDialog(null, "Aun no se ha guardado todas las notas");
                    }
                    break;
                case "Participacion":
                    int respuesta = JOptionPane.showConfirmDialog(null, "¿Recuerda que por predeterminado todas las participaciones son 0\nPor ende si no has realizado registro de participaciones la nota de todos los alumnos será 0, \ndeseas continuar??", "Confirmación", JOptionPane.YES_NO_OPTION);

                    if (respuesta == JOptionPane.YES_OPTION) {
                        Connection con4 = Conexion.conect();
                        PreparedStatement ps4;
                        ResultSet rs4;
                        try {
                            ps4 = (PreparedStatement) con4.prepareStatement("SELECT COUNT(DISTINCT ap.alumno_id) AS cantidad_alumnos FROM auxiliarnotapart ap WHERE ap.IDNotas = ? AND ap.NroNota = ?;");
                            ps4.setInt(1, DxS.getNroseccionDoc());
                            ps4.setInt(2, DxS.getNroNotaActual() + 1);
                            rs4 = ps4.executeQuery();
                            if (rs4.next()) {
                                cantidad = rs4.getInt(1);
                            }
                            con4.close();
                        } catch (SQLException e) {
                            System.out.println("ERRORSQL: " + e);

                        }

                        if (cantidad == DxS.getNroAlumnos()) {
                            ND.setNroseccionDoc(DxS.getNroseccionDoc());
                            ND.setNroNota(DxS.getNroNotaActual() + 1);
                            DAOND.ObtenerParticipacionxAlumno(ND);
                            EAP.mostrarResultados();
                            for (int i = 0; i < cantidad; i++) {
                                ND.setNotaFinal(EAP.buscarNotaPorID(EAP.getIDs(i)));
                                ND.setAlumnoID(EAP.getIDs(i));
                                DAOND.SubirNotasFinales(ND);
                            }

                            JOptionPane.showMessageDialog(null, "Notas Subidas al sistema");
                            if (DxS.getNroNotaActual() == 3) {
                                DxS.setNroNotaActual(4);
                               
                            }
                            System.out.println("Ipar");
                        } else {
                            JOptionPane.showMessageDialog(null, "Aun no se ha guardado todas las participaciones");
                        }
                    }

                    break;
                default:
                    throw new AssertionError();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay mas notas por subir");
        }

    }

    @Override
    public void CargarNotasFinalesxSeccion(DocentexSecciones DxS) {
        int i = 0;
        ENS.definirCantidadAlumnos(DxS.getNroAlumnos());
        Connection con2 = Conexion.conect();
        PreparedStatement ps2;
        ResultSet rs2;
        try {
            ps2 = (PreparedStatement) con2.prepareStatement("SELECT alumno_id, MAX(CASE WHEN NroNota = 1 THEN nota END) AS Nota1, MAX(CASE WHEN NroNota = 2 THEN nota END) AS Nota2, MAX(CASE WHEN NroNota = 3 THEN nota END) AS Nota3, MAX(CASE WHEN NroNota = 4 THEN nota END) AS Nota4 FROM seccionxalumnoxnotas WHERE seccion_id = ? GROUP BY alumno_id;");
            ps2.setInt(1, DxS.getNroseccionDoc());
            rs2 = ps2.executeQuery();
            while (rs2.next()) {
                ENS.ingresarDatos(i, rs2.getInt(1), rs2.getInt(2), rs2.getInt(3), rs2.getInt(4), rs2.getInt(5));
                i++;
            }
            ENS.mostrarDatos();
            con2.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
    }
  @Override
    public void CargarTablaReporte(DocentexSecciones DxS, JTable tabla){
        Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        ResultSet rs1;
        ResultSetMetaData rsmd1;
        int columnas1;
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setRowCount(0);
        try {
            ps1 = (PreparedStatement) con1.prepareStatement("SELECT a.CodigoUsu, CONCAT(a.nombres, ' ', a.apellidop, ' ', a.apellidom) AS nombreCompleto, MAX(CASE WHEN s.NroNota = 1 THEN s.nota END) AS Nota1, MAX(CASE WHEN s.NroNota = 2 THEN s.nota END) AS Nota2, MAX(CASE WHEN s.NroNota = 3 THEN s.nota END) AS Nota3, MAX(CASE WHEN s.NroNota = 4 THEN s.nota END) AS Nota4, sa.promedio_final FROM seccionxalumno sa JOIN alumnos a ON sa.alumno_id = a.alumno_id JOIN seccionxalumnoxnotas s ON sa.alumno_id = s.alumno_id WHERE sa.id_estado_seccionxalumno = 3 AND sa.seccion_id = ? GROUP BY a.CodigoUsu;");
            ps1.setInt(1, DxS.getNroseccionDoc());
            rs1 = ps1.executeQuery();
            rsmd1 = rs1.getMetaData();
            columnas1 = rsmd1.getColumnCount();

            while (rs1.next()) {
                System.out.println("CARGA TABLA");
                Object[] fila = new Object[columnas1];
                for (int indice = 0; indice < columnas1; indice++) {
                    fila[indice] = rs1.getObject(indice + 1);
                }
                modeloTabla.addRow(fila);
            }
            con1.close();
              System.out.println("ACABO CARGA");
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
    }

    public void ExportarTabla(JTable tabla, String nombreArchivo){
      try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

            Workbook workbook = new HSSFWorkbook();
            Sheet sheet = workbook.createSheet("Datos");

            // Copiar encabezados de columna desde la tabla
        Row headerRow = sheet.createRow(0);
        for (int col = 0; col < modelo.getColumnCount(); col++) {
            Object columnName = tabla.getColumnModel().getColumn(col).getHeaderValue();
            Cell cell = headerRow.createCell(col);
            if (columnName != null) {
                cell.setCellValue(columnName.toString());
            }
        }

            // Copiar datos de la tabla
            for (int fila = 0; fila < modelo.getRowCount(); fila++) {
                Row dataRow = sheet.createRow(fila + 1);
                for (int col = 0; col < modelo.getColumnCount(); col++) {
                    Object valorCelda = modelo.getValueAt(fila, col);
                    if (valorCelda != null) {
                        if (valorCelda instanceof Number number) {
                            dataRow.createCell(col).setCellValue(number.doubleValue());
                        } else {
                            dataRow.createCell(col).setCellValue(valorCelda.toString());
                        }
                    }
                }
            }

            // Guardar el archivo
            try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo + ".xls")) {
                workbook.write(fileOut);
                fileOut.close();
            }
            JOptionPane.showMessageDialog(null, "Tabla exportada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al exportar la tabla", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void DefinirNroNotasSubidas(DocentexSecciones DxS) {
       Connection con1 = Conexion.conect();
        PreparedStatement ps1;
        ResultSet rs1;
        try {
            ps1 = (PreparedStatement) con1.prepareStatement("SELECT MAX(NroNota) AS maxima_nota FROM seccionxalumnoxnotas WHERE seccion_id = ?;");
            ps1.setInt(1, DxS.getNroseccionDoc());
            rs1 = ps1.executeQuery();
            if (rs1.next()) {
                DxS.setNroNotaActual(rs1.getInt(1));
            } else {
                DxS.setNroNotaActual(0);
            }
            con1.close();
        } catch (SQLException e) {
            System.out.println("ERRORSQL: " + e);

        }
    }
}
