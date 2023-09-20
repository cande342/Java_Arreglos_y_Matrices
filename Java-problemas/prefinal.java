//Dado una matriz de NxM, donde N es la cantidad de lecturas realizadas y M la cantidad de
//canales analizados más 2 (cada fila comienza y termina con un espacio), se pide:
//determinar la cantidad de señales de posible origen extraterrestre en la matriz. Una señal es
//de posible origen extraterrestre si en P lecturas consecutivas (filas) existen al menos K
//intensidades superiores a un determinado valor alfanumérico L en una de sus secuencias
//(canales de rastreo con lecturas consecutivas distintas de 0).
//Para el siguiente ejemplo donde N=5 y M=20 (18 canales), K=2, L=’F’ y P=2 existe UNA
//señal de posible origen extraterrestre en las lecturas 0 y 1


class prefinal {
  public static final int N = 5;
  public static final int M = 20;
  public static final int K = 2;
  public static final char L = 'F';
  public static final int P = 2;
  public static final char SEPARADOR = ' ';
  
  
  public static void main(String[] args) {
    
    
    char [][] mat = {
      {' ','1','2','G','H',' ','2','A','3',' ','3','R','B','J',' ','6','5','K',' ',' '},
      {' ',' ','2','1','4','5',' ','R','P',' ','D','3',' ','7','M','N','W',' ',' ',' '},
      {' ','4','G','8',' ','3','5','7','1',' ',' ','2','X',' ','D','4','1',' ',' ',' '},
      {' ',' ',' ','5','T','T','M',' ','A','P','1','1',' ','2','1','3',' ','1','3',' '},
      {' ','6','6','4',' ','5','4',' ',' ','A','2','1','2',' ','G','H','2','1','8',' '}
    };
    
	int posiblesExtraterrestre = extrate(mat);
    System.out.println("Se encontraron "+posiblesExtraterrestre+" señales posibles de bichos raros.");

    
  }
   public static int extrate(char [] [] mat){
     
    int contador = 0;
    int contadorFinal = 0;
 
    for(int i = 0; i<N;i++){
      if(cumplio(mat[i])){
        contador++;      
      }else{
        contador=0;
      }     
     if (contador == P){
       contadorFinal++;
       contador=0;
     } 
     
  }
    return contadorFinal;
 }    
   
    
    
  public static boolean cumplio(char[]fila){
    int ini= 0, fin = 0;
    boolean cumplir=false;
    while(ini < M-1 && cumplir == false){
     ini = buscarInicio(fila, fin+1);
      if(ini<M-1){
        fin = buscarFin(fila, ini);
        //"supera" me dice si en la secuencia actual al menos dos valores superaron a F.
        if(supera(fila, ini, fin)){
          cumplir = true; 
        }
      }
      
    }
    
    return cumplir; 
  }
  
  public static boolean supera(char []fila, int ini, int fin){
    int supero = 0;
    boolean valida = false;
    while(ini<fin && !valida){
      if(fila[ini]>L){
        supero++;
        	if(supero == K){
              valida=true;
            }
      }
      ini++;
    }
    return valida;
  }
  
    public static int buscarInicio(char[] arr, int pos) {
      
    while (pos < M-1 && arr[pos] == SEPARADOR)
      pos++;
      return pos;
      }
 
  
  public static int buscarFin(char[] arr, int pos) {
      
      while (pos < M-1 && arr[pos] != SEPARADOR)
      pos++;
      return pos - 1;
      } 
  
}
