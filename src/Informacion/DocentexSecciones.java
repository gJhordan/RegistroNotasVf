/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Informacion;

/**
 *
 * @author Administrador
 */
public class DocentexSecciones {

    private int NroseccionDoc, periodoID, alumnoID, nroCiclo, docenteID, nroCursos, nroNotasRegistradasxAlumno, nroAlumnos,nroNotaActual, validador;
    private String NAlumno, APAlumno, AMAlumno, NCMAlumno, NombreCurso, NCMDocente, CodAlumno;
    private double PF = 99;
    private double Notas[] = {99, 99, 99, 99};
    private String NotasNombres[] = new String[4];
    private String NotasTipos[] = new String[4];
    private int NotasPorcentajes[] = new int[4];

    public int getValidador() {
        return validador;
    }

    public void setValidador(int validador) {
        this.validador = validador;
    }

    public int getNroNotaActual() {
        return nroNotaActual;
    }

    public void setNroNotaActual(int nroNotaActual) {
        this.nroNotaActual = nroNotaActual;
    }



    public int getNroAlumnos() {
        return nroAlumnos;
    }

    public void setNroAlumnos(int nroAlumnos) {
        this.nroAlumnos = nroAlumnos;
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

    public String getNotasTipos(int indice) {
        if (indice >= 0 && indice < NotasTipos.length) {
            return NotasTipos[indice];
        }
        return "nada";
    }

    public void setNotasTipos(int indice, String valor) {
        if (indice >= 0 && indice < NotasTipos.length) {
            NotasTipos[indice] = valor;
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

    public String[] getNotasTiposF() {
        return NotasTipos;
    }

    public void setNotasTiposF(String[] NotasTipos) {
        this.NotasTipos = NotasTipos;
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

    public int getDocenteID() {
        return docenteID;
    }

    public void setDocenteID(int docenteID) {
        this.docenteID = docenteID;
    }

    public String getNCMDocente() {
        return NCMDocente;
    }

    public void setNCMDocente(String NCMDocente) {
        this.NCMDocente = NCMDocente;
    }

    public String getNombreCurso() {
        return NombreCurso;
    }

    public void setNombreCurso(String NombreCurso) {
        this.NombreCurso = NombreCurso;
    }

    public int getNroCiclo() {
        return nroCiclo;
    }

    public void setNroCiclo(int nroCiclo) {
        this.nroCiclo = nroCiclo;
    }

    public int getNroseccionDoc() {
        return NroseccionDoc;
    }

    public void setNroseccionDoc(int NroseccionDoc) {
        this.NroseccionDoc = NroseccionDoc;
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

    public String getNAlumno() {
        return NAlumno;
    }

    public void setNAlumno(String NAlumno) {
        this.NAlumno = NAlumno;
    }

    public String getAPAlumno() {
        return APAlumno;
    }

    public void setAPAlumno(String APAlumno) {
        this.APAlumno = APAlumno;
    }

    public String getAMAlumno() {
        return AMAlumno;
    }

    public void setAMAlumno(String AMAlumno) {
        this.AMAlumno = AMAlumno;
    }

    public String getNCMAlumno() {
        return NCMAlumno;
    }

    public void setNCMAlumno(String NCMAlumno) {
        this.NCMAlumno = NCMAlumno;
    }


    public int getNroNotasRegistradasxAlumno() {
        return nroNotasRegistradasxAlumno;
    }

    public void setNroNotasRegistradasxAlumno(int nroNotasRegistradasxAlumno) {
        this.nroNotasRegistradasxAlumno = nroNotasRegistradasxAlumno;
    }
    
    public double getPF() {
        return PF;
    }

    public void setPF(double PF) {
        this.PF = PF;
    }

}
