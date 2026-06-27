class Q2 {
    public long countDistSubseq(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1; 

        int[] lastSeen = new int[256];
        for (int i = 0; i < 256; i++) lastSeen[i] = -1;

        for (int i = 1; i <= n; i++) {
            dp[i] = 2 * dp[i - 1];
            char c = s.charAt(i - 1);

            if (lastSeen[c] != -1) {
                dp[i] = dp[i] - dp[lastSeen[c]];
            }
            lastSeen[c] = i - 1;
        }

        return dp[n];
    }

    public String compareDistinctSubsequences(String s1, String s2) {
        long count1 = countDistSubseq(s1);
        long count2 = countDistSubseq(s2);

        if (count1 >= count2) {
            return s1;
        } else {
            return s2;
        }
    }

    public static void main(String[] args) {
        Q2 sol = new Q2();
        String s1 = "abc";
        String s2 = "aac";
        System.out.println("Result: " + sol.compareDistinctSubsequences(s1, s2));
    }
}