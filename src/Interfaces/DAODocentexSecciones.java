/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Informacion.DocentexSecciones;
import Informacion.NotasDetalles;
import javax.swing.JTable;

/**
 *
 * @author Administrador
 */
public interface DAODocentexSecciones {

    public void CargarSeccionesdelDocente(DocentexSecciones DxS, JTable tabla);

    public void CargarAlumnosxSeccion(DocentexSecciones DxS, JTable tabla);

    public void CargarNotasFinalesAlumno(DocentexSecciones DxS);

    public void CargarNotasFinalesxSeccion(DocentexSecciones DxS);

    public void CargarNombresTiposyPorcentajes(DocentexSecciones DxS, int Valor);

    public void InsertarPromedioFinal(DocentexSecciones DxS, int i);
    public void DefinirNroNotasSubidas(DocentexSecciones DxS);

    public void SubirNotas(DocentexSecciones DxS, NotasDetalles ND);

    public void CargarTablaReporte(DocentexSecciones DxS, JTable tabla);
}
