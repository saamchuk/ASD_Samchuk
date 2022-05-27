package com.company;

public class lab_9 {
    public int minDistance(int[] dist, Boolean[] b){
        int min = Integer.MAX_VALUE, index = -1;
        for (int x = 0; x < 6; x++) {
            if (!b[x] && dist[x] <= min) {
               min = dist[x];
               index = x;
            }
        }
        return index;
    }
    public void printGraph (int[] dist, int src) {
        System.out.println("Відстань від веришини " + symbol(src) + " до вершини:");
        for(int i = 0; i < 6; i++) {
            System.out.println(symbol(i) + " ----- " + dist[i]);
        }
    }
    public String symbol (int i) {
        if (i == 0) return "a";
        if (i == 1) return "b";
        if (i == 2) return "c";
        if (i == 3) return "d";
        if (i == 4) return "e";
        if (i == 5) return "f";
        return " ";
    }
    public void dijkstra(int[][] graph, int src) {
        int[] dist = new int[6];
        Boolean[] b = new Boolean[6];
        for(int i = 0; i < 6; i++){
            dist[i] = Integer.MAX_VALUE;
            b[i] = false;
        }
        dist[src] = 0;
        for (int count = 0; count < 6; count++) {
            int u = minDistance(dist, b);
            b[u] = true;
            for (int x = 0; x < 6; x++) {
                if(!b[x] && graph[u][x] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][x] < dist[x]) {
                    dist[x] = dist[u] + graph[u][x];
                }
            }
        }
        printGraph(dist, src);
    }

    public static void main (String[] args) {
        int[][] graph = new int[][] {{0,1,0,1,0,0},
                {1,0,0,1,1,1},
                {0,0,0,1,1,1},
                {1,1,1,0,0,0},
                {0,1,1,0,0,0},
                {0,1,1,0,0,0}};
        lab_9 p = new lab_9();
        p.dijkstra(graph, 0);
        p.dijkstra(graph, 1);
        p.dijkstra(graph, 2);
        p.dijkstra(graph, 3);
        p.dijkstra(graph, 4);
        p.dijkstra(graph, 5);
    }

}
