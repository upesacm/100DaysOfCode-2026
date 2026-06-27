import java.util.HashMap;

public class Question2 {

    public static long countDistinctSubsequences(String str) {

        long[] dp = new long[str.length() + 1];
        dp[0] = 1;

        HashMap<Character, Integer> last = new HashMap<>();

        for (int i = 1; i <= str.length(); i++) {

            dp[i] = 2 * dp[i - 1];

            char ch = str.charAt(i - 1);

            if (last.containsKey(ch)) {
                dp[i] -= dp[last.get(ch) - 1];
            }

            last.put(ch, i);
        }

        return dp[str.length()];
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

        String s1 = "abc";
        String s2 = "aac";

        System.out.println(betterString(s1, s2));
    }
}