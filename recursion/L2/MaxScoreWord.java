import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class MaxScoreWord {
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter total words: ");
        int n = Integer.parseInt(br.readLine());

        System.out.print("Enter words: ");
        String[] arr = br.readLine().trim().split(" ");

        System.out.print("Enter freq arr length: ");
        int freqLength = Integer.parseInt(br.readLine());

        int[] freqArr = new int[26];
        System.out.print("Enter freq arr: ");
        for (String str : br.readLine().trim().split(" ")) {
            freqArr[str.charAt(0) - 'a']++;
        }

        int[] scoreArr = new int[26];
        System.out.print("Enter score arr: ");
        int i = 0;
        for (String s : br.readLine().trim().split(" ")) {
            scoreArr[i] = s.charAt(0)-'0';
            i++;
        }
        System.out.println(Arrays.toString(scoreArr));
//        String[] ans = {"", "-1"};
        getMaxScore(0, freqArr, scoreArr, arr, "");
        System.out.println("Max score: " + ans);
    }

    static void getMaxScore(int i, int[] freqArr, int[] scoreArr, String[] arr, String set) {
        if (i == arr.length) {
            int score = 0;
            int[] freqArrClone = freqArr.clone();
            for (int k = 0; k < set.length(); k++) {
                char ch = set.charAt(k);
                if (freqArrClone[ch - 'a'] == 0) return;
                score += scoreArr[ch - 'a'];
                freqArrClone[ch - 'a']--;
            }
            ans = Math.max(score, ans);
            return;
        }
        getMaxScore(i+1, freqArr, scoreArr, arr, set);
        getMaxScore(i+1, freqArr, scoreArr, arr, set + arr[i]);
    }
}



//4
//dog cat dad good
//9
//a b c d d d g o o
//1 0 9 5 0 0 3 0 0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0