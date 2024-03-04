/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Informacion;

/**
 *
 * @author USUARIO
 */
public class Alumno extends Usuario{

    
    private int Ciclo;
    private String Carrera, Recursos, Modalidad,EstadoPago,valBeca;

    public String getEstadoPago() {
        return EstadoPago;
    }

    public void setEstadoPago(String EstadoPago) {
        this.EstadoPago = EstadoPago;
    }

    public String getValBeca() {
        return valBeca;
    }

    public void setValBeca(String valBeca) {
        this.valBeca = valBeca;
    }

    public String getRecursos() {
        return Recursos;
    }

    public void setRecursos(String Recursos) {
        this.Recursos = Recursos;
    }

    public String getModalidad() {
        return Modalidad;
    }

    public void setModalidad(String Modalidad) {
        this.Modalidad = Modalidad;
    }

    public int getCiclo() {
        return Ciclo;
    }

    public void setCiclo(int Ciclo) {
        this.Ciclo = Ciclo;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }



    
}
