//El gerente desea solicitar distintas estadísticas según el mes que se quiere analizar. En
//algunos casos le interesa conocer el promedio mensual de las ventas de mayor importe
//registradas en cada día y en otros casos, necesita saber si el promedio diario de ventas
//fue todos los días superior a X durante el mes. Para ello informa en un arreglo A1 los
//meses que desea la primera estadística y en un arreglo A2 los de la segunda. A1 y A2 son
//de tamaño N, rellenados con 0.
//Por ejemplo, si A1 = {1,2,0} y A2 = {3,0,0} para los meses 1 y 2 se informará que el
//promedio es $484 (200 + 352 + 900 / 3) y 815.33 (940 + 765 + 741 / 3), respectivamente.
//Para el mes 3, dado un X = 600, informará que no se cumplió.

import java.io.BufferedReader;
import java.io.InputStreamReader; 

class recuperatorio {
  final static int X = 600;
  final static int filas = 3;
  final static int columnas = 15;
  final static int separador = 0;
  
  public static void main(String[] args) {
    
    int [][] mat = {
      {0,0,150,200,1,0,154,352,240,256,0,900,750,0,0},
      {0, 940, 15, 265, 845, 215, 0, 245, 65, 348, 0, 741, 125, 541, 0},
      {0, 851, 543, 625, 845, 914, 0, 754, 184, 452, 637, 917, 0, 0, 0},
    };
    //se puede hacer un metodo para rellenar los arreglos de modo manual
    int [] promMen = {1,2,0};
	int [] promDia = {3,0,0};
    int numero = 0;
    
   try{ BufferedReader entrada = new BufferedReader ( new InputStreamReader(System.in));
         

         
         System.out.println("Ingrese un número");
         numero = Integer.valueOf(entrada.readLine());
          
     }catch(Exception exc){
      
      System.out.println("error");
    }
    
    switch (numero){
      case 1:
        procesarMatM(mat, promMen);
        break;
      case 2:
        procesarMatD(mat, promDia);
        break;
    }
    
    
  }
  
  
  
  
  //CASE 1 
  
  
  
  
  public static void procesarMatM(int [][] mat, int [] arr1){
    float prom = 0;
    int i = 0;
    while(i<filas && arr1[i]!=separador){
        prom = buscarPromedioM(mat[arr1[i]-1]);
        System.out.print("En el mes "+arr1[i]+" el promedio mensual de las ventas mas altas fue de "+ prom);
        i++;
    }
  }
  
  
  
public static float buscarPromedioM(int[] mes) {
    int ini = 0, fin = -1, suma = 0, dias = 0;
    double valorMayor = 0;

    while (ini < columnas) {
        ini = buscarInicio(mes, fin + 1);
        if (ini < columnas) {
            fin = buscarFin(mes, ini);
            valorMayor = buscarMasAlto(mes, fin, ini);
            suma += valorMayor;
            dias++;
        }
    }
    return suma/dias; 
}
    
 public static int buscarMasAlto(int [] mes, int fin, int ini){
   int valorMayor = mes[ini];
  
   for(int i = ini+1; i<fin; i++){
     if(mes[i]> valorMayor){
       valorMayor = mes[i];      
     }
   }
   return valorMayor;
 }

  
  
  
  
  //ACA COMIENZA EL CASE 2.
  
  
  
    public static void procesarMatD(int [][] mat, int [] arr2){
    int i = 0;
    while(i<filas && arr2[i]!=separador){
      if(promedioDiario(mat[arr2[i]-1])){
        System.out.print("se cumplio la meta");
      } else{
        System.out.print("no se cumplió");
        }
      i++;
    }
  }
  
 public static boolean promedioDiario(int[]mes){
   
    int ini = 0, fin = -1, secuenciasCumplidas = 0, secuencias = 0;
    float prom = 0;
    
    
     while (ini < columnas) {
      	ini = buscarInicio(mes, fin + 1);
      	if (ini < columnas) {
      	fin = buscarFin(mes, ini);
        prom = calcularPromedio(mes, ini, fin);
        if(prom>X){
          secuenciasCumplidas++;
        }
        secuencias++;
      }
    }
   return secuenciasCumplidas==secuencias; 
 } 
  
  public static float calcularPromedio(int[] mes, int ini, int fin){
    float suma=0; 
    int tamanio= fin-ini+1;
    for(int i = ini; i<fin; i++){
      suma+= mes[i];
    }
    return suma/tamanio;
  }
  
  
  public static int buscarInicio(int[] arr, int pos) {
      
    while (pos < columnas && arr[pos] == separador)
      pos++;
      return pos;
      }
 
  
  public static int buscarFin(int[] arr, int pos) {
      
      while (pos < columnas && arr[pos] != separador)
      pos++;
      return pos - 1;
      } 
 
  
}