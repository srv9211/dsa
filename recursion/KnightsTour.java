import java.util.Scanner;


public class KnightsTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        int i = sc.nextInt(), j = sc.nextInt();

        printKnightsTour(i, j, arr, 1);
    }

    static void printKnightsTour(int i, int j, int[][] arr, int leftCells) {
        if (leftCells == arr.length * arr.length + 1) {
            for (int p = 0; p < arr.length; p++) {
                for (int q = 0; q < arr.length; q++) {
                    System.out.print(arr[p][q] + " ");
                }
                System.out.println();
            }
            System.out.println("\n\n===================================\n\n");
            return;
        }

        if (i < 0 || j < 0 || i >= arr.length || j >= arr.length || arr[i][j] != 0) return;

        arr[i][j] = leftCells;
        printKnightsTour(i-2, j+1, arr, leftCells+1);
        printKnightsTour(i-2, j-1, arr, leftCells+1);
        printKnightsTour(i+2, j-1, arr, leftCells+1);
        printKnightsTour(i+2, j+1, arr, leftCells+1);
        printKnightsTour(i-1, j-2, arr, leftCells+1);
        printKnightsTour(i+1, j-2, arr, leftCells+1);
        printKnightsTour(i-1, j+2, arr, leftCells+1);
        printKnightsTour(i+1, j+2, arr, leftCells+1);
        arr[i][j] = 0;

    }
}