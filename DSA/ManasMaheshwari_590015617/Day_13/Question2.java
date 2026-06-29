// Question: Determine which string has more distinct subsequences using an optimized approach.
// Time Complexity: O(N)
// Space Complexity: O(N)

class Question2 {
    public static void main(String args[]) {
        String s1 = "abc";
        String s2 = "aac";
        int count = s1.length();
        
        long dp1[] = new long[count + 1];
        long dp2[] = new long[count + 1];
        dp1[0] = 1;
        dp2[0] = 1;
        
        int last1[] = new int[256];
        int last2[] = new int[256];
        
        for (int i = 1; i <= count; i++) {
            char c1 = s1.charAt(i - 1);
            char c2 = s2.charAt(i - 1);
            
            dp1[i] = 2 * dp1[i - 1];
            dp2[i] = 2 * dp2[i - 1];
            
            if (last1[c1] != 0) dp1[i] = dp1[i] - dp1[last1[c1] - 1];
            if (last2[c2] != 0) dp2[i] = dp2[i] - dp2[last2[c2] - 1];
            
            last1[c1] = i;
            last2[c2] = i;
        }
        
        if (dp1[count] >= dp2[count]) {
            System.out.println(s1);
        } else {
            System.out.println(s2);
        }
    }
}
