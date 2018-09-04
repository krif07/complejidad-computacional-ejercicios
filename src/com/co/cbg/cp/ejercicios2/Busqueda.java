package com.co.cbg.cp.ejercicios2;

public class Busqueda {

	public DatosEstadisticos secuencial(long elemento, long[] datos) {

		int n = datos.length;

		DatosEstadisticos datosEstadisticos = new DatosEstadisticos();
		datosEstadisticos.setTamVector(n);

		for (int i = 0; i < n; i++) {

			datosEstadisticos.incrementarComparaciones();
			if (elemento == datos[i]) {
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

			if (elemento == datos[medio]) {
				// datosEstadisticos.incrementarComparaciones();
				datosEstadisticos.setDatoEncontrado(true);
				datosEstadisticos.imprimirEstadisticos();

				System.out.println("---------------------elementoE " + elemento);
				return datosEstadisticos;
			} else if (elemento > datos[medio]) {
				// datosEstadisticos.incrementarComparaciones();
				limiteInferior = medio + 1;
			} else {
				// datosEstadisticos.incrementarComparaciones();
				limiteSuperior = medio - 1;
			}

			System.out.println("---------------------limiteSuperior " + limiteSuperior);
			System.out.println("---------------------medio " + medio);
			System.out.println("---------------------limiteInferior " + limiteInferior);

		} while (limiteSuperior > limiteInferior);

		datosEstadisticos.setDatoEncontrado(false);
		datosEstadisticos.imprimirEstadisticos();
		return datosEstadisticos;
	}

	public DatosEstadisticos busquedaBinaria(long dato, long vector[]) {
		
		int n = vector.length;
		int centro, inf = 0, sup = n - 1;
		
		DatosEstadisticos datosEstadisticos = new DatosEstadisticos();
		datosEstadisticos.setTamVector(n);

		while (inf <= sup) {
			centro = (sup + inf) / 2;
			
			datosEstadisticos.incrementarComparaciones();
			
			if (vector[centro] == dato) {
				
				datosEstadisticos.setDatoEncontrado(true);
				datosEstadisticos.imprimirEstadisticos();
				
				return datosEstadisticos;
				//return centro;
			}
			else if (dato < vector[centro]) {
				sup = centro - 1;
			} else {
				inf = centro + 1;
			}

		}
		
		//return -1;
		datosEstadisticos.setDatoEncontrado(false);
		datosEstadisticos.imprimirEstadisticos();
		return datosEstadisticos;
	}
}
