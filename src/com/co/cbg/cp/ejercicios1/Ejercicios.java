package com.co.cbg.cp.ejercicios1;

public class Ejercicios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean esPrimo = false;
		
		for(int i=0; i<100; i++) {
			esPrimo = verificarPrimo(i);
			System.out.println(i + " es primo " + esPrimo);
			System.out.println("Sumatoria1 " + i + " es: " + sumatoriaEnteros(i));
			System.out.println("Sumatoria2 " + i + " es: " + sumatoriaEnteros2(i));			
		}
		
		llenarVector(100);
		
		int[][] m = llenarMatriz(5,4);
		
		for(int i=0; i<5; i++) {
			
			System.out.println("-");
			
			for(int j=0; j<4; j++) {
				
				System.out.println(m[i][j]);
				
			}			
		}
		
	}
	
	/*1) Hacer una función que reciba un número entero positivo y retorne 
	verdadero si es primo o falso sino.*/
	
	/*
	 * {Pre: num > 0, num E N}
	 * {Post: verificarPrimo = true si num E a los números primos
	 * 		  varificarPrimo = false si num No pertenece a los primos}*/
	/* Complejidad: 
	 * O(num)
	 * 						
	 * */
	public static boolean verificarPrimo(int num) {
		
		//Recorrer de 1 a num
		//Dividir num entre i, si la división da residuo 0 no es primo y sale
		//                     sino continua
		
		if(num < 2) {
			return false;
		}
		
		for(int i=2; i<num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	/*2) Hacer una función que reciba un valor N y retorne la sumatoria de los
	enteros hasta N.*/
	
	/*
	 * {Pre: num E N, num > 0 }
	 * {Pos: sumatoriaEnteros = devuelve la sumatoria entera de 1 hasta num}
	 * {Pos: sumatoriaEnteros2 = devuelve la sumatoria de los enteros hasta num}
	 * */
	/*
	 * Complejidad: 
	 * 
	 * O(num)
	 * O(1)
	 * 
	 * */
	
	public static int sumatoriaEnteros(int num) {
		
		int suma = 0;
		
		for(int i=1; i<=num; i++) {
			suma += i; 
		}
		
		return suma;
	}
	
	public static int sumatoriaEnteros2(int num) {
		
		return ( num * (num + 1) ) / 2;
	}
	
	/*Hacer una función que llene un vector (de tamaño N) con números
	enteros aleatorios (puede ser de 4 cifras).*/
	
	/*
	 * {Pre: num E N, num > 0}
	 * {Pos: llenarVector = vector con números enteros aleatorios}
	 * */
	/*
	 * Complejidad: 
	 * 
	 * O(num)
	 * 
	 * */
	
	public static void llenarVector(int num) {
		
		int[] vector = new int[num];
		
		for(int i=1; i<=num; i++) {
			int n = (int) (Math.random() * 9999) + 1;
			System.out.println("n"+i+ " = " + n);
			vector[i-1] = n;			
		}
		
		System.out.println("Vector: " + vector);
	}
			
	/*Hacer una función que llene una matriz de tamaño NxM con números
	aleatorios.*/
	
	/*
	 * {Pre: n y m > 0, n y m E N}
	 * {Pos: llenarMatriz = matriz de tamaño nxm con números enteros aleatorios}
	 * */
	/*
	 * Complejidad: 
	 * 
	 * O(n al cuadrado)
	 * 
	 * */
	
	//n: filas, m: columnas
	public static int[][] llenarMatriz(int n, int m) {
		
		int[][] matriz = new int[n][m];
		
		for(int i=1; i<=n; i++) {
			
			for(int j=1; j<=m; j++) {
				
				int num = (int) (Math.random() * 9999) + 1;
				matriz[i-1][j-1] = num;
				
			}
		}
		
		return matriz;
	}
	
	/*Hacer una función que reciba 2 matrices de tamaño NxM y MxP
	respectivamente y devuelva otra matriz con la multiplicación de las dos	primeras*/
	
	/*
	 * {Pre: n,m y p > 0, n,m y p E N, n = p}
	 * {Pos: multiplicarMatrices = multiplicación de las matrices}
	 * */
	/*
	 * Complejidad: 
	 * */
	
	public static int[][] multiplicarMatrices(int tamFila, int tamCol, int[][] matriz1, int[][] matriz2){
		
		//int tamFila = 5;
		//int tamCol = 4;
		int totalFilaCol = 0;
		
		int[][] matrizResultado = new int[tamFila][tamCol];
		
		for(int fila=0; fila<tamFila; fila++) {
						
			for(int col=0; col<tamCol; col++) {
						
				//totalFilaCol += matriz1[fila][col] * matriz2[col][fila];
				matrizResultado[fila][col] = multiplicarFilaColumna(tamCol, fila, col, matriz1, matriz2); 
				
			}
		}
		
		return matrizResultado;
	}
	
	public static int multiplicarFilaColumna(int tamCol, int fila, int col, int[][] matriz1, int[][] matriz2) {
		
		int resultado = 0;
		
		for(int i=0; i<tamCol; i++) {
			resultado += matriz1[fila][i] * matriz2[i][col];
		}
		
		return resultado;
	}

}
