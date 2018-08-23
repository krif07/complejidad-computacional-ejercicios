package com.co.cbg.cp.ejercicios1;

public class Ejercicios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*boolean esPrimo = false;
		
		
		for(int i=0; i<102; i++) {
			esPrimo = verificarPrimo(i);
			System.out.println((i)+" es primo " + esPrimo);
			System.out.println("Sumatoria1 " + i + " es: " + sumatoriaEnteros(i));
			System.out.println("Sumatoria2 " + i + " es: " + sumatoriaEnteros2(i));			
		}
		
		llenarVector(100);
		
		int[][] m = llenarMatriz(5,4);
		int[][] m2 = llenarMatriz(4,3);
		
		int[][] m3 = multiplicarMatrices(3,3, m, m2);
		
		for(int i=0; i<5; i++) {
			
			System.out.println("-");
			
			for(int j=0; j<4; j++) {
				
				System.out.println(m[i][j]);
				
			}			
		}
		
		*/
		int x = 51;
		//int serie1 = serieFib(x); //1134903170
		
		Long serie2 = fib(x);
		
		System.out.println(" " + serie2);
		
		int num1 = 12;
		int num2 = 14;
		
		minimoComunMultiplo(num1,num2);
		minimoComunMultiploCiclos(num1,num2);
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
		
		int n = (int) Math.sqrt(num) +1;
		
		for(int i=2; i<n; i++) {
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
	
	public static int[] llenarVector2(int num) {
		
		int[] vector = new int[num];
		
		for(int i=1; i<=num; i++) {
			int n = (int) (Math.random() * 9999) + 1;
			//System.out.println("n"+i+ " = " + n);
			vector[i-1] = n;			
		}
		
		return vector;
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
	
	//Complejidad (n al cuadrado) disfrazado
	public static int[][] llenarMatriz2(int n, int m){

		int[][] matriz = new int[n][m];
		
		int i=0;
		int j=0;

		while(i<n) {
			
			int num = (int) (Math.random() * 9999) + 1;
			matriz[i-1][j-1] = num;
			
			if(j < (m-1)) {
				j++;
			}
			else {
				j=0;
				i++;
			}
		}
		
		return matriz;
	}
	
	/*Hacer una función que reciba 2 matrices de tamaño NxM y MxP
	respectivamente y devuelva otra matriz con la multiplicación de las dos	primeras*/
	
	/*
	 * {Pre: n,m y p > 0, n,m y p E N}
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

	//6. Calcular la serie fibonnaci para un número n

	//O(2 a la n)
	public static int serieFib(int n) {
		
		if(n==1) {
			return 0;
		}
		if(n==2) {
			return 1;
		}
		
		return serieFib(n-1) + serieFib(n-2);
		
	}
	
	public static Long fib(int n) {
		

		if(n==1) {
			return 0L;
		}
		
		Long i = 0L;
		Long j = 1L;
		
		Long t;
		
		for(int k=1; k < n-1; k++) {
			
			t = i + j;
			i = j;
			j = t;
		}
		
		return j;
		
	}
	
	public static int minimoComunMultiplo(int num1, int num2) {
		
		int resultado;
		int maximoComunDivisor;
		int minimoComunMultiplo;
		int aux;
		 
		maximoComunDivisor=num1;
		aux=num2;
		
		do{
			resultado=maximoComunDivisor % aux;
			maximoComunDivisor=aux;
			aux=resultado;
		}while(resultado!=0);
		
		minimoComunMultiplo=num1*num2/maximoComunDivisor;
		
		System.out.println("El maximo comum divisor es :" + maximoComunDivisor );
		System.out.println("El minimo comum multiplo es :" + minimoComunMultiplo );
		
		return minimoComunMultiplo;
	}
	
	public static int minimoComunMultiploCiclos(int num1, int num2) {
		
		int minimoComunMultiplo = 1;
		int n = num1;		
		boolean romperCiclo1 = false;
		boolean romperCiclo2 = false;
				
		if(n<num2) {
			n=num2;
		}
		
		for(int i=2; i<=n; i++) {
			
			if(verificarPrimo(i)) {
				//System.out.println("primo: " + i);
				
				do {
					romperCiclo1=true;
					romperCiclo2=true;
					
					//System.out.println("num1%i: " + num1 + "/" + i);
					//System.out.println("num2%i: " + num2 + "/" + i);
					
					if(num1%i == 0) {
						System.out.println("primo1: " + i);
						
						num1 = num1 / i;						
						romperCiclo1 = false; 
					}
					
					if(num2%i == 0) {
						System.out.println("primo2: " + i);
												
						num2 = num2 / i;						
						romperCiclo2 = false;
					}
										
					if(romperCiclo1 && romperCiclo2) {
						break;
					}
					else {
						minimoComunMultiplo *= i;
					}
					
				}while(num1!=1 && num2!=1);
								
			}
						
		}
		
		System.out.println("minimoComunMultiplo: " + minimoComunMultiplo);
		
		return minimoComunMultiplo;
		
	}
}


