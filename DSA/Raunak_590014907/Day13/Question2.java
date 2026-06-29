import java.util.HashMap;

class Solution {

    static String betterString(String s1, String s2) {

        if (countDistinctSubsequence(s1) >= countDistinctSubsequence(s2))
            return s1;

        return s2;
    }

    static int countDistinctSubsequence(String s) {

        int n = s.length();

        int[] dp = new int[n + 1];
        dp[0] = 1;

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
}