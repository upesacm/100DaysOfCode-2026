class Solution {
    public String betterString(String s1, String s2) {
        int count1 = countDistinctSubsequences(s1);
        int count2 = countDistinctSubsequences(s2);

        return count1 >= count2 ? s1 : s2;
    }

    private int countDistinctSubsequences(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        int[] last = new int[256];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = 2 * dp[i - 1];

            char ch = s.charAt(i - 1);
            if (last[ch] != 0) {
                dp[i] -= dp[last[ch] - 1];
            }

            last[ch] = i;
        }

        return dp[n];
    }
}