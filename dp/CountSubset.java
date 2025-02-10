import java.util.*;

public class CountSubset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter arr size: ");
        int n = sc.nextInt();
        System.out.print("Enter arr: ");
        int sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        System.out.print("Enter diff of subArrays: ");
        int diff = sc.nextInt();
        int tar = (diff + sum)/2;
        int ans = solve(0, arr, tar);

        System.out.println("Ans: " + ans);
    }

    static int solve(int i, int[] arr, int tar) {
        if (i == arr.length) {
            if (tar == 0) return 1;
            return 0;
        }

        int inc = 0;
        if (tar - arr[i] >= 0) {
            inc = solve(i+1, arr, tar-arr[i]);
        }
        int exc = solve(i+1, arr, tar);

        return inc + exc;
    }
}