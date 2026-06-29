import java.util.HashMap;

public class Distinct_subsequence {

    public static int countDistinctSubsequences(String str) {

        int n = str.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        HashMap<Character, Integer> last = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            char ch = str.charAt(i - 1);

            // Double the previous count
            dp[i] = 2 * dp[i - 1];

            // If character appeared before, remove duplicates
            if (last.containsKey(ch)) {
                int prevIndex = last.get(ch);
                dp[i] = dp[i] - dp[prevIndex - 1];
            }

            // Store latest position (1-based)
            last.put(ch, i);
        }

        return dp[n];
    }

    public static void main(String[] args){
        String s1 = "abc";
        String s2 = "aac";

        int count1 = countDistinctSubsequences(s1);
        int count2 = countDistinctSubsequences(s2);

        if (count1 >= count2) {
            System.out.println(s1);
        } else {
            System.out.println(s2);
        }

    }
    
}
