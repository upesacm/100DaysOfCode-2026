class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;
        
        // Build children lists
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) children.add(new ArrayList<>());
        for (int i = 1; i < n; i++) {
            children.get(prevRoom[i]).add(i);
        }
        
        // Precompute factorials and inverse factorials
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        long[] invFact = new long[n + 1];
        invFact[n] = modPow(fact[n], MOD - 2, MOD);
        for (int i = n; i > 0; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }
        
        int[] size = new int[n];
        long[] ways = new long[n];
        
        // Iterative post-order traversal
        Deque<int[]> stack = new ArrayDeque<>(); // {node, processedFlag}
        stack.push(new int[]{0, 0});
        
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            int node = top[0], processed = top[1];
            
            if (processed == 0) {
                stack.push(new int[]{node, 1});
                for (int c : children.get(node)) {
                    stack.push(new int[]{c, 0});
                }
            } else {
                int sz = 1;
                long w = 1;
                for (int c : children.get(node)) {
                    sz += size[c];
                    w = w * ways[c] % MOD;
                    w = w * invFact[size[c]] % MOD;
                }
                size[node] = sz;
                w = w * fact[sz - 1] % MOD;
                ways[node] = w;
            }
        }
        
        return (int) ways[0];
    }
    
    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % mod;
            }
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }
}
