import java.util.Scanner;
public class ArrayProblems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter array elements with a space gap: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println();
//        printArrayForward(arr, 0);
//        printArrayBackward(arr, 0);
        System.out.println("Index of ele: " + findElement(arr, 5, 0));
    }

    static void printArrayForward(int[] arr, int i) {
        if (i == arr.length) return;

        System.out.println(arr[i]);
        printArrayForward(arr, i+1);
    }

    static void printArrayBackward(int[] arr, int i) {
        if (i == arr.length) return;

        printArrayBackward(arr, i+1);
        System.out.println(arr[i]);
    }

    static int findElement(int[] arr, int ele, int i) {
        if (i == arr.length) return -1;
        else if (arr[i] == ele) return i;
        return findElement(arr, ele, i+1);
    }
}