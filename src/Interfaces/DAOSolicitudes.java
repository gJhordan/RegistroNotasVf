/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;


import Informacion.SolDocentes;
import javax.swing.JComboBox;

/**
 *
 * @author Administrador
 */
public interface DAOSolicitudes {
    public void cambiarEstadoSolicitudDocente(SolDocentes SolDoc);
    public void ActualizarDocente(SolDocentes SolDoc);
    public int ObtenerDocentesDisponibles(SolDocentes SolDoc, JComboBox Combo);
    public void ObtenerInfoCurso(SolDocentes SolDoc);
    public void ObtenerInfoDocente(SolDocentes SolDoc);
    public void getHorarios(SolDocentes SolDoc);
}
