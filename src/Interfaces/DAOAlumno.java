/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Informacion.Alumno;


/**
 *
 * @author USUARIO
 */
public interface DAOAlumno {
     public void registrar(Alumno alumno);
    public int comparar(Alumno alumno);
       public String[] validarPagoMatricula (Alumno alumpago);
        public void actualizarEstadoPago(Alumno alumpago, String nuevoEstado);
        public void ConvalidarCursos(Alumno alumno);
}
