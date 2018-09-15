package com.co.cbg.cp.ejerciof;
import com.co.cbg.cp.ejerciof.NodoGrafo;

/**
 *
 * @author Cristian Dávila
 */
public class Grafo {

    private NodoGrafo grafo[];
    private int nroVertices;
    

    public Grafo(int nroVertices) {
        this.nroVertices = nroVertices;
        grafo = new NodoGrafo[this.nroVertices];

        for (int i = 0; i < this.nroVertices; i++) {
            grafo[i] = null;
        }
    }

    public boolean existeArista(int v1, int v2) {
        if (grafo[v1] == null) {
            return false;
        }
        NodoGrafo actual = grafo[v1];
        while(actual != null) {
            if(actual.vertice == v2) {
                return true;
            }
            actual = actual.sgte;
        }
        return false;
    }

    public void insertaArista(int v1, int v2, int peso) {

        if (!existeArista(v1, v2)) {
            NodoGrafo nuevo = new NodoGrafo(v2, peso);

            if (grafo[v1] == null) {
                grafo[v1] = nuevo;
            } else {
                NodoGrafo actual = grafo[v1];
                while (actual.sgte != null) {
                    actual = actual.sgte;
                }

                actual.sgte = nuevo;
            }
        } else {
            System.out.println("Ya existe una arista entre:" + v1 + " y " + v2);
        }
    }

    public void eliminarArista(int v1, int v2) {
        if (existeArista(v1, v2)) {
            NodoGrafo actual = grafo[v1];

            if (actual.vertice == v2) {
                grafo[v1] = actual.sgte;
            } else {
                NodoGrafo anterior = actual;
                actual = actual.sgte;

                while (actual != null) {
                    if (actual.vertice == v2) {
                        anterior.sgte = actual.sgte;
                        return;
                    }
                    anterior = actual;
                    actual = actual.sgte;
                }
            }
        } else {
            System.out.println("No existe una arista entre: " + v1 + " y " + v2);
        }
    }

    public void liberaGrafo() {
        for (int i = 0; i < grafo.length; i++) {
            grafo[i] = null;
        }
    }

    public void mostrarGrafo() {
        for (int i = 0; i < grafo.length; i++) {
            NodoGrafo actual = grafo[i];

            while (actual != null) {
                System.out.printf("%d -> ", i);
                System.out.printf("%d(%d)\n", actual.vertice, actual.pesoArista);

                actual = actual.sgte;
            }
            System.out.println();
        }
    }

//Listas de adyacencia
    public boolean listaAdyVacia(int v) {
        if(grafo[v] == null) {
            return true;
        }
        return false;
    }

    public NodoGrafo getPrimerAd(int v) {
        return grafo[v];
    }

    public NodoGrafo nextAdy(NodoGrafo anterior) {
        if (anterior.sgte == null) {
            return null;
        } else {
            return anterior.sgte;
        }
    }
    
    public void dijkstra(Grafo g,int nroNodos){
        
    }

}
