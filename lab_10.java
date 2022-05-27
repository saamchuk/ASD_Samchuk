package com.company;

public class lab_10 {
    public int minDistance(int[] dist, Boolean[] b){
        int min = Integer.MAX_VALUE, index = -1;
        for (int x = 0; x < 16; x++) {
            if (!b[x] && dist[x] <= min) {
                min = dist[x];
                index = x;
            }
        }
        return index;
    }
    public void printGraph (int[] dist, int src) {
        System.out.println("Відстань від веришини " + symbol(src) + " до вершини:");
        for(int i = 0; i < 16; i++) {
            System.out.print(symbol(i) + " ----- ");
            if (dist[i] > 200000) System.out.println("не існує");
            else System.out.println(dist[i]);
        }
    }
    public String symbol (int i) {
        if (i == 0) return "a";
        if (i == 1) return "b";
        if (i == 2) return "c";
        if (i == 3) return "d";
        if (i == 4) return "e";
        if (i == 5) return "f";
        if (i == 6) return "g";
        if (i == 7) return "h";
        if (i == 8) return "i";
        if (i == 9) return "j";
        if (i == 10) return "k";
        if (i == 11) return "l";
        if (i == 12) return "m";
        if (i == 13) return "n";
        if (i == 14) return "o";
        if (i == 15) return "p";
        return " ";
    }
    public void dijkstra(int[][] graph, int src) {
        int[] dist = new int[16];
        Boolean[] b = new Boolean[16];
        for(int i = 0; i < 16; i++){
            dist[i] = Integer.MAX_VALUE;
            b[i] = false;
        }
        dist[src] = 0;
        for (int count = 0; count < 16; count++) {
            int u = minDistance(dist, b);
            b[u] = true;
            for (int x = 0; x < 16; x++) {
                if(!b[x] && graph[u][x] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][x] < dist[x]) {
                    dist[x] = dist[u] + graph[u][x];
                }
            }
        }
        printGraph(dist, src);
    }

    public static void main (String[] args) {
        int[][] graph = new int[][] {{0,4,2,3,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0},
                {0,0,0,3,0,3,0,0,0,0,0,0,0,0,0,0},
                {0,1,0,0,0,0,3,0,0,0,0,0,0,0,0,0},
                {0,0,2,0,0,3,0,4,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,3,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,2,0,0,5,0,0,0,0,0,0},
                {0,5,0,0,0,0,0,0,0,0,6,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,6,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,7,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,7},
                {0,0,0,0,0,0,0,0,0,0,0,3,0,0,3,3},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},};
        lab_10 p = new lab_10();
        p.dijkstra(graph, 0);
        p.dijkstra(graph, 1);
        p.dijkstra(graph, 2);
        p.dijkstra(graph, 3);
        p.dijkstra(graph, 4);
        p.dijkstra(graph, 5);
        p.dijkstra(graph, 6);
        p.dijkstra(graph, 7);
        p.dijkstra(graph, 8);
        p.dijkstra(graph, 9);
        p.dijkstra(graph, 10);
        p.dijkstra(graph, 11);
        p.dijkstra(graph, 12);
        p.dijkstra(graph, 13);
        p.dijkstra(graph, 14);
        p.dijkstra(graph, 15);
    }

}