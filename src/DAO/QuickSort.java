
package DAO;



public class QuickSort {
        public static void ordenar(Object[][] datos, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indicePivote = particion(datos, izquierda, derecha);
            ordenar(datos, izquierda, indicePivote - 1);
            ordenar(datos, indicePivote + 1, derecha);
        }
    }

    private static int particion(Object[][] datos, int izquierda, int derecha) {
        Object valorPivote = datos[derecha][0]; 
        int i = izquierda - 1;

        for (int j = izquierda; j < derecha; j++) {
            if (((String) datos[j][0]).compareTo((String) valorPivote) <= 0) {
                i++;
                intercambiar(datos, i, j);
            }
        }

        intercambiar(datos, i + 1, derecha);
        return i + 1;
    }

    private static void intercambiar(Object[][] datos, int i, int j) {
        Object[] temp = datos[i];
        datos[i] = datos[j];
        datos[j] = temp;
    }
}
