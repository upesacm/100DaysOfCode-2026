class Solution {
    static final long MOD = 1000000007L;
    long[] fact;
    long[] invFact;

    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;

        // Build the tree
        java.util.List<Integer>[] children = new java.util.ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new java.util.ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            children[prevRoom[i]].add(i);
        }

        // Factorials
        fact = new long[n + 1];
        invFact = new long[n + 1];

        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[n] = power(fact[n], MOD - 2);

        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }

        return (int) dfs(0, children)[0];
    }

    // result[0] = number of ways
    // result[1] = size of subtree
    private long[] dfs(int node, java.util.List<Integer>[] children) {

        long ways = 1;
        int size = 1;

        for (int child : children[node]) {
            long[] result = dfs(child, children);

            long childWays = result[0];
            int childSize = (int) result[1];

            ways = ways * childWays % MOD;

            // Choose positions for this child's subtree
            ways = ways * combination(size + childSize - 1, childSize) % MOD;

            size += childSize;
        }

        return new long[]{ways, size};
    }

    private long combination(int n, int r) {
        if (r < 0 || r > n) {
            return 0;
        }

        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    private long power(long a, long b) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * a % MOD;
            }

            a = a * a % MOD;
            b >>= 1;
        }

        return result;

        
    }
}
