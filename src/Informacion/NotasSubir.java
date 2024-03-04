/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Informacion;



import java.util.Arrays;

public class NotasSubir {

    private int cantidadAlumnos;
    private int[] idAlumno;
    private double[] nota1;
    private double[] nota2;
    private double[] nota3;
    private double[] nota4;

    public NotasSubir() {
        this.cantidadAlumnos = 1; // Valor predeterminado
        inicializarArreglos();
    }

    public void definirCantidadAlumnos(int cantidad) {
        this.cantidadAlumnos = cantidad;
        inicializarArreglos();
    }

    private void inicializarArreglos() {
        idAlumno = new int[cantidadAlumnos];
        nota1 = new double[cantidadAlumnos];
        nota2 = new double[cantidadAlumnos];
        nota3 = new double[cantidadAlumnos];
        nota4 = new double[cantidadAlumnos];
    }

    public void ingresarDatos(int i, int id, double n1, double n2, double n3, double n4) {
        idAlumno[i] = id;
        nota1[i] = n1;
        nota2[i] = n2;
        nota3[i] = n3;
        nota4[i] = n4;
    }

    public int getIdAlumno(int indice) {
        if (indice >= 0 && indice < idAlumno.length) {
            return idAlumno[indice];
        }
        return 0; // Valor predeterminado
    }

    public void setIdAlumno(int indice, int valor) {
        if (indice >= 0 && indice < idAlumno.length) {
            idAlumno[indice] = valor;
        }
    }

    public double getNota1(int indice) {
        if (indice >= 0 && indice < nota1.length) {
            return nota1[indice];
        }
        return 0.0; // Valor predeterminado
    }

    public void setNota1(int indice, double valor) {
        if (indice >= 0 && indice < nota1.length) {
            nota1[indice] = valor;
        }
    }

    public double getNota2(int indice) {
        if (indice >= 0 && indice < nota2.length) {
            return nota2[indice];
        }
        return 0.0; // Valor predeterminado
    }

    public void setNota2(int indice, double valor) {
        if (indice >= 0 && indice < nota2.length) {
            nota2[indice] = valor;
        }
    }

    public double getNota3(int indice) {
        if (indice >= 0 && indice < nota3.length) {
            return nota3[indice];
        }
        return 0.0; // Valor predeterminado
    }

    public void setNota3(int indice, double valor) {
        if (indice >= 0 && indice < nota3.length) {
            nota3[indice] = valor;
        }
    }

    public double getNota4(int indice) {
        if (indice >= 0 && indice < nota4.length) {
            return nota4[indice];
        }
        return 0.0; // Valor predeterminado
    }

    public void setNota4(int indice, double valor) {
        if (indice >= 0 && indice < nota4.length) {
            nota4[indice] = valor;
        }
    }

    public void mostrarDatos() {
        System.out.println("ID Alumno\tNota1\tNota2\tNota3\tNota4");

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println(
                    idAlumno[i] + "\t\t" + nota1[i] + "\t" + nota2[i] + "\t" + nota3[i] + "\t" + nota4[i]);
        }
    }
}

