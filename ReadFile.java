package nulp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ReadFile {

    static Scanner sc;

    static {
        try {
            sc = new Scanner(new BufferedReader(new FileReader("src/nulp/l1-1.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static int V = Integer.parseInt(sc.nextLine().trim().split(" ")[0]);

    public ReadFile() throws FileNotFoundException {
    }



    public static int[][] matrix() {

        int[][] array = new int[V][V];
        while (sc.hasNextLine()) {
            for (int i = 0; i < V; i++) {
                String[] lines = sc.nextLine().trim().split(" ");
                for (int j = 0; j < lines.length; j++){
                    array[i][j] = Integer.parseInt(lines[j]);
                }
            }
        }
        return array;
    }

    public static int vertex(){
        return V;
    }

    public static void printMatrix(int[][] array) {
        for (int[] row : array)
            System.out.println(Arrays.toString(row));
    }
}
