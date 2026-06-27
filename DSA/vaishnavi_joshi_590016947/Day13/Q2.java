import java.util.*;

public class BetterString {

    // Function to count distinct subsequences
    public static long countDistinctSubsequences(String s) {
        int n = s.length();

        long[] dp = new long[n + 1];
        dp[0] = 1; // Empty subsequence

        int[] last = new int[256];
        Arrays.fill(last, -1);

        for (int i = 1; i <= n; i++) {
            dp[i] = 2 * dp[i - 1];

            char ch = s.charAt(i - 1);

            if (last[ch] != -1) {
                dp[i] = dp[i] - dp[last[ch]];
            }

            last[ch] = i - 1;
        }

        return dp[n];
    }

    // Function to find the better string
    public static String betterString(String s1, String s2) {
        long count1 = countDistinctSubsequences(s1);
        long count2 = countDistinctSubsequences(s2);

        if (count1 >= count2)
            return s1;
        else
            return s2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input two strings
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        // Output
        System.out.println(betterString(s1, s2));

        sc.close();
    }
}