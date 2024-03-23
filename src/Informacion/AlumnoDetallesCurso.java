/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Informacion;

/**
 *
 * @author Administrador
 */
public class AlumnoDetallesCurso {

    private int NroseccionAl, periodoID, alumnoID, nroCiclo, nroCursos, nroNotasRegistradas;
 private String  CodAlumno, NomPeriodo;
    private double PF = 99,Ponderado=99;
    private double Notas[] = {99, 99, 99, 99};
    private String NotasNombres[] = new String[4];
    private int NotasPorcentajes[] = new int[4];

    public String getNomPeriodo() {
        return NomPeriodo;
    }

    public void setNomPeriodo(String NomPeriodo) {
        this.NomPeriodo = NomPeriodo;
    }

    
    
    public int getNroseccionAl() {
        return NroseccionAl;
    }

    public void setNroseccionAl(int NroseccionAl) {
        this.NroseccionAl = NroseccionAl;
    }

    public int getNroNotasRegistradas() {
        return nroNotasRegistradas;
    }

    public void setNroNotasRegistradas(int nroNotasRegistradas) {
        this.nroNotasRegistradas = nroNotasRegistradas;
    }

    public double getPonderado() {
        return Ponderado;
    }

    public void setPonderado(double Ponderado) {
        this.Ponderado = Ponderado;
    }
    


    public double getNotas(int indice) {
        if (indice >= 0 && indice < Notas.length) {
            return Notas[indice];
        }
        return 99;
    }

    public void setNotas(int indice, double valor) {
        if (indice >= 0 && indice < Notas.length) {
            Notas[indice] = valor;
        }
    }

    public String getNotasNombres(int indice) {
        if (indice >= 0 && indice < NotasNombres.length) {
            return NotasNombres[indice];
        }
        return "nada";
    }

    public void setNotasNombres(int indice, String valor) {
        if (indice >= 0 && indice < NotasNombres.length) {
            NotasNombres[indice] = valor;
        }
    }


    public int getNotasPorcentajes(int indice) {
        if (indice >= 0 && indice < NotasPorcentajes.length) {
            return NotasPorcentajes[indice];
        }
        return 99;
    }

    public void setNotasPorcentajes(int indice, int valor) {
        if (indice >= 0 && indice < NotasPorcentajes.length) {
            NotasPorcentajes[indice] = valor;
        }
    }

    public String[] getNotasNombresF() {
        return NotasNombres;
    }

    public void setNotasNombresF(String[] NotasNombres) {
        this.NotasNombres = NotasNombres;
    }



    public int[] getNotasPorcentajesF() {
        return NotasPorcentajes;
    }

    public void setNotasPorcentajesF(int[] NotasPorcentajes) {
        this.NotasPorcentajes = NotasPorcentajes;
    }

    public double[] getNotasF() {
        return Notas;
    }

    public void setNotasF(double[] Notas) {
        this.Notas = Notas;
    }

    public String getCodAlumno() {
        return CodAlumno;
    }

    public void setCodAlumno(String CodAlumno) {
        this.CodAlumno = CodAlumno;
    }

    public int getNroCursos() {
        return nroCursos;
    }

    public void setNroCursos(int nroCursos) {
        this.nroCursos = nroCursos;
    }


    public int getNroCiclo() {
        return nroCiclo;
    }

    public void setNroCiclo(int nroCiclo) {
        this.nroCiclo = nroCiclo;
    }

    public int getPeriodoID() {
        return periodoID;
    }

    public void setPeriodoID(int periodoID) {
        this.periodoID = periodoID;
    }

    public int getAlumnoID() {
        return alumnoID;
    }

    public void setAlumnoID(int alumnoID) {
        this.alumnoID = alumnoID;
    }

    
    public double getPF() {
        return PF;
    }

    public void setPF(double PF) {
        this.PF = PF;
    }
}
