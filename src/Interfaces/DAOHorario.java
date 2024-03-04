/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Informacion.Horario;
import Informacion.Secciones;
import javax.swing.JComboBox;

/**
 *
 * @author Administrador
 */
public interface DAOHorario {
    public void RegistrarHorario(Horario horario, int valorlista);
    public int CargarDocentesxHorario(Horario horario, JComboBox combo);
    
}
