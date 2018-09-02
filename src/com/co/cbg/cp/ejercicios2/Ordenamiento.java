package com.co.cbg.cp.ejercicios2;

import com.co.cbg.cp.ejercicios1.Ejercicios;

public class Ordenamiento {

	
	public static void main(String[] args){
		
		//int tamVector = 100;
		
		//int[] vector = Ejercicios.llenarVector2(tamVector);
		//imprimirVector(vector, tamVector);
		
		//burbuja(vector, tamVector);
		//seleccion(vector, tamVector);
		//imprimirVector(vector, tamVector);
		
		//HeapSort     
        System.out.println("Prueba HeapSort");
        int tamVector = 10;
        int i;    
        /* Accept number of elements */
        int[] vector = Ejercicios.llenarVector2(tamVector);   
        /* llenar vector */
        
        /* imprimir vector */
        System.out.println("Elementos del vector");        
        for (i = 0; i < tamVector; i++)
            System.out.print(vector[i]+" ");            
        System.out.println();
        
        Heapsort(vector);
        imprimirVector(vector, tamVector);
        
        //-------------------------
	}
	
	public static void burbuja(int[] vector, int n) {
		
		DatosEstadisticos datosEstadisticos = new DatosEstadisticos();
		
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
		
	public static void seleccion(int[] vector, int tamVector) {
		
		DatosEstadisticos datosEstadisticos = new DatosEstadisticos();

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
	
	public static int buscarIndiceDelMenorEnVector(int[] vector, int indiceIzq, int tamVector, DatosEstadisticos datosEstadisticos) {
		
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
	 
	public static void Heapsort(int vector[]){       
		DatosEstadisticos datosEstadisticos = new DatosEstadisticos();
		
		heapify(vector, datosEstadisticos);        
        for (int i = N; i > 0; i--){
            intercambiar(vector,0, i, datosEstadisticos);
            N = N-1;
            maxheap(vector, 0, datosEstadisticos);
        }
        
        datosEstadisticos.imprimirEstadisticos();
    }
	
	 public static  void heapify(int vector[], DatosEstadisticos datosEstadisticos)
	 {		
		    N = vector.length-1;
	        for (int i = N/2; i >= 0; i--) {
	        	maxheap(vector, i, datosEstadisticos);
	        }
	 }
	 
	 public static void maxheap(int vector[], int i, DatosEstadisticos datosEstadisticos)
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
	
	
	public static void intercambiar(int[] vector, int i, int j, DatosEstadisticos datosEstadisticos) {
		int temporal = vector[i];
		vector[i] = vector[j];
		vector[j] = temporal;
		
		datosEstadisticos.incrementarNumeroIntercambios();
	}
	
	public static void imprimirVector(int[] vector, int n) {
		
		System.out.print("[");
		for(int i=0; i<n; i++) {
			System.out.print(vector[i] + ",");
		}
		System.out.print("]");
		System.out.println();
	}
	
}

class DatosEstadisticos{
	
	private Long comparaciones;
	private Long numeroIntercabios;
	
	DatosEstadisticos(){
		this.comparaciones = 0L;
		this.numeroIntercabios = 0L;
	}
	
	public void incrementarComparaciones() {
		this.comparaciones++;
	}
	
	public void incrementarNumeroIntercambios() {
		this.numeroIntercabios++;
	}
	
	public void imprimirEstadisticos() {
		System.out.println("comparaciones: " + getComparaciones());
		System.out.println("numeroIntercabios: " + getNumeroIntercabios());
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
