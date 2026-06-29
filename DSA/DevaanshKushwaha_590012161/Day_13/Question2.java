import java.util.HashMap;

public class DistinctSubsequences {

    public static long countDistinctSubseq(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1; // empty subsequence

        HashMap<Character, Integer> lastSeen = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            dp[i] = 2 * dp[i - 1];

            if (lastSeen.containsKey(c)) {
                int prevIndex = lastSeen.get(c); // 1-based index of last occurrence
                dp[i] -= dp[prevIndex - 1];      // subtract to remove duplicates
            }

            lastSeen.put(c, i); // store 1-based index
        }

        return dp[n];
    }

    public static String moreDistinctSubseq(String s1, String s2) {
        long count1 = countDistinctSubseq(s1);
        long count2 = countDistinctSubseq(s2);

        System.out.println("Distinct subsequences in s1 (" + s1 + "): " + count1);
        System.out.println("Distinct subsequences in s2 (" + s2 + "): " + count2);

        return (count1 >= count2) ? s1 : s2;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "aac";
        System.out.println("Result: " + moreDistinctSubseq(s1, s2));
    }
}
