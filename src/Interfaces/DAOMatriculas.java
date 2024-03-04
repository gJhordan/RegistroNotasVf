/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Informacion.Matriculas;
import javax.swing.JTable;

/**
 *
 * @author Administrador
 */
public interface DAOMatriculas {

    public void CargarCursosDisponibles(Matriculas matri, JTable tabla);

    public void CargarSeccionesDisponibles(Matriculas matri, JTable tabla);

    public void CargarSeccionesMatriculadas(Matriculas matri, JTable tabla);

    public void EliminarSeccionesMatriculadas(Matriculas matri);

    public void AgregarSeccionesMatriculadas(Matriculas matri);

    public void IncrementarAlumnos(Matriculas matri);

    public void DisminuirAlumnos(Matriculas matri);
}
