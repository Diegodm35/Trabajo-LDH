/*
Refer https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
for better understanding 
 */
package com.thealgorithms.datastructures.graphs;

/**
 *
 * @brief El algortimo de Dijkstra es un algoritmo para encontrar las rutas más cortas entre nodos en un grafo, que puede representar, por ejemplo, redes de carreteras.
 */
class dijkstras {

    int k = 9;

    /**
     * @brief Función para encontrar el vértice con la distancia mínima, de los
     * vértices aún no incluidos en el conjunto de vértices más cortos
     * @param dist Distancia de los vértices
     * @param Set Conjunto de vértices
     * @return El vértice con la distancia mínima
     */
    int minDist(int dist[], Boolean Set[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int r = 0; r < k; r++) {
            if (Set[r] == false && dist[r] <= min) {
                min = dist[r];
                min_index = r;
            }
        }

        return min_index;
    }

    /**
     * @brief Función para imprimir la matriz de distancias
     * @param dist Distancia de los vértices
     */
    void print(int dist[]) {
        System.out.println("Vertex \t\t Distance");
        for (int i = 0; i < k; i++) {
            System.out.println(i + " \t " + dist[i]);
        }
    }
	

    /**
     * @brief Función para encontrar las distancias más cortas de un vértice
     * raiz a todos los otros vértices en un grafo dado con representación de
     * matriz de adyacencia
     * @param graph Matriz de adyacencia
     * @param src Vértice fuente
     */
    void dijkstra(int graph[][], int src) {
        int dist[] = new int[k];
        Boolean Set[] = new Boolean[k];

        for (int i = 0; i < k; i++) {
            dist[i] = Integer.MAX_VALUE;
            Set[i] = false;
        }

        dist[src] = 0;

        for (int c = 0; c < k - 1; c++) {

            int u = minDist(dist, Set);

            Set[u] = true;

            for (int v = 0; v < k; v++) {
                if (!Set[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        print(dist);
    }

    public static void main(String[] args) {
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
        {4, 0, 8, 0, 0, 0, 0, 11, 0},
        {0, 8, 0, 7, 0, 4, 0, 0, 2},
        {0, 0, 7, 0, 9, 14, 0, 0, 0},
        {0, 0, 0, 9, 0, 10, 0, 0, 0},
        {0, 0, 4, 14, 10, 0, 2, 0, 0},
        {0, 0, 0, 0, 0, 2, 0, 1, 6},
        {8, 11, 0, 0, 0, 0, 1, 0, 7},
        {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        dijkstras t = new dijkstras();
        t.dijkstra(graph, 0);
    }//main

}//djikstras

/*
OUTPUT :
Vertex   Distance 
0            0
1            4
2            12
3            19
4            21
5            11
6            9
7            8
8            14
 */
