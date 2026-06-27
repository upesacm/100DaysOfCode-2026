private long countDistinctSubsequences(String s) {
        int n = s.length();
        long dp = 1;  
        HashMap<Character, Long> lastCount = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            long prevDp = dp;

            dp = 2 * dp;
            
            if (lastCount.containsKey(c)) {
                dp = dp - lastCount.get(c);
            }
            
            lastCount.put(c, prevDp);
        }
        
        return dp;
    }
