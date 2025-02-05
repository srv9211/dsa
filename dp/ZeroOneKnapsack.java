import java.util.Scanner;
import java.util.Arrays;

public class ZeroOneKnapsack {
//    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        System.out.print("Enter weight array: ");
        int[] wt = new int[n];
        int maxWt = 0;
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
            maxWt = Math.max(maxWt, wt[i]);
        }

        System.out.print("Enter value array: ");
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }

        System.out.print("Enter capacity of knapsack: ");
        int cap = sc.nextInt();

        int[][] memo = new int[n][cap+1];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        int memoAns = getMaxProfitMemo(0, wt, val, cap, memo);

        int recAns = getMaxProfitRec(0, wt, val, cap);
        int dpAns = getMaxProfitDp(wt, val, cap);

        if (memoAns != recAns) System.out.println("\nMemo and rec output not matching!!!!!!");
        else if (memoAns == dpAns)  System.out.println("\nAnswers are matching. Max profit is " + memoAns);
    }

    static int getMaxProfitRec(int i, int[] wt, int[] val, int cap) {
        if (i == wt.length) {
            return 0;
        }

        int inc = 0;
        if (cap - wt[i] >= 0)
            inc = getMaxProfitRec(i+1, wt, val, cap-wt[i]) + val[i];

        int notInc = getMaxProfitRec(i+1, wt, val, cap);

        return Math.max(inc, notInc);
    }

    static int getMaxProfitMemo(int i, int[] wt, int[] val, int cap, int[][] memo) {
        if (i == wt.length) {
            return 0;
        }
        else if (memo[i][cap] != -1) {
            return memo[i][cap];
        }

        int inc = 0;
        if (cap - wt[i] >= 0)
            inc = getMaxProfitMemo(i+1, wt, val, cap-wt[i], memo) + val[i];

        int notInc = getMaxProfitMemo(i+1, wt, val, cap, memo);

        return memo[i][cap] = Math.max(inc, notInc);
    }

    static int getMaxProfitDp(int[] wt, int[] val, int cap) {
        int[][] dp = new int[wt.length+1][cap+1];

        for (int j = 0; j < cap+1; j++) dp[wt.length][j] = 0;

        for (int i = wt.length - 1; i >= 0; i--) {
            for (int j = cap; j >= 0; j--) {
                int inc = 0;
                if (j - wt[i] >= 0)
                    inc = dp[i+1][j-wt[i]] + val[i]; //getMaxProfitRec(i+1, wt, val, j-wt[i]) + val[i];

                int notInc = dp[i+1][j]; //getMaxProfitRec(i+1, wt, val, cap);

                dp[i][j] = Math.max(inc, notInc);
            }
        }

        return dp[0][cap];
    }
}