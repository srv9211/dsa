import java.util.Scanner;
public class PrintEncodings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        String str = sc.nextLine();

        printEncodings(str, 0, "");
    }

    static void printEncodings(String str, int i, String asf) {
        if (i == str.length()) {
            System.out.println(asf);
            return;
        }
        int num = str.charAt(i) - '0';

        if (num == 0) {
            return;
        } else {
            printEncodings(str, i+1, asf+((char)('a'+num-1)));
        }

        if (i != str.length() - 1) {
            num = (num*10) + (str.charAt(i+1) - '0');
            if (num <= 26) {
                printEncodings(str, i+2, asf+((char)('a'+num-1)));
            }
        }

    }
}