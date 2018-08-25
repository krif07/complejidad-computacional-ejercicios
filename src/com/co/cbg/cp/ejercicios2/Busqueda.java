package com.co.cbg.cp.ejercicios2;

public class Busqueda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public boolean secuencial(Long elemento, Long[] datos, int n) {
		
		for(int i=0; i<n; i++) {
			if(elemento==datos[i]) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean binaria(Long elemento, Long[] datos, int n) {
		
		int limiteInferior = 0;
		int limiteSuperior = n;
		int medio = 0;
		
	//for(int i=limiteInferior; i<limiteSuperior; i++) {
			
		do {	
			
			medio = (limiteSuperior - limiteInferior) / 2;
			
			if(elemento==datos[medio]) {
				return true;
			}
			else if(elemento>datos[medio]) {
				limiteInferior = medio+1;
			}
			else {
				limiteSuperior = medio-1;
			}
			
		}while(limiteSuperior>limiteInferior);
		
		return false;
	}
}
