class Solution {

    private long countDistinct(String str) {
        int n = str.length();

        long[] dp = new long[n + 1];
        int[] last = new int[256];

        Arrays.fill(last, -1);

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            char ch = str.charAt(i - 1);

            dp[i] = 2 * dp[i - 1];

            if (last[ch] != -1) {
                dp[i] -= dp[last[ch] - 1];
            }

            last[ch] = i;
        }

        return dp[n];
    }

    public String betterString(String s1, String s2) {

        long first = countDistinct(s1);
        long second = countDistinct(s2);

        return first >= second ? s1 : s2;
    }
}
