import java.util.*;

public class Main {

    // Function to count distinct subsequences
    static long countDistinctSubsequences(String s) {
        int n = s.length();

        long[] dp = new long[n + 1];
        dp[0] = 1; // Empty subsequence

        HashMap<Character, Integer> last = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1);

            dp[i] = 2 * dp[i - 1];

            if (last.containsKey(ch)) {
                int prevIndex = last.get(ch);
                dp[i] -= dp[prevIndex - 1];
            }

            last.put(ch, i);
        }

        return dp[n];
    }

    // Function to return the better string
    static String betterString(String s1, String s2) {
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
        String s1 = sc.next();
        String s2 = sc.next();

        // Output the better string
        System.out.println(betterString(s1, s2));

        sc.close();
    }
}
