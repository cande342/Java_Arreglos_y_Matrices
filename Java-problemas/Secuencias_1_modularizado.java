//Dado un arreglo de tamaño de arreglo MAX=20 de secuencias. En
//el caso de eliminar secuencias se debe hacer corrimiento.
//Hacer un programa que devuelva la posición de inicio y fin de la
//primera secuencia de números distinta de ceros.

class Secuencias_1_modularizado {
  
   public static void main(String[] args) {
     
        int[] arreglo = {0, 0, 0, 1, 2, 3, 4, 0, 0, 0}; // Ejemplo de arreglo
        int inicio = -1; // Posición de inicio de la secuencia no nula
        int fin = -1; // Posición de fin de la secuencia no nula
        
        // Buscamos la primera secuencia de números no nulos
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != 0) {
                inicio = i;
                break;
            }
        }
        
        
        // Continuamos buscando el final de la secuencia no nula
        for (int i = inicio; i < arreglo.length; i++) {
            if (arreglo[i] == 0) {
                fin = i - 1;
                break;
            }
        }
        
        // Imprimimos las posiciones de inicio y fin de la secuencia no nula
        System.out.println("La primera secuencia no nula comienza en la posición " + inicio + " y termina en la posición " + fin);
    }
    
   
    
  }

