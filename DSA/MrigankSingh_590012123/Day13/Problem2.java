import java.math.BigInteger;

public class Problem2 {
    public String betterString(String s1, String s2) {
        BigInteger first = countDistinctSubsequences(s1);
        BigInteger second = countDistinctSubsequences(s2);

        if (first.compareTo(second) >= 0) {
            return s1;
        }
        return s2;
    }

    private BigInteger countDistinctSubsequences(String s) {
        BigInteger[] dp = new BigInteger[s.length() + 1];
        dp[0] = BigInteger.ONE;
        int[] lastSeen = new int[256];

        for (int i = 1; i < lastSeen.length; i++) {
            lastSeen[i] = -1;
        }

        for (int i = 1; i <= s.length(); i++) {
            char current = s.charAt(i - 1);
            dp[i] = dp[i - 1].shiftLeft(1);

            if (lastSeen[current] != -1) {
                dp[i] = dp[i].subtract(dp[lastSeen[current] - 1]);
            }

            lastSeen[current] = i;
        }

        return dp[s.length()];
    }
}