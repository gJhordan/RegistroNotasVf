/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Informacion;

/**
 *
 * @author Administrador
 */
public class SolDocentes extends SolicitudesInfo {

    private String CodDocenteAntiguo, CodDocenteNuevo, EspecializacionDocNuevo, NmcDocenteNuevo;
    private String turno[] = new String[2];
    private String diasemana[] = new String[2];
    private int IDDoc;

    public int getIDDoc() {
        return IDDoc;
    }

    public void setIDDoc(int IDDoc) {
        this.IDDoc = IDDoc;
    }
    
    
    public String getEspecializacionDocNuevo() {
        return EspecializacionDocNuevo;
    }

    public void setEspecializacionDocNuevo(String EspecializacionDocNuevo) {
        this.EspecializacionDocNuevo = EspecializacionDocNuevo;
    }

    public String getNmcDocenteNuevo() {
        return NmcDocenteNuevo;
    }

    public void setNmcDocenteNuevo(String NmcDocenteNuevo) {
        this.NmcDocenteNuevo = NmcDocenteNuevo;
    }

    public String[] getTurno() {
        return turno;
    }

    public void setTurno(String[] turno) {
        this.turno = turno;
    }

    public String[] getDiasemana() {
        return diasemana;
    }

    public void setDiasemana(String[] diasemana) {
        this.diasemana = diasemana;
    }

    public String getTurnoEsp(int indice) {
        if (indice >= 0 && indice < turno.length) {
            return turno[indice];
        }
        return "nada";
    }

    public void setTurnoEsp(int indice, String valor) {
        if (indice >= 0 && indice < turno.length) {
            turno[indice] = valor;
        }
    }

    public String getDiasemanaEsp(int indice) {
        if (indice >= 0 && indice < diasemana.length) {
            return diasemana[indice];
        }
        return "nada";
    }

    public void setDiasemanaEsp(int indice, String valor) {
        if (indice >= 0 && indice < diasemana.length) {
            diasemana[indice] = valor;
        }
    }

    public String getCodDocenteAntiguo() {
        return CodDocenteAntiguo;
    }

    public void setCodDocenteAntiguo(String CodDocenteAntiguo) {
        this.CodDocenteAntiguo = CodDocenteAntiguo;
    }

    public String getCodDocenteNuevo() {
        return CodDocenteNuevo;
    }

    public void setCodDocenteNuevo(String CodDocenteNuevo) {
        this.CodDocenteNuevo = CodDocenteNuevo;
    }
}
