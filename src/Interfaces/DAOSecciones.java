/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Informacion.Horario;
import Informacion.Secciones;
import javax.swing.JComboBox;


public interface DAOSecciones {
    public void registrarFormatNotas(Secciones seccion, int valorlista);
    public void registrarSeccion(Secciones seccion, Horario horarios);
    public int comparar(Secciones seccion);
    public void cargar(Secciones seccion, JComboBox cmb);
    public int obtenerSesiones(Secciones seccion);
    public int obetenerIDs(Secciones seccion, String tablasql, String valorSql,String condicionalsql,String igualar);
}
