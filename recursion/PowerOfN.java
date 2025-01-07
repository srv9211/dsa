import java.util.Scanner;
public class PowerOfN {
    // find x^n
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input x: ");
        int x = scanner.nextInt();
        System.out.print("Input n: ");
        int n = scanner.nextInt();

        System.out.println("\nAns = " + myPow(x, n));
    }

    static int linearPow(int x, int n) {
        if (n == 0) return 1;

        return x * linearPow(x, n-1);
    }

    static int logPow(int x, int n) {
        if (n == 0) return 1;
        else if (n == 1) return x;

        int ans = logPow(x, n/2);
        if (n%2 == 0) {
            ans *= ans;
        } else {
            ans = ans*ans*x;
        }

        return ans;
    }

    // when n is negative
    static double myPow(double x, int n) {

        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n += 1;
                return 1/(myPow(x, n*-1)*x);
            } else {
                return 1/myPow(x, n*-1);
            }
        } else if (n == 0 || x == 1.0) return 1.0;
        double ans = myPow(x, n/2);
        if (n%2 == 0) return ans*ans;
        return ans*ans*x;
    }

}