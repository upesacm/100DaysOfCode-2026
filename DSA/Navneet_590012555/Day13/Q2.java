
String betterString(String s1, String s2) {
    return count(s1) >= count(s2) ? s1 : s2;
}

static int count(String s) {
    int n = s.length();
    int[] dp = new int[n + 1];
    int[] last = new int[256];

    dp[0] = 1;

    for (int i = 0; i < 256; i++)
        last[i] = -1;

    for (int i = 1; i <= n; i++) {
        dp[i] = 2 * dp[i - 1];

        char c = s.charAt(i - 1);

        if (last[c] != -1)
            dp[i] -= dp[last[c] - 1];

        last[c] = i;
    }

    return dp[n];
}