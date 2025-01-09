import java.util.*;

public class PhoneKeypad {
    public static void main(String[] args) {
        String[] keypad = {" ", ".,", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter keys: ");
        String str = sc.nextLine();

        List<String> ans = new ArrayList<>();
        getPossibleOutcomes(str, 0, keypad, "", ans);
        System.out.println(ans);
    }

    static void getPossibleOutcomes(String str, int i, String[] keypad, String asf, List<String> ans) {
        if (i == str.length()) {
            ans.add(asf);
            return;
        }

        int key = str.charAt(i) - '0';
        for (int j = 0; j < keypad[key].length(); j++) {
            getPossibleOutcomes(str, i+1, keypad, asf + keypad[key].charAt(j), ans);
        }
    }
}