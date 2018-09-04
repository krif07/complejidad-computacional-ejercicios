package com.co.cbg.cp.ejercicios2;

import java.time.Duration;
import java.time.Instant;
import com.co.cbg.cp.ejercicios1.Ejercicios;

public class Ordenamiento {

	private static long[] vector;
	
	private static long[] vectorBurbuja;
	private static long[] vectorSeleccion;
	private static long[] vectorHeap;
	private static long[] vectorShell;
	
	//Para búsqueda
	private static long[] vectorBusquedaSecuencial;
	private static long[] vectorBusquedaBinaria;
	
	/*public static void main(String[] args){
		
		//int tamVector = 100;
		
		//int[] vector = Ejercicios.llenarVector2(tamVector);
		//imprimirVector(vector);
		
		//burbuja(vector);
		//seleccion(vector);
		//imprimirVector(vector);
		
		//HeapSort     
        //System.out.println("Prueba HeapSort");
        //int tamVector = 10000;
        
        /* Accept number of elements */
        //long[] vector = llenarVector(tamVector);   
        /* llenar vector */
        
        /* imprimir vector */
        //System.out.println("Elementos del vector");        
        //imprimirVector(vector);
        //System.out.println();
        //Heapsort(vector);
        //imprimirVector(vector);
        
        //-------------------------
		//crearVectoresPrueba();
	//}
	
	public static void crearVectoresPrueba() {
		int tamVector = 1000;
		
		vector = llenarVector(tamVector);
		//Para ordenar
		
		vectorBurbuja = vector.clone();
		vectorSeleccion = vector.clone();
		vectorHeap = vector.clone();
		vectorShell = vector.clone();
		
		//Para búsqueda
		vectorBusquedaSecuencial = vector.clone();
		vectorBusquedaBinaria = vector.clone();
		
		System.out.println("Vectores sin ordenar");;
		imprimirVector(vector);
		imprimirVector(vectorBurbuja);
		imprimirVector(vectorSeleccion);
		imprimirVector(vectorHeap);
		imprimirVector(vectorShell);
		
		burbuja(vectorBurbuja);
		seleccion(vectorSeleccion);
		heapsort(vectorHeap);
		
		System.out.println("Vectores luego de ordenar");
		//imprimirVector(vector);
		imprimirVector(vectorBurbuja);
		imprimirVector(vectorSeleccion);
		imprimirVector(vectorHeap);
		imprimirVector(vectorShell);
	}
	
	public static void burbuja(long[] vector) {
		
		int n = vector.length;
		
		System.out.println("Ordenamiento Burbuja");
		DatosEstadisticos datosEstadisticos = new DatosEstadisticos();
		datosEstadisticos.setTamVector(n);
		
		for(int i=0; i<=(n-1); i++) {
			
			for(int j=i+1; j<n; j++) {
				
				datosEstadisticos.incrementarComparaciones();
				
				if(vector[i]>vector[j]) {
					//datosEstadisticos.incrementarNumeroIntercambios();
					intercambiar(vector, i, j, datosEstadisticos);
				}
			}
		}
		
		datosEstadisticos.imprimirEstadisticos();
		
	}
		
	public static void seleccion(long[] vector) {
		
		System.out.println("Ordenamiento Selección");
		DatosEstadisticos datosEstadisticos = new DatosEstadisticos();
		int tamVector = vector.length;
		datosEstadisticos.setTamVector(tamVector);

		int indiceDelMenor = 0;
		int nuevoLimiteCalculado = tamVector - 1;
		
		for(int i=0; i<nuevoLimiteCalculado; i++) {
			
			indiceDelMenor = buscarIndiceDelMenorEnVector(vector, i+1, tamVector, datosEstadisticos);
			
			datosEstadisticos.incrementarComparaciones(); 
			
			//System.out.println("indiceDelMenor: " + indiceDelMenor);
			if(vector[indiceDelMenor] < vector[i]) {
				
				//datosEstadisticos.incrementarNumeroIntercambios(); 
				
				intercambiar(vector, i, indiceDelMenor, datosEstadisticos);
			}
		}
		
		datosEstadisticos.imprimirEstadisticos();
	}
	
	public static void quickSort(Double[] vector, int indiceIzq, int indiceDer) {
		
		
	}
	
	public static int buscarIndiceDelMenorEnVector(long[] vector, int indiceIzq, int tamVector, DatosEstadisticos datosEstadisticos) {
		
		//Se toma el primero como el menor
		int indiceDelMenor = indiceIzq;
		int nuevoIndiceCalculado = indiceIzq+1;
		
		//Se empieza desde el segundo 
		for(int i=nuevoIndiceCalculado; i<tamVector; i++) {
			
			datosEstadisticos.incrementarComparaciones();
			if(vector[i] < vector[indiceDelMenor]) {
				indiceDelMenor = i;
			}
		}
		
		return indiceDelMenor;
	}
	
	//HeapSort
	private static int N;
	 
	public static void heapsort(long vector[]){    
		
		System.out.println("Ordenamiento Heap");
		
		DatosEstadisticos datosEstadisticos = new DatosEstadisticos();
		datosEstadisticos.setTamVector(vector.length);
		
		heapify(vector, datosEstadisticos);        
        for (int i = N; i > 0; i--){
            intercambiar(vector,0, i, datosEstadisticos);
            N = N-1;
            maxheap(vector, 0, datosEstadisticos);
        }
        
        datosEstadisticos.imprimirEstadisticos();
    }
	
	 public static  void heapify(long vector[], DatosEstadisticos datosEstadisticos)
	 {		
		    N = vector.length-1;
	        for (int i = N/2; i >= 0; i--) {
	        	maxheap(vector, i, datosEstadisticos);
	        }
	 }
	 
	 public static void maxheap(long vector[], int i, DatosEstadisticos datosEstadisticos)
	 { 
		    int left = 2*i ;
	        int right = 2*i + 1;
	        int max = i;
	        
	        datosEstadisticos.incrementarComparaciones();
	        if (left <= N && vector[left] > vector[i]) {
	            max = left;
	        }
	        datosEstadisticos.incrementarComparaciones();
	        if (right <= N && vector[right] > vector[max]) {        
	            max = right;
	        }
	        datosEstadisticos.incrementarComparaciones();
	        if (max != i)
	        {
	            intercambiar(vector, i, max, datosEstadisticos);
	            maxheap(vector, max, datosEstadisticos);
	        }
	  }
	 
	 //------------
	
	
	public static void intercambiar(long[] vector, int i, int j, DatosEstadisticos datosEstadisticos) {
		long temporal = vector[i];
		vector[i] = vector[j];
		vector[j] = temporal;
		
		datosEstadisticos.incrementarNumeroIntercambios();
	}
	
	public static void imprimirVector(long[] vector) {
		
		int n = vector.length;
		
		System.out.print("[");
		for(int i=0; i<n; i++) {
			System.out.print(vector[i] + ",");
		}
		System.out.print("]");
		System.out.println();
	}
	
	public static long[] llenarVector(int num) {
		
		long[] vector = new long[num];
		
		for(int i=1; i<=num; i++) {
			long n = (long) (Math.random() * 999999999999l) + 1;
			//System.out.println("n"+i+ " = " + n);
			vector[i-1] = n;			
		}
		
		return vector;
	}
	
}

class DatosEstadisticos{
	
	private int tamVector;
	private Long comparaciones;
	private Long numeroIntercabios;
	
	Instant start;
	
	DatosEstadisticos(){
		this.tamVector = 10;
		this.comparaciones = 0L;
		this.numeroIntercabios = 0L;
		
		start = Instant.now();
	}
	
	public int getTamVector() {
		return tamVector;
	}

	public void setTamVector(int tamVector) {
		this.tamVector = tamVector;
	}

	public void incrementarComparaciones() {
		this.comparaciones++;
	}
	
	public void incrementarNumeroIntercambios() {
		this.numeroIntercabios++;
	}
	
	public void imprimirEstadisticos() {
		
		Instant end = Instant.now();
		
		System.out.println("tamaño del vector: " + getTamVector());
		System.out.println("comparaciones: " + getComparaciones());
		System.out.println("numeroIntercabios: " + getNumeroIntercabios());
		
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("Tiempo tomado: "+ timeElapsed.toMillis() +" milisegundos");
		System.out.println();
	}
	
	public Long getComparaciones() {
		return comparaciones;
	}
	public void setComparaciones(Long comparaciones) {
		this.comparaciones = comparaciones;
	}
	public Long getNumeroIntercabios() {
		return numeroIntercabios;
	}
	public void setNumeroIntercabios(Long numeroIntercabios) {
		this.numeroIntercabios = numeroIntercabios;
	}	
	
}
