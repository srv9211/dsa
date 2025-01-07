import java.util.*;

public class PrintNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your input: ");
        int n = scanner.nextInt();
        System.out.println();

//        printNumbersAsc(n);
//        printNumbersDes(n);
        printNumbersAscDes(n);
    }

    static void printNumbersAsc(int n) {
        if (n == 0) return;

        printNumbersAsc(n-1);
        System.out.println(n);
    }

    static void printNumbersDes(int n) {
        if (n == 0) return;

        System.out.println(n);
        printNumbersDes(n-1);
    }

    static void printNumbersAscDes(int n) {
        if (n == 0) return;

        System.out.println(n);
        printNumbersAscDes(n-1);
        System.out.println(n);
    }
}