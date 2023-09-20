//Un dispositivo que toma imágenes de un fenómeno natural está corriendo sobre una
//plataforma tecnológica con recursos limitados. Cada imagen (representada por una matriz
//de NxM) está compuesta por píxeles con valores entre 0 y 255. Se tiene implementado un
//algoritmo de compresión que comprime aquellas porciones de la imagen distintas del color
//negro (0 en la escala de valores del pixel). Dicho algoritmo procede de la siguiente manera:
//por cada una de las filas de la matriz, toma cada secuencia delimitada por uno o mas
//pixeles de color negro (valor 0) con más de X repeticiones de un valor de píxel (para ser
//comprimida todos los elementos de la secuencia deben ser iguales), comprime la secuencia
//poniendo en la primera posición el valor negado de la cantidad de ocurrencias y a
//continuación el valor del pixel que se repite. Cada fila de la matriz empieza y termina con
//uno o más pixeles negros.
//Se pide implementar el algoritmo de descompresión que restablezca la matriz
//original. Asumir que cada fila posee suficientes lugares como para realizar la
//descompresión.
//Ejemplo de matriz comprimida con X = 3:
 class recu11 {
    
    public static final int MAXFIL = 4;
    public static final int MAXCOL = 20;

    public static final int SEPARADOR = 0;

    public static void main(String[] args) {

        int[][] img = {
            {0,-8,67,0,14,0,-4,33,0,5,98,0,0,0,0,0,0,0,0,0},
            {0,0,25,25,0,-5,3,0,25,44,44,0,-4,1,0,0,0,0,0,0},
            {0,44,44,44,0,-7,15,0,-4,9,0,12,0,0,0,0,0,0,0,0},
            {-9,69,0,-10,12,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
        };

        imprimirMatriz(img);

        int ini = 0, fin = -1, valor = 0, cantidad = 0;
        
        for (int i = 0; i < MAXFIL; i++) {
            while (ini < MAXCOL) {
                ini = obtenerInicio(img[i], fin+1);

                if (ini < MAXCOL) {
                    fin = obtenerFin(img[i], ini);

                    if(img[i][ini] < 0){

                        cantidad = -(img[i][ini]);
                        valor = img[i][fin];

                        corrimientoDer(img[i], fin, cantidad-2);

                        llenarSecuencia(img[i], ini, cantidad, valor);

                        fin = obtenerFin(img[i], ini);

                    }

                }


            }

            ini = 0;
            fin = -1;
            valor = 0;
            cantidad = 0;
        }
        

        imprimirMatriz(img);
        
    }

    public static void imprimirMatriz(int[][] matriz) {
    
    for (int i = 0; i < MAXFIL; i++) {
        for (int j = 0; j < MAXCOL; j++) {
            System.out.print(matriz[i][j] + "\t");
            }
        System.out.println();
    }
    System.out.println();
    }

    public static void corrimientoDer(int[] arr, int fin, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            for (int j = MAXCOL-1; j > fin; j--) {
                arr[j] = arr[j-1];
            }
        }
        
    }
    public static void llenarSecuencia(int[] arr, int ini, int cantidad, int valor) {
        for (int i = 0; i < cantidad; i++) {
            arr[ini+i] = valor;
        }
    }

    public static int obtenerInicio(int[] arr, int pos) {
        
        while (pos < MAXCOL && arr[pos] == SEPARADOR) {
            pos++;
        }

        return pos;
    }
    public static int obtenerFin(int[] arr, int pos) {
        
        while (pos < MAXCOL && arr[pos] != SEPARADOR) {
            pos++;
        }

        return pos-1;
    }

   

}