package nulp.max;

import nulp.ReadFile;

class Maximum {

    public static void main(String[] args)  {
        int[][] graph = ReadFile.matrix();
        ReadFile.printMatrix(graph);
        maximumTree(ReadFile.matrix(), ReadFile.vertex());
    }

    static int findMaxVertex(boolean[] ifVerticesIncluded, int[] weights, int V) {


        int index = -1;
        int maxWeight = Integer.MIN_VALUE;

        for (int i = 0; i < V; i++) {

            if (!ifVerticesIncluded[i] && weights[i] > maxWeight) {

                maxWeight = weights[i];
                index = i;
            }
        }
        return index;
    }

    static void printMaximumSpanningTree(int[][] graph, int[] parent, int V) {

        int weight = 0;
        for (int i = 1; i < V; i++) {
            weight += graph[i][parent[i]];
        }

        System.out.println("Weight of the maximum tree " + weight);
        System.out.println();
        System.out.println("Edges \tWeight");

        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + " \t"
                    + graph[i][parent[i]]);
        }
    }

    static void maximumTree(int[][] graph, int V) {


        boolean[] visited = new boolean[V];
        int[] weights = new int[V];
        int[] parent = new int[V];

        for (int i = 0; i < V; i++) {
            visited[i] = false;
            weights[i] = Integer.MIN_VALUE;
        }

        weights[0] = Integer.MAX_VALUE;
        parent[0] = -1;

        for (int i = 0; i < V - 1; i++) {

            int maxVertexIndex = findMaxVertex(visited, weights, V);
            visited[maxVertexIndex] = true;

            for (int j = 0; j < V; j++) {
                if (graph[j][maxVertexIndex] != 0 && !visited[j]) {
                    if (graph[j][maxVertexIndex] > weights[j]) {
                        weights[j] = graph[j][maxVertexIndex];
                        parent[j] = maxVertexIndex;
                    }
                }
            }
        }

        printMaximumSpanningTree(graph, parent, V);
    }
}
