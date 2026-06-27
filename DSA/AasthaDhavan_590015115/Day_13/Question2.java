import java.util.*;

public class Question2 {

    static String betterString(String s1, String s2) {
        return count(s1) >= count(s2) ? s1 : s2;
    }

    static int count(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        int[] last = new int[26];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = 2 * dp[i - 1];
            int idx = s.charAt(i - 1) - 'a';

            if (last[idx] != 0)
                dp[i] -= dp[last[idx] - 1];

            last[idx] = i;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(betterString(s1, s2));

        sc.close();
    }
}