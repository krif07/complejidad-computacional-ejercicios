package com.co.cbg.cp.ejercicios2;

public class Busqueda {

	public DatosEstadisticos secuencial(long elemento, long[] datos) {
		
		int n = datos.length;
		
		DatosEstadisticos datosEstadisticos = new DatosEstadisticos();
		datosEstadisticos.setTamVector(n);
		
		for(int i=0; i<n; i++) {
			
			datosEstadisticos.incrementarComparaciones();
			if(elemento==datos[i]) {
				datosEstadisticos.setDatoEncontrado(true);
				datosEstadisticos.imprimirEstadisticos();
				return datosEstadisticos;
			}
		}
		
		datosEstadisticos.setDatoEncontrado(false);
		datosEstadisticos.imprimirEstadisticos();
		
		return datosEstadisticos;
		
	}
	
	public DatosEstadisticos binaria(long elemento, long[] datos) {
		
		int limiteInferior = 0;
		int limiteSuperior = datos.length;
		int medio = 0;
		
		DatosEstadisticos datosEstadisticos = new DatosEstadisticos();
		datosEstadisticos.setTamVector(limiteSuperior);
			
		do {	
			
			medio = (limiteSuperior - limiteInferior) / 2;
			
			datosEstadisticos.incrementarComparaciones();
			if(elemento==datos[medio]) {
				//datosEstadisticos.incrementarComparaciones();
				datosEstadisticos.setDatoEncontrado(true);
				datosEstadisticos.imprimirEstadisticos();
				return datosEstadisticos;
			}
			else if(elemento>datos[medio]) {
				//datosEstadisticos.incrementarComparaciones();
				limiteInferior = medio+1;
			}
			else {
				//datosEstadisticos.incrementarComparaciones();
				limiteSuperior = medio-1;
			}
			
		}while(limiteSuperior>limiteInferior);
		
		datosEstadisticos.setDatoEncontrado(false);
		datosEstadisticos.imprimirEstadisticos();
		return datosEstadisticos;
	}
}
