/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Informacion;

/**
 *
 * @author ACER
 */
public class Usuario {

    private int Edad, ID;
    private String Nombre, ApeP, ApeM, DNI, rol, correopersonal, telefono, estado, CodigoUsu, Clave, nombrecompleto;

    public int getEdad() {
        return Edad;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto() {
        this.nombrecompleto = getNombre() + " " + getApeP() + " " + getApeM();
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApeP() {
        return ApeP;
    }

    public void setApeP(String ApeP) {
        this.ApeP = ApeP;
    }

    public String getApeM() {
        return ApeM;
    }

    public void setApeM(String ApeM) {
        this.ApeM = ApeM;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCorreopersonal() {
        return correopersonal;
    }

    public void setCorreopersonal(String correopersonal) {
        this.correopersonal = correopersonal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoUsu() {
        return CodigoUsu;
    }

    public void setCodigoUsu(String CodigoUsu) {
        this.CodigoUsu = CodigoUsu;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

}
