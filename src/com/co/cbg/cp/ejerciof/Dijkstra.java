package com.co.cbg.cp.ejerciof;

import com.co.cbg.cp.ejerciof.GrafMatPeso;

public class Dijkstra {

    private int[][] Pesos;
    private int[] ultimo;
    private int[] D;
    private boolean[] F;
    private int s, n; // vértice origen y número de vértices

    public Dijkstra(GrafMatPeso gp, int origen) {
        n = gp.numeroDeVertices();
        s = origen;
        Pesos = gp.getMatPeso();//gp.matPeso;
        ultimo = new int[n];
        D = new int[n];
        F = new boolean[n];
    }

    public void caminoMinimos() {
//valores iniciales
        for (int i = 0; i < n; i++) {
            F[i] = false;
            D[i] = Pesos[s][i];
            ultimo[i] = s;
        }
        F[s] = true;
        D[s] = 0;
//Pasos para marcar los n-1 vértices
        for (int i = 1; i < n; i++) {
            int v = minimo();
            // selecciona vértice no marcado de menor distancia
            F[v] = true;
//actualiza distancia de vértices no marcados
            for (int w = 1; w < n; w++) {
                if (!F[w]) {
                    if ((D[v] + Pesos[v][w]) < D[w]) {
                        D[w] = D[v] + Pesos[v][w];
                        ultimo[w] = v;
                    }
                }
            }
        }
    }

    private int minimo() {
        int mx = GrafMatPeso.INFINITO;
        int v = 1;
        for (int j = 1; j < n; j++) {
            if (!F[j] && (D[j] <= mx)) {
                mx = D[j];
                v = j;
            }
        }
        return v;
    }
}
