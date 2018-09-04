package com.co.cbg.cp.ejercicios2;

import java.time.Duration;
import java.time.Instant;

public class DatosEstadisticos{
	
	private int tamVector;
	private Long comparaciones;
	private Long numeroIntercabios;
	private Duration timeElapsed;
	private boolean datoEncontrado;
	
	Instant start;
	
	DatosEstadisticos(){
		this.tamVector = 10;
		this.comparaciones = 0L;
		this.numeroIntercabios = 0L;
		this.datoEncontrado = false;
		
		start = Instant.now();
	}
	
	public boolean isDatoEncontrado() {
		return datoEncontrado;
	}

	public void setDatoEncontrado(boolean datoEncontrado) {
		this.datoEncontrado = datoEncontrado;
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
		
		timeElapsed = Duration.between(start, end);
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
	
	public Duration getTimeElapsed(){
		return timeElapsed;
	}
	
}