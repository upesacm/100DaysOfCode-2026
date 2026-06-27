import java.util.*;
public class Question2 {
    public static int count(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;  
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            dp[i] = 2 * dp[i - 1];
            if (map.containsKey(c)) {
                dp[i] = dp[i] - dp[map.get(c) - 1];
            }
            map.put(c, i);
        }
        return dp[n];
    }
    public static String betterString(String s1, String s2) {
        int a = count(s1);
        int b = count(s2);
        if (a >= b)
            return s1;
        else
            return s2;
    }
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "aac";
        System.out.println(betterString(s1, s2));
    }
}