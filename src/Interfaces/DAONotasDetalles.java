/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Informacion.NotasDetalles;

/**
 *
 * @author Administrador
 */
public interface DAONotasDetalles {

    public int ObtenerUnicaxAlumno(NotasDetalles NotasD);

    public int ObtenerParticipacionxAlumno(NotasDetalles NotasD);

    public int ObtenerPromediosxAlumno(NotasDetalles NotasD);

    public void ActualizarParticipacionxAlumno(NotasDetalles NotasD);

    public void ActualizarPromediosxAlumno(NotasDetalles NotasD);

    public void ActualizarUnicaxAlumno(NotasDetalles NotasD);

    public void SubirNotasFinales(NotasDetalles NotasD);

}
