import java.util.*;

public class MinimiseSubsetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter arr size: ");
        int n = sc.nextInt();
        System.out.print("Enter arr: ");
        int[] arr = new int[n];
        int range = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            range += arr[i];
        }

        int ansRec = Integer.MAX_VALUE;
        for (int i = 0; i < range+1; i++) {
            int a = solve(0, arr, i, i, range);
            ansRec = Math.min(a, ansRec);
        }

        int ansMemo = Integer.MAX_VALUE;
        for (int i = 0; i < range+1; i++) {
            int a = solve(0, arr, i, i, range, new int[arr.length+1][range+1]);
            ansMemo = Math.min(a, ansMemo);
        }
        if (ansMemo == ansRec)
            System.out.println("Answers are matching :) Minimum sum is " + ansMemo);
        else
            System.out.println("Answers are not matching.");
    }

    static int solve(int i, int[] arr, int tar, int tarSum, int range, int[][] memo) {
        if (i == arr.length) {
            if (tar == 0) {
                return memo[i][tar] = Math.abs(range - 2*tarSum);
            }
            return memo[i][tar] = Integer.MAX_VALUE;
        }

        if (memo[i][tar] != 0) return memo[i][tar];

        int inc = Integer.MAX_VALUE;
        if (tar - arr[i] >= 0) {
            inc = solve(i+1, arr, tar-arr[i], tarSum, range, memo);
        }
        int exc = solve(i+1, arr, tar, tarSum, range, memo);

        return memo[i][tar] = Math.min(inc, exc);
    }

    static int solve(int i, int[] arr, int tar, int tarSum, int range) {
        if (i == arr.length) {
            if (tar == 0) {
                return Math.abs(range - 2*tarSum);
            }
            return Integer.MAX_VALUE;
        }

        int inc = Integer.MAX_VALUE;
        if (tar - arr[i] >= 0) {
            inc = solve(i+1, arr, tar-arr[i], tarSum, range);
        }
        int exc = solve(i+1, arr, tar, tarSum, range);

        return Math.min(inc, exc);
    }


}