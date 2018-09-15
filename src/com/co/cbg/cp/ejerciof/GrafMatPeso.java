package com.co.cbg.cp.ejerciof;

public class GrafMatPeso {

	public static int INFINITO = 0xFFFF;
	private int[][] matPeso;
	private Vertice[] verts;
	private int numVerts;
	
	public GrafMatPeso(int mx) {
		matPeso = new int[mx][mx];
		verts = new Vertice[mx];
		
		for(int i=0; i<mx; i++) {
			for(int j=0; j<mx; j++) {
				matPeso[i][j]=INFINITO;
			}
		}
		numVerts=0;
	}
	
	public void nuevoVertice(String nom) {
		boolean esta = numVertice(nom)>=0;
		
		if(!esta) {
			Vertice v = new Vertice(nom);
			v.asigVert(numVerts);
			verts[numVerts++] = v;
		}
	}
	
	public int pesoArco(String a, String b) {
		int va, vb;
		va = numVertice(a);
		vb = numVertice(b);
		return matPeso[va][vb];
	}
	
	public int numeroDeVertices() {
		return numVerts;
	}
	
	public Vertice[] vertices() {
		return verts;
	}
	
	public void nuevoArco(String a, String b, int peso) {
		
		int va, vb;
		va = numVertice(a);
		vb = numVertice(b);
		matPeso[va][vb] = peso;
	}
	
	public int numVertice(String vs) {
		Vertice v = new Vertice(vs);
		boolean encontrado = false;
		int i = 0;
		
		for(; (i<numVerts) && !encontrado;) {
			encontrado = verts[i].equals(v);
			if(!encontrado) {
				i++;
			}
		}
		return (i<numVerts) ? i : -1; 
	}
	
	public int[][] getMatPeso(){
		return matPeso;
	}
}
