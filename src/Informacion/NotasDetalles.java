/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Informacion;

/**
 *
 * @author Administrador
 */
public class NotasDetalles {

    private int NroseccionDoc, alumnoID, nroNota, porcentaje, nroParticipaciones;
    private String nombrenota, tipoNota;
    private double NotaFinal = 99, NotaUnica = 99;
    private double NotasPromedio[] = {99, 99, 99};

    public double getNotaUnica() {
        return NotaUnica;
    }

    public void setNotaUnica(double NotaUnica) {
        this.NotaUnica = NotaUnica;
    }

    public String getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(String tipoNota) {
        this.tipoNota = tipoNota;
    }

    public int getNroNota() {
        return nroNota;
    }

    public void setNroNota(int nroNota) {
        this.nroNota = nroNota;
    }

    public String getNombrenota() {
        return nombrenota;
    }

    public void setNombrenota(String nombrenota) {
        this.nombrenota = nombrenota;
    }

    public double getNotasPromedio(int indice) {
        if (indice >= 0 && indice < NotasPromedio.length) {
            return NotasPromedio[indice];
        }
        return 99;
    }

    public void setNotasPromedio(int indice, double valor) {
        if (indice >= 0 && indice < NotasPromedio.length) {
            NotasPromedio[indice] = valor;
        }
    }

    public int getNroseccionDoc() {
        return NroseccionDoc;
    }

    public void setNroseccionDoc(int NroseccionDoc) {
        this.NroseccionDoc = NroseccionDoc;
    }

    public int getAlumnoID() {
        return alumnoID;
    }

    public void setAlumnoID(int alumnoID) {
        this.alumnoID = alumnoID;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getNotaFinal() {
        return NotaFinal;
    }

    public void setNotaFinal(double NotaFinal) {
        this.NotaFinal = NotaFinal;
    }

    public int getNroParticipaciones() {
        return nroParticipaciones;
    }

    public void setNroParticipaciones(int nroParticipaciones) {
        this.nroParticipaciones = nroParticipaciones;
    }

    public double[] getNotasPromedioF() {
        return NotasPromedio;
    }

    public void setNotasPromedioF(double[] NotasPromedio) {
        this.NotasPromedio = NotasPromedio;
    }

}
