import java.util.*;

public class SubsetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of arr: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter arr: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int tar = sc.nextInt();
        System.out.println();
        int ansRec = countTargetSubArrays(0, arr, tar, "");

        int ansMemo = countTargetSubArraysMemo(0, arr, tar, new int[n][tar+1]);
        int ansDp = countTargetSubArraysDp(arr, tar);
        if (ansRec == ansMemo && ansDp == ansRec)
            System.out.println("\nAns are matching, Total no. of subarrays: " + ansRec);
        else
            System.out.println("\nAns are not matching");
//        System.out.println("\nTotal no. of subarrays: " + ansRec);
    }

    static int countTargetSubArraysMemo(int i, int[] arr, int tar, int[][] memo) {
        if (tar == 0) {
            return 1;
        } else if (i == arr.length) {
            return 0;
        }

        if (memo[i][tar] != 0) return memo[i][tar];

        int inc = 0;
        if (tar - arr[i] >= 0) {
            inc = countTargetSubArraysMemo(i+1, arr, tar - arr[i], memo);
        }

        int exc = countTargetSubArraysMemo(i+1, arr, tar, memo);

        return memo[i][tar] = inc + exc;
    }

    static int countTargetSubArrays(int i, int[] arr, int tar, String asf) {
        if (tar == 0) {
            System.out.println(asf);
            return 1;
        } else if (i == arr.length) {
            return 0;
        }

        int inc = 0;
        if (tar - arr[i] >= 0) {
            inc = countTargetSubArrays(i+1, arr, tar - arr[i], asf+arr[i]+" ");
        }

        int exc = countTargetSubArrays(i+1, arr, tar, asf);

        return inc + exc;
    }

    static int countTargetSubArraysDp(int[] arr, int tar) {
        int[][] dp = new int[arr.length+1][tar+1];

        for (int[] a : dp) Arrays.fill(a, -1);

        for (int j = 0; j <= tar; j++) dp[arr.length][j] = 0;
        for (int i = 0; i <= arr.length; i++) dp[i][0] = 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j <= tar; j++) {
                int inc = 0;
                if (j - arr[i] >= 0) {
                    inc = dp[i+1][j - arr[i]];
//                    inc = countTargetSubArrays(i+1, arr, j - arr[i]);
                }
                int exc = dp[i+1][j];
//                int exc = countTargetSubArrays(i+1, arr, tar);
                dp[i][j] = inc + exc;
            }
        }
        return dp[0][tar];
    }
}