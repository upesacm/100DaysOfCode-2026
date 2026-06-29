package DSA.Sudhanshu_Ranjan_590018435.Day_13;

class Solution {
        public static String betterString(String str1, String str2) {
            
            int count1 = countDistinctSubsequences(str1);
            int count2 = countDistinctSubsequences(str2);
    
            return (count1 >= count2) ? str1 : str2;
    
        private static int countDistinctSubsequences(String str) {
            int MOD = 1000000007;
            int n = str.length();
            
            int[] lastOccurrence = new int[256];
            Arrays.fill(lastOccurrence, -1);
    
            int[] dp = new int[n + 1];
            dp[0] = 1; 
            for (int i = 1; i <= n; i++) {
                dp[i] = (2 * dp[i - 1]) % MOD;
    
                if (lastOccurrence[str.charAt(i - 1)] != -1) {
                    dp[i] = (dp[i] - dp[lastOccurrence[str.charAt(i - 1)] - 1] + MOD) % MOD;
                }
    
                lastOccurrence[str.charAt(i - 1)] = i;
            }
    
            return dp[n];
        }
    }