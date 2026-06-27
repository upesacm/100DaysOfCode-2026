package DSA.TanmaySharma_590011578.Day_13;

import java.util.HashMap;
import java.util.Scanner;

public class Question2 {
    static long countDistinctSubsequences(String s) {
        int n = s.length();

        long[] dp = new long[n + 1];
        dp[0] = 1; // Empty subsequence

        HashMap<Character, Integer> last = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1);

            // Double the count from previous step
            dp[i] = 2 * dp[i - 1];

            // Remove duplicate subsequences
            if (last.containsKey(ch)) {
                dp[i] -= dp[last.get(ch) - 1];
            }

            // Store latest occurrence
            last.put(ch, i);
        }

        return dp[n];
    }

    // Function to determine which string has more distinct subsequences
    static String moreDistinctString(String s1, String s2) {
        long count1 = countDistinctSubsequences(s1);
        long count2 = countDistinctSubsequences(s2);

        if (count1 >= count2) {
            return s1;
        } else {
            return s2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(moreDistinctString(s1, s2));

        sc.close();
    }
    
}
