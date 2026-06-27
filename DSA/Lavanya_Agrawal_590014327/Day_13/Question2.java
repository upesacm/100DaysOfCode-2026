import java.util.*;

public class Question2 {

    public static long countDistinctSubsequences(String str) {

        int n = str.length();

        long[] dp = new long[n + 1];
        dp[0] = 1;

        HashMap<Character, Integer> lastSeen = new HashMap<>();

        for (int i = 1; i <= n; i++) {

            dp[i] = 2 * dp[i - 1];

            char ch = str.charAt(i - 1);

            if (lastSeen.containsKey(ch)) {
                dp[i] -= dp[lastSeen.get(ch) - 1];
            }

            lastSeen.put(ch, i);
        }

        return dp[n];
    }

    public static String betterString(String s1, String s2) {

        long first = countDistinctSubsequences(s1);
        long second = countDistinctSubsequences(s2);

        if (first >= second) {
            return s1;
        }

        return s2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        System.out.println(betterString(s1, s2));

        sc.close();
    }
}