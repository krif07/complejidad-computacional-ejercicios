package com.co.cbg.cp.ejercicios1;

public class Ejercicios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean esPrimo = false;
		
		for(int i=0; i<100; i++) {
			esPrimo = verificarPrimo(i);
			System.out.println(i + " es primo " + esPrimo);
		}
	}
	
	/*1) Hacer una función que reciba un número entero positivo y retorne 
	verdadero si es primo o falso sino.*/
	
	/*
	 * {Pre: num > 0, num E N}
	 * {Post: verificarPrimo = true si num E a los números primos
	 * 		  varificarPrimo = false si num No pertenece a los primos}*/
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
	
	/*Hacer una función que llene un vector (de tamaño N) con números
	enteros aleatorios (puede ser de 4 cifras).*/
	
	/*Hacer una función que llene una matriz de tamaño NxM con números
	aleatorios.*/
	
	/*Hacer una función que reciba 2 matrices de tamaño NxM y MxP
	respectivamente y devuelva otra matriz con la multiplicación de las dos	primeras*/
	

}
