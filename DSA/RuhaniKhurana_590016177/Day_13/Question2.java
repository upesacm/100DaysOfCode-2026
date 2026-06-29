import java.util.*;

class Solution {

    static String betterString(String s1, String s2) {
        long c1 = countDistinctSubseq(s1);
        long c2 = countDistinctSubseq(s2);

        return (c1 >= c2) ? s1 : s2;
    }

    static long countDistinctSubseq(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        Map<Character, Integer> last = new HashMap<>();
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