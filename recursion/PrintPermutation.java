import java.io.*;
import java.lang.StringBuilder;


public class PrintPermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter an input: ");
        String str = br.readLine();
        System.out.println();

        StringBuilder sb = new StringBuilder(str);

        getPermutations(sb, "");
    }

    static void getPermutations(StringBuilder sb, String asf) {
        if (sb.length() == 0) {
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < sb.length(); i++) {
            StringBuilder temp = new StringBuilder(sb);

            char ch = sb.charAt(i);
            getPermutations(temp.deleteCharAt(i), asf+ch);

        }
    }
}