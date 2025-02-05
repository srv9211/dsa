import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class NQueens {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        nQueens(0, "", n, new boolean[n][n]);
    }

    static void nQueens(int i, String asf, int leftQ, boolean[][] arr) {
        if (i == arr.length) {
            if (leftQ == 0) System.out.println(asf);
            return;
        }

        for (int col = 0; col < arr.length; col++) {
            if (isQueenSafe(i, col, arr)) {
                arr[i][col] = true;
                nQueens(i+1, asf+"["+i+", "+col+"], ", leftQ-1, arr);
                arr[i][col] = false;
            }
        }
    }

    static boolean isQueenSafe(int i, int j, boolean[][] arr) {
        for (int k = i-1, l = j-1; k >= 0 && l >= 0; k--,l--) {
            if (arr[k][l]) {
                return false;
            }
        }
        for (int k = i-1, l = j+1; k >= 0 && l < arr.length; k--,l++) {
            if (arr[k][l]) {
                return false;
            }
        }
        for (int k = i-1, l = j; k >= 0; k--) {
            if (arr[k][l]) {
                return false;
            }
        }
        return true;
    }
}