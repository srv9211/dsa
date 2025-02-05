import java.util.Scanner;

public class JosephusProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
//        int ans = getLastPersonAliveIteration(n, k);
        boolean[] died = new boolean[n];
//        int ans = getLastPersonAliveRec(0, k, 1, n, died, 0);
        int ans = solve(n, k);
        System.out.println("Last person to live: " + ans);
    }

    static int solve(int n, int k) {
        if (n == 1) return 0;

        int ans = solve(n-1, k);

        return (k + ans) % n;
    }

    static int getLastPersonAliveRec(int i, int k, int curr, int n, boolean[] died, int diedCount) {
        i %= n;

        if (died[i]) {
            return getLastPersonAliveRec(i + 1, k, curr, n, died, diedCount);
        } else if (curr == k) {
            if (diedCount == n-1) return i;
            died[i] = true;
            return getLastPersonAliveRec(i + 1, k, 1, n, died, diedCount + 1);
        } else {
            return getLastPersonAliveRec(i + 1, k, curr + 1, n, died, diedCount);
        }
    }

    static int getLastPersonAliveIteration(int n, int k) {
        int i = 0;
        int j = k;
        boolean[] died = new boolean[n];
        int diedCount = 0;
        while(true) {
            i = i % n;
            if (died[i]) {
                i++;
                continue;
            }
            j--;
            if (j == 0) {
                if (diedCount == n-1) return i;
                j = k;
                died[i] = true;
                diedCount++;
            }
            i++;
        }
    }
}