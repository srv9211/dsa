import java.util.*;

public class SubsequenceString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = sc.nextLine();

        List<String> ans = new ArrayList<>();
        getSubsequences(str, 0, "", ans);
        System.out.println(ans);
    }

    static void getSubsequences(String str, int i, String asf, List<String> ans) {
        if (i == str.length()) {
            ans.add(asf);
            return;
        }

        getSubsequences(str, i+1, asf + str.charAt(i), ans);
        getSubsequences(str, i+1, asf, ans);
    }
}