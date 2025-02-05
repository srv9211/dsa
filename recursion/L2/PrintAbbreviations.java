import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.StringBuilder;
import java.io.IOException;

public class PrintAbbreviations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        br.close();
        System.out.println("\n\nOutput:\n");
//        printAbbs(s, 0, new StringBuilder(""));

        printAbbs(s, 0, 0, "");
    }

    static void printAbbs(String s, int i, int count, String asf) {
        if (s.length() == i) {
            if (count != 0) asf += count;
            System.out.println(asf);
            return;
        }

        if (count != 0) printAbbs(s, i+1, 0, asf+count+s.charAt(i));
        else printAbbs(s, i+1, 0, asf+s.charAt(i));

        printAbbs(s, i+1, count+1, asf);
    }

    //    static void printAbbs(String s, int i, StringBuilder asf) {
    //        if (i == s.length()) {
    //            System.out.println(asf.toString());
    //            return;
    //        }
    //
    //        asf.append(s.charAt(i));
    //        printAbbs(s, i + 1, asf);
    //        asf = asf.deleteCharAt(asf.length() - 1);
    //        if (asf.length() != 0 && Character.isDigit(asf.charAt(asf.length() - 1))) {
    ////            System.out.println(asf.charAt(i-1) - '0' + 1);
    //            asf.append(asf.charAt(asf.length() - 1) - '0' + 1);
    //            asf = asf.deleteCharAt(asf.length() - 2);
    //            printAbbs(s, i + 1, asf);
    //            asf.append(asf.charAt(asf.length() - 1) - '0' - 1);
    //            asf = asf.deleteCharAt(asf.length() - 2);
    //        } else {
    ////            System.out.println("game");
    //            asf.append("1");
    //            printAbbs(s, i + 1, asf);
    //            asf = asf.deleteCharAt(asf.length() - 1);
    //        }
    //    }
}