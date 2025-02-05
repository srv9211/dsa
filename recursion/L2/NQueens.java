import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class NQueens {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        boolean[] vertical = new boolean[n];
        boolean[] rightDiagonal = new boolean[2*n-1];
        boolean[] leftDiagonal = new boolean[2*n-1];

        nQueens(0, vertical, rightDiagonal, leftDiagonal, "", 0);
    }

    static void nQueens(int i, boolean[] vertical, boolean[] rightDiagonol, boolean[] leftDiagonol, String asf, int qPlaced) {
        if (i == vertical.length) {
            if (qPlaced == vertical.length) System.out.println(asf+"\n");;
            return;
        }

        for (int j = 0; j < vertical.length; j++) {
            if (!vertical[j] && !rightDiagonol[i-j+vertical.length-1] && !leftDiagonol[i+j]) {
                vertical[j] = true;
                rightDiagonol[i-j+vertical.length-1] = true;
                leftDiagonol[i+j] = true;
                nQueens(i+1, vertical, rightDiagonol, leftDiagonol, asf + "["+i+", "+j+"], ", qPlaced+1);
                vertical[j] = false;
                rightDiagonol[i-j+vertical.length-1] = false;
                leftDiagonol[i+j] = false;
            }
        }
    }

}



//00 01 02 03
//10 11 12 13
//20 21 22 23
//30 31 32 33
