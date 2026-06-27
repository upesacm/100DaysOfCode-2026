import java.util.*;

public class Main {

    // Function to count distinct subsequences
    static int countDistinctSubseq(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // empty subsequence

        HashMap<Character, Integer> last = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            dp[i] = 2 * dp[i - 1];

            char ch = s.charAt(i - 1);

            if (last.containsKey(ch)) {
                dp[i] -= dp[last.get(ch) - 1];
            }

            last.put(ch, i);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "aac";

        int count1 = countDistinctSubseq(s1);
        int count2 = countDistinctSubseq(s2);

        if (count1 >= count2)
            System.out.println(s1);
        else
            System.out.println(s2);
    }
}
