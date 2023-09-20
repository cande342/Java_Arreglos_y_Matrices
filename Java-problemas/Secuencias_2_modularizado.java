//Dado un arreglo de tamaño de arreglo MAX=20 de secuencias. En
//el caso de eliminar secuencias se debe hacer corrimiento.
//Hacer un programa que devuelva la posición de inicio y fin de la
//secuencia de números distintos de ceros cuya suma del contenido
//sea mayor.

class Secuencias_2_modularizado {
  public static void main(String[] args) {
    
    int[]arreglo= {0,3,5,0,0,4,5,2,0,4,1,3,0,4,4,4,0,5,0,0};
    int inicioMayor= -1;
    int finMayor = -1;
    int sumaMayor = 0;
   
     for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != 0) {
                int inicio = i;
                int fin = i;
                int suma = arreglo[i];
                
                // Continuamos buscando el final de la secuencia no nula y calculando su suma
                for (int j = i + 1; j < arreglo.length; j++) {
                    if (arreglo[j] == 0) {
                        break;
                    }
                    fin = j;
                    suma += arreglo[j];
                }
                
                // Si la suma de la secuencia actual es mayor que la suma de la secuencia con mayor suma,
                // actualizamos las variables de la secuencia con mayor suma
                if (suma > sumaMayor) {
                    inicioMayor = inicio;
                    finMayor = fin;
                    sumaMayor = suma;
                }
                
                // Saltamos al final de la secuencia actual
                i = fin;
            }
       
     }
    
    // Imprimimos las posiciones de inicio y fin de la secuencia con mayor suma
        System.out.println("La secuencia de números distintos de ceros con mayor suma comienza en la posición " + inicioMayor + " y termina en la posición " + finMayor);
  }
}

