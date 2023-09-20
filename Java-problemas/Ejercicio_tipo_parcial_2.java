//Un dispositivo que lleva un animal bovino en su cuello recolecta datos de un acelerómetro en tres ejes: X Y Z.
//Cada toma de datos se representa como una secuencia de valores enteros entre 0 y 1023 para cada eje, las
//secuencias están separadas por -1 (valor no válido para esta lógica). El productor quiere conocer cómo se ha
//comportado su animal en el transcurso del día y para ello ingresa un patrón de aceleración X Y Z y una cantidad
//N de repeticiones. Un patrón que se repite una cierta cantidad de veces significa que el animal puede estar
//pastoreando, caminando, rumiando, etc. Dado un valor N y el patrón X Y Z en un arreglo inicializado con -1 (de
//tamaño igual al arreglo que tiene los datos), hacer un programa en JAVA que:
//- Compruebe si el patrón se repitió N o más veces y si es así que elimine del arreglo las secuencias que se
//siguen repitiendo luego de la cantidad N.

//En resumen, eliminar las secuencias del patron que se repitan mas de N veces. ¿como? comparando las secuencias,
//si en la principal encuentro el patrón de la segunda secuencia, reviso que se repita solo el numero de veces solicitado
//en caso de que se exceda, procedo a eliminar esos excedentes. 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays; 
  
class Ejercicio_tipo_parcial_2 {

  public static final int SEPARADOR = -1; 
  public static void main(String[] args) {
    
    int [] arregloPrincipal = {-1, 12,22,44,-1,23,34,55,-1,23,34,55,-1,23,34,55,-1,23,34,57,-1};
    int [] patron= {-1, -1,-1,-1,-1,-1,-1,-1,-1,23,34,55,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    
    int N = 0;
    
    System.out.println(Arrays.toString(arregloPrincipal));
    
    try{BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));  
  	System.out.println("Ingrese un numero:");
    N=Integer.valueOf(entrada.readLine());        
    } catch(Exception exc){
      System.out.println("aaaa");
    }
    
    int ini = 0;
    int fin = -1;
    int secuenciasEliminadas = 0;
    
    for(int i = 0; i<arregloPrincipal.length; i++){
       
      ini = buscarInicio(arregloPrincipal, fin +1);
      if(ini<arregloPrincipal.length){
        fin = buscarFin(arregloPrincipal, ini);
        if(existeSecuencia(arregloPrincipal, ini, fin, patron)){
          
          while(secuenciasEliminadas < N ){
            eliminarSecuencias(arregloPrincipal, ini, fin);
            secuenciasEliminadas++;
            
          }
          
        }      
        
      }//final del if "grande"  
      
    }//fin del for
    
    mostrarArreglo(arregloPrincipal);
  }//fin de la clase main
  
  
    public static int buscarInicio (int [] arre, int pos){
    while(pos <arre.length && arre[pos] == SEPARADOR){
      pos++; 
    }
    return pos; 
  }
  
    public static int buscarFin (int[] arre, int pos){
    while(pos <arre.length && arre[pos] != SEPARADOR){
      pos++;  
    }
      return pos-1;
  }
  
  public static boolean existeSecuencia(int [] arreP, int ini, int fin, int [] arreS){
    
    int iniS = 0;
    int finS = -1;
    boolean existe = false;
    
    //Voy a usar un while que busque el patron en el arreglo Principal, si lo encuentra va adevolver true
    
    while (iniS < arreS.length && !existe) {
          	iniS = buscarInicio(arreS, finS + 1);
            if (iniS < arreS.length) {
            finS = buscarFin(arreS, iniS);
    
    //Dentro del while usamos un if que compare si la longitud de las secuencias y su contenido son iguales.
            if ((fin-ini+1==finS-iniS+1) && sonIguales(arreP, ini, fin, arreS, iniS,finS)){
   				existe = true;
   
            }
          }   
        } 
      return existe; 
      
  }//final del booleano
  
  public static boolean sonIguales(int[] arrA, int ini, int fin, int[] arrS, int iniS, int finS) {
        
      while (ini <= fin && arrA[ini] == arrS[iniS]) {
                ini++;
                iniS++;
            }

          return ini > fin;
     
          }
  
  
  public static void eliminarSecuencias(int[] arre, int ini, int fin){
    
     for (int i = ini ; i <= fin; i++){
          correrAIzquierda(arre, i);
        }
  }
  
  public static void correrAIzquierda(int [] arr, int pos) {
      	
        for (int i = pos; i < arr.length- 1; i++){
		//acá se está reemplazando el valor de la posición del entero por el siguiente lugar. 
      	arr[i] = arr[i + 1];
			}
      }
  
  
   public static void mostrarArreglo(int[] arr) {
      
        for (int i = 0; i < arr.length; i++){
        System.out.print(arr[i] + " - ");
          
        }   
        
      }
  
  
  
  
  
}//fin de la CLASS