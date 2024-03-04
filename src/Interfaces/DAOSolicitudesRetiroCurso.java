/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;


import Informacion.SolicitudesInfo;
import Informacion.SolAlumnos;

/**
 *
 * @author Administrador
 */
public interface DAOSolicitudesRetiroCurso {
    public void cambiarEstadoSolicitudAlumno(SolicitudesInfo SolReAlum);
    public void cambiarEstadoCuentaAlumno(SolAlumnos SolActAlum);

}
