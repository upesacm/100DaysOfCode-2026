class Solution {
    static final long MOD = 1000000007;

    List<Integer>[] tree;
    long[] fact, invFact;

    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;

        tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[prevRoom[i]].add(i);
        }

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

        return (int) dfs(0)[1];
    }

    long[] dfs(int node) {
        long ways = 1;
        int size = 1;
        int total = 0;

        for (int child : tree[node]) {
            long[] result = dfs(child);

            int childSize = (int) result[0];
            long childWays = result[1];

            ways = ways * childWays % MOD;

            ways = ways * fact[total + childSize] % MOD;
            ways = ways * invFact[total] % MOD;
            ways = ways * invFact[childSize] % MOD;

            total += childSize;
        }

        size += total;

        return new long[]{size, ways};
    }

    long power(long a, long b) {
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