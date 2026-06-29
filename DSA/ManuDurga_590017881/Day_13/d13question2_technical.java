package Day_13;
import java.util.*;

public class d13question2_technical {
    private static int countDistinctSubseq(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // empty subsequence
        int[] last = new int[256];
        Arrays.fill(last, -1);

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();


        if (countDistinctSubseq(s1) >= countDistinctSubseq(s2)) {
            System.out.println(s1);
        } else {
            System.out.println(s2);
        }
    }
}
