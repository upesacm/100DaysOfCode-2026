import java.util.*;

class Solution {

    static final long MOD = 1000000007L;

    List<List<Integer>> tree;
    long[] fact;
    long[] invFact;

    public int waysToBuildRooms(int[] prevRoom) {

        int n = prevRoom.length;

        tree = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        // Build the tree
        for (int i = 1; i < n; i++) {
            tree.get(prevRoom[i]).add(i);
        }

        // Precompute factorials
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

    // Returns:
    // result[0] = size of subtree
    // result[1] = number of ways
    private long[] dfs(int node) {

        long size = 1;
        long ways = 1;

        for (int child : tree.get(node)) {

            long[] childResult = dfs(child);

            long childSize = childResult[0];
            long childWays = childResult[1];

            // Ways inside the child subtree
            ways = ways * childWays % MOD;

            // Interleave this child's rooms with
            // the rooms already processed
            ways = ways * combination(
                    size + childSize - 1,
                    childSize
            ) % MOD;

            size += childSize;
        }

        return new long[]{size, ways};
    }

    private long combination(long n, long r) {

        return fact[(int) n]
                * invFact[(int) r] % MOD
                * invFact[(int) (n - r)] % MOD;
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