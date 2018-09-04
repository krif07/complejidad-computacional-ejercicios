package com.co.cbg.cp.ejercicios2;

public class Ordenamiento {

	private long[] vector;
	
	private long[] vectorBurbuja;
	private long[] vectorSeleccion;
	private long[] vectorHeap;
	private long[] vectorShell;
	
	//Para b�squeda
	//private long[] vectorBusquedaSecuencial;
	//private long[] vectorBusquedaBinaria;
	
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
	
	public void crearVectoresPrueba() {
		int tamVector = 1000;
		
		vector = llenarVector(tamVector);
		//Para ordenar
		
		vectorBurbuja = vector.clone();
		vectorSeleccion = vector.clone();
		vectorHeap = vector.clone();
		vectorShell = vector.clone();
		
		//Para b�squeda
		//vectorBusquedaSecuencial = vector.clone();
		//vectorBusquedaBinaria = vector.clone();
		
		System.out.println("Vectores sin ordenar");;
		imprimirVector(vector);
		imprimirVector(vectorBurbuja);
		imprimirVector(vectorSeleccion);
		imprimirVector(vectorHeap);
		imprimirVector(vectorShell);
		
		//imprimirVector(vectorBusquedaSecuencial);
		//imprimirVector(vectorBusquedaBinaria);
		
	}
	

	public DatosEstadisticos burbuja(long[] vector) {
		
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
		return datosEstadisticos;
		
	}
		
	public DatosEstadisticos seleccion(long[] vector) {
		
		System.out.println("Ordenamiento Selecci�n");
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
		return datosEstadisticos;
	}
	
	
	public int buscarIndiceDelMenorEnVector(long[] vector, int indiceIzq, int tamVector, DatosEstadisticos datosEstadisticos) {
		
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
	private int N;
	 
	public DatosEstadisticos heapsort(long vector[]){    
		
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
        return datosEstadisticos;
    }
	
	 private void heapify(long vector[], DatosEstadisticos datosEstadisticos){		
		    N = vector.length-1;
	        for (int i = N/2; i >= 0; i--) {
	        	maxheap(vector, i, datosEstadisticos);
	        }
	 }
	 
	 private void maxheap(long vector[], int i, DatosEstadisticos datosEstadisticos){ 
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
	
	
	private void intercambiar(long[] vector, int i, int j, DatosEstadisticos datosEstadisticos) {
		long temporal = vector[i];
		vector[i] = vector[j];
		vector[j] = temporal;
		
		datosEstadisticos.incrementarNumeroIntercambios();
	}
	
	private void imprimirVector(long[] vector) {
		
		int n = vector.length;
		
		System.out.print("[");
		for(int i=0; i<n; i++) {
			System.out.print(vector[i] + ",");
		}
		System.out.print("]");
		System.out.println();
	}
	
	private long[] llenarVector(int num) {
		
		long[] vector = new long[num];
		
		for(int i=1; i<=num; i++) {
			long n = (long) (Math.random() * 999999999999l) + 1;
			//System.out.println("n"+i+ " = " + n);
			vector[i-1] = n;			
		}
		
		return vector;
	}
	
	public long[] getVector() {
		return vector;
	}

	public long[] getVectorBurbuja() {
		return vectorBurbuja;
	}

	public long[] getVectorSeleccion() {
		return vectorSeleccion;
	}

	public long[] getVectorHeap() {
		return vectorHeap;
	}

	public long[] getVectorShell() {
		return vectorShell;
	}
/*
	public long[] getVectorBusquedaSecuencial() {
		return vectorBusquedaSecuencial;
	}

	public long[] getVectorBusquedaBinaria() {
		return vectorBusquedaBinaria;
	}
*/
	public int getN() {
		return N;
	}
	
}


