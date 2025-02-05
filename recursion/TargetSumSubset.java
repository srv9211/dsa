import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class TargetSumSubset {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        String line2 = br.readLine();

        int n = Integer.parseInt(line1);

        int[] arr = new int[n];
        String[] eles = line2.split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(eles[i]);
        }
        int target = Integer.parseInt(br.readLine());

        List<String> al = new ArrayList<>();
        getTargetSumSubset(arr, 0, al ," ", target);

        System.out.println(al);
    }

    static void getTargetSumSubset(int[] arr, int i, List<String> list, String asf, int tar) {
        if (tar == 0) {
            list.add(asf);
            return;
        }
        if (i == arr.length) return;

        getTargetSumSubset(arr, i+1, list, asf+arr[i]+" ", tar-arr[i]);
        getTargetSumSubset(arr, i+1, list, asf, tar);
    }
}