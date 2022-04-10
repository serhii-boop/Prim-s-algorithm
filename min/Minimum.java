package nulp.min;

import nulp.ReadFile;

class Minimum {
    private static final int NUMBER_OF_VERTEX = ReadFile.vertex();

    public static void main(String[] args) {

        Minimum min = new Minimum();
        int[][] graph = ReadFile.matrix();
        ReadFile.printMatrix(graph);
        min.primMinimum(graph);
    }

    int findVertexWithMinKey(int[] key, Boolean[] ifVerticesIncluded) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < NUMBER_OF_VERTEX; v++)
            if (!ifVerticesIncluded[v] && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }


    void printMinTree(int[] parent, int[][] graph) {
        int weight = 0;
        for (int i = 1; i < NUMBER_OF_VERTEX; i++) {
            weight += graph[i][parent[i]];
        }
        System.out.print("Weight of the minimum tree - " + weight);

        System.out.println("Edge \tWeight");
        for (int i = 1; i < NUMBER_OF_VERTEX; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    void primMinimum(int[][] graph) {

        int[] parent = new int[NUMBER_OF_VERTEX];
        int[] minWeightEdge = new int[NUMBER_OF_VERTEX];

        Boolean[] ifVerticesIncluded = new Boolean[NUMBER_OF_VERTEX];

        for (int i = 0; i < NUMBER_OF_VERTEX; i++) {
            minWeightEdge[i] = Integer.MAX_VALUE;
            ifVerticesIncluded[i] = false;
        }

        minWeightEdge[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < NUMBER_OF_VERTEX - 1; count++) {
            int minVertex = findVertexWithMinKey(minWeightEdge, ifVerticesIncluded);
            ifVerticesIncluded[minVertex] = true;

            for (int v = 0; v < NUMBER_OF_VERTEX; v++)
                if (graph[minVertex][v] != 0 && !ifVerticesIncluded[v] && graph[minVertex][v] < minWeightEdge[v]) {
                    parent[v] = minVertex;
                    minWeightEdge[v] = graph[minVertex][v];
                }
        }
        printMinTree(parent, graph);
    }
}