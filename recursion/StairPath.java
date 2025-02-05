import java.io.*;
import java.util.*;

public class StairPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> ans = new ArrayList<>();
        getStairPaths(n, ans, "");

        System.out.println("\nStair paths: "+ans);
    }

    static void getStairPaths(int n, List<String> ans, String asf) {
        if (n ==0) {
            ans.add(asf);
            return;
        } else if(n < 0) {
            return;
        }

        getStairPaths(n-1, ans, asf+1);
        getStairPaths(n-2, ans, asf+2);
        getStairPaths(n-3, ans, asf+3);
    }
}