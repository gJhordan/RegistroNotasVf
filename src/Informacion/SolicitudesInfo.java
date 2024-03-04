/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Informacion;

/**
 *
 * @author Administrador
 */
public class SolicitudesInfo {

    private int IDSol, NroSeccion;
    private String motivo, Estado, NombreCurso;

    public String getNombreCurso() {
        return NombreCurso;
    }

    public void setNombreCurso(String NombreCurso) {
        this.NombreCurso = NombreCurso;
    }

    public int getIDSol() {
        return IDSol;
    }

    public void setIDSol(int IDSol) {
        this.IDSol = IDSol;
    }

    public int getNroSeccion() {
        return NroSeccion;
    }

    public void setNroSeccion(int NroSeccion) {
        this.NroSeccion = NroSeccion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

}
