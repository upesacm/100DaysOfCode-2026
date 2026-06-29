import java.util.*;

public class Question2 {
    private static int countDistinctSubsequences(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        int[] last = new int[256];
        Arrays.fill(last, -1);

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            dp[i] = 2 * dp[i - 1];
            if (last[c] != -1) {
                dp[i] -= dp[last[c] - 1];
            }
            last[c] = i;
        }
        return dp[n];
    }

    public static String moreDistinctSubsequences(String s1, String s2) {
        int count1 = countDistinctSubsequences(s1);
        int count2 = countDistinctSubsequences(s2);
        if (count1 >= count2) return s1;
        else return s2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string s1: ");
        String s1 = sc.nextLine();
        System.out.print("Enter string s2: ");
        String s2 = sc.nextLine();

        if (s1.length() != s2.length()) {
            System.out.println("Strings must be of equal length!");
            return;
        }

        System.out.println("Result: " + moreDistinctSubsequences(s1, s2));
        System.out.println("Sample 1: " + moreDistinctSubsequences("abc", "aac"));
        System.out.println("Sample 2: " + moreDistinctSubsequences("abab", "abba"));
        System.out.println("Sample 3: " + moreDistinctSubsequences("x", "y"));
        
    }
}
