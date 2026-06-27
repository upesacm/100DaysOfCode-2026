import java.util.*;
class Question2 
{
    static int countDistinctSubsequences(String s) 
    {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; 

        Map<Character, Integer> lastOccur = new HashMap<>();
        for (int i = 1; i <= n; i++) 
        {
            char ch = s.charAt(i - 1);
            dp[i] = 2 * dp[i - 1];
            if (lastOccur.containsKey(ch)) 
            {
                int prev = lastOccur.get(ch);
                dp[i] -= dp[prev - 1];
            }

            lastOccur.put(ch, i);
        }
        return dp[n];
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string 1: ");
        String s1 = sc.next();
        System.out.println("Enter string 2: ");
        String s2 = sc.next();

        int c1 = countDistinctSubsequences(s1);
        int c2 = countDistinctSubsequences(s2);

        if (c1 >= c2)
            System.out.println(s1);
        else
            System.out.println(s2);

        sc.close();
    }
}
