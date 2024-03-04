/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Informacion.Docente;
import Informacion.Usuario;

/**
 *
 * @author USUARIO
 */
public interface DAODocente {

    public void registrar(Docente docente);
    public void modificar(Docente docente);
    public int comparar(Docente docente);
    public void CargarDocentesDisponibles(Docente docente);
    public void DefinirDocente(Docente docente);
}
