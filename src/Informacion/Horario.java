/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Informacion;

/**
 *
 * @author Administrador
 */
public class Horario {

    private int ID_horario;
    private String turno[] = new String[2];
    private int nrosesion[] = {1,2};
    private String diasemana[] = new String[2];

    public int getID_horario() {
        return ID_horario;
    }

    public void setID_horario(int ID_horario) {
        this.ID_horario = ID_horario;
    }

    public String[] getTurno() {
        return turno;
    }

    public void setTurno(String[] turno) {
        this.turno = turno;
    }

    public int[] getNrosesion() {
        return nrosesion;
    }

    public void setNrosesion(int[] nrosesion) {
        this.nrosesion = nrosesion;
    }

    public String[] getDiasemana() {
        return diasemana;
    }

    public void setDiasemana(String[] diasemana) {
        this.diasemana = diasemana;
    }

}
