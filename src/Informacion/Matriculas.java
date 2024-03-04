/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Informacion;

import java.util.Hashtable;

/**
 *
 * @author Administrador
 */
public class Matriculas {

    private int alumnoid, periodoid, estadoseccionid, cursoID, cicloid, nroseccion;
    private String nombreCurso;
    private String horarios[] = new String[24];

    public String[] getHorarioF() {
        return horarios;
    }

    public void setHorarioF(String[] horarios) {
        this.horarios = horarios;
    }

    public String getHorarioEsp(int indice) {
        if (indice >= 0 && indice < horarios.length) {
            return horarios[indice];
        }
        return "nada";
    }

    public void setHorarioEsp(int indice, String valor) {
        if (indice >= 0 && indice < horarios.length) {
            horarios[indice] = valor;
        }
    }

    private Hashtable<Integer, String> miHashtable = new Hashtable<>();

    public Hashtable<Integer, String> getMiHashtable() {
        return miHashtable;
    }

    // Setter para actualizar la Hashtable desde otra clase
    public void setMiHashtable(Hashtable<Integer, String> nuevaHashtable) {
        miHashtable = nuevaHashtable;
    }

    public int getAlumnoid() {
        return alumnoid;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void setAlumnoid(int alumnoid) {
        this.alumnoid = alumnoid;
    }

    public int getPeriodoid() {
        return periodoid;
    }

    public void setPeriodoid(int periodoid) {
        this.periodoid = periodoid;
    }

    public int getEstadoseccionid() {
        return estadoseccionid;
    }

    public void setEstadoseccionid(int estadoseccionid) {
        this.estadoseccionid = estadoseccionid;
    }

    public int getCursoID() {
        return cursoID;
    }

    public void setCursoID(int cursoID) {
        this.cursoID = cursoID;
    }

    public int getCicloid() {
        return cicloid;
    }

    public void setCicloid(int cicloid) {
        this.cicloid = cicloid;
    }

    public int getNroseccion() {
        return nroseccion;
    }

    public void setNroseccion(int nroseccion) {
        this.nroseccion = nroseccion;
    }

}
