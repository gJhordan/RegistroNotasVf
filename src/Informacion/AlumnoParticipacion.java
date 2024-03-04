package Informacion;

import java.util.Arrays;

public class AlumnoParticipacion {

    private int cantidadAlumnos;
    private int[] participaciones;
    private int[] notas;
    private int[] IDs;
  public int getIDs(int indice) {
        if (indice >= 0 && indice < IDs.length) {
            return IDs[indice];
        }
        return 99;
    }

    public void setIDs(int indice, int valor) {
        if (indice >= 0 && indice < IDs.length) {
            IDs[indice] = valor;
        }
    }
    public AlumnoParticipacion() {
        this.cantidadAlumnos = 1; // Valor predeterminado
        inicializarArreglos();
    }

    public void definirCantidadAlumnos(int cantidad) {
        this.cantidadAlumnos = cantidad;
        inicializarArreglos();
    }

    private void inicializarArreglos() {
        participaciones = new int[cantidadAlumnos];
        notas = new int[cantidadAlumnos];
        IDs = new int[cantidadAlumnos];
    }

    public void ingresarDatos(int i, int participacion, int id) {
        participaciones[i] = participacion;
        IDs[i] = id;

    }

    public int buscarNotaPorID(int id) {
        for (int i = 0; i < cantidadAlumnos; i++) {
            if (IDs[i] == id) {
                return notas[i];
            }
        }
        return -1;
    }

    public int buscarParticipacionPorID(int id) {
        for (int i = 0; i < cantidadAlumnos; i++) {
            if (IDs[i] == id) {
                return participaciones[i];
            }
        }
        return -1;
    }

    public void calcularNotas() {
        int[] maxParticipacionesPorNota = calcularMaxParticipacionesPorNota();

        for (int i = 0; i < cantidadAlumnos; i++) {
            calcularNota(i, maxParticipacionesPorNota[i]);
        }
    }

    private void calcularNota(int notaIndex, int maxParticipacion) {
        int participacion = participaciones[notaIndex];

        switch (participacion) {
            case 0:
                notas[notaIndex] = 0;
                break;
            case 1:
                notas[notaIndex] = 10;
                break;
            default:
                double ratio = ((participacion - 1) / (double) (maxParticipacion - 1));
                double nota = 11 + ratio * 9;
                notas[notaIndex] = (int) nota;
                break;
        }
    }

    private int[] calcularMaxParticipacionesPorNota() {
        int[] maxParticipacionesPorNota = new int[cantidadAlumnos];

        for (int i = 0; i < cantidadAlumnos; i++) {
            int maxParticipacionNotaActual = Arrays.stream(participaciones).max().orElse(0);
            maxParticipacionesPorNota[i] = maxParticipacionNotaActual;
        }

        return maxParticipacionesPorNota;
    }

    public void mostrarResultados() {
        ordenarAlumnosPorParticipaciones();

        System.out.println("ID Alumno\tNº participaciones\tCalificacion");

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println(IDs[i] + "\t\t\t\t" + participaciones[i] + "\t\t\t\t" + notas[i]);
        }
    }

    private void ordenarAlumnosPorParticipaciones() {
        for (int j = 0; j < cantidadAlumnos - 1; j++) {
            for (int k = 0; k < cantidadAlumnos - j - 1; k++) {
                if (participaciones[k] < participaciones[k + 1]) {
                    intercambiarAlumnos(k, k + 1);
                }
            }
        }
    }

    private void intercambiarAlumnos(int indice1, int indice2) {
        int tempParticipacion = participaciones[indice1];
        int tempNota = notas[indice1];
        int tempID = IDs[indice1];

        participaciones[indice1] = participaciones[indice2];
        notas[indice1] = notas[indice2];
        IDs[indice1] = IDs[indice2];

        participaciones[indice2] = tempParticipacion;
        notas[indice2] = tempNota;
        IDs[indice2] = tempID;
    }
}
