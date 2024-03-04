/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Informacion.AlumnoDetallesCurso;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author Administrador
 */
public interface DAOAlumnoDetallesCurso {
    public void CargarPeriodosxAlumno(AlumnoDetallesCurso ADC, JComboBox Cmb);
    public void CargarSeccionesxAlumno(AlumnoDetallesCurso ADC, JTable tabla);
    public void CargarNotasxSeccion(AlumnoDetallesCurso ADC);
    public void GuardarPromedios(AlumnoDetallesCurso ADC);
}
