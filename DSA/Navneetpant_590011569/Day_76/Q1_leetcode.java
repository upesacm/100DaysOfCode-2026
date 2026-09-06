class Solution {
    static final long MOD = 1000000007;

    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;

        List<List<Integer>> tree = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            tree.get(prevRoom[i]).add(i);
        }

        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];

        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[n] = power(fact[n], MOD - 2);

        for (int i = n; i >= 1; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }

        return (int) dfs(0, tree, fact, invFact)[1];
    }


    private long[] dfs(int node, List<List<Integer>> tree,
                       long[] fact, long[] invFact) {

        long size = 1;
        long ways = 1;

        for (int child : tree.get(node)) {
            long[] result = dfs(child, tree, fact, invFact);

            long childSize = result[0];
            long childWays = result[1];

            ways = ways * combination(size + childSize - 1,
                                      childSize, fact, invFact) % MOD;

            ways = ways * childWays % MOD;

            size += childSize;
        }

        return new long[]{size, ways};
    }

    private long combination(long n, long r,
                             long[] fact, long[] invFact) {

        return fact[(int)n]
                * invFact[(int)r] % MOD
                * invFact[(int)(n - r)] % MOD;
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