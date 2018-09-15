package com.co.cbg.cp.ejerciof;

/**
 *
 * @author Cristian Dávila
 */
public class NodoGrafo {

    public int vertice;
    public int pesoArista;
    public NodoGrafo sgte;

    public NodoGrafo(int v, int a) {
        this.vertice = v;
        this.pesoArista = a;
        this.sgte = null;
    }

    private boolean visited = false;
    private int distancia = Integer.MAX_VALUE;

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    
}