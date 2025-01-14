import java.util.Scanner;
public class FloodFill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of an array in (n m) form: ");
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] arr = new int[n][m];
        System.out.println("Enter array: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        floodFill(arr, 0, 0, visited, "");
    }

    static void floodFill(int[][] arr, int i, int j, boolean[][] visited, String asf) {
        if (i < 0 || i == arr.length || j == arr[0].length || j < 0 || visited[i][j] || arr[i][j] == 1) {
            return;
        } else if (i == arr.length - 1 && j == arr[0].length - 1) {
            System.out.println(asf);
            return;
        }

        visited[i][j] = true;
        floodFill(arr, i - 1, j, visited, asf+"u");
        floodFill(arr, i + 1, j, visited, asf+"d");
        floodFill(arr, i, j - 1, visited, asf+"l");
        floodFill(arr, i, j + 1, visited, asf+"r");
        visited[i][j] = false;
    }
}