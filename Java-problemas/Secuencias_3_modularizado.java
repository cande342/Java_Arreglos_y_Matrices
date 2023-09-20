//Dado un arreglo de tamaño de arreglo MAX=20 de secuencias. En
//el caso de eliminar secuencias se debe hacer corrimiento.
//Hacer un programa que devuelva la posición de inicio y fin de la
//anteúltima secuencia de números distintos de ceros.


public class Secuencias_3_modularizado {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 3, 4, 5, 6, 0, 7, 8, 0, 9, 10, 0, 0, 11, 12, 0, 13};
        int inicio = 0;
        int fin = 0;
        
        encontrarAnteultimaSecuencia(arr, arr.length, inicio, fin);
        
        if (inicio != -1 && fin != -1) {
            System.out.println("La anteúltima secuencia inicia en la posición " + inicio + " y termina en la posición " + fin);
        } else {
            System.out.println("No se encontró una anteúltima secuencia en el arreglo.");
        }
    }

    public static void encontrarAnteultimaSecuencia(int[] arr, int size, int inicio, int fin) {
        inicio = -1;
        fin = -1;
        int contador = 0;
        int ultimaSecuencia = -1;
        int anteultimaSecuencia = -1;

        for (int i = 0; i < size; i++) {
            if (arr[i] != 0) {
                if (inicio == -1) {
                    inicio = i;
                }
                fin = i;
                contador++;
            } else {
                if (contador > 0) {
                    anteultimaSecuencia = ultimaSecuencia;
                    ultimaSecuencia = i;
                    contador = 0;
                }
            }
        }

        if (anteultimaSecuencia != -1) {
            inicio = ultimaSecuencia + 1;
            fin = anteultimaSecuencia - 1;
        }
    }
}
