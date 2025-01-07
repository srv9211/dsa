import java.util.Scanner;
public class Factorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please provide the input: ");
        int n = scanner.nextInt();
        System.out.println();
        System.out.println("Factorial of " + n + " = " + factorial(n));
    }

    static int factorial(int n) {
        if (n == 0) return 1;

        return n * factorial(n-1);
    }
}