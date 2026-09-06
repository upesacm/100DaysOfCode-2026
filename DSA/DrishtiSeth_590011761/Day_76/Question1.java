import java.util.*;

class Solution {

    static final long MOD = 1_000_000_007L;

    List<Integer>[] tree;
    long[] fact;
    long[] invFact;

    public int waysToBuildRooms(int[] prevRoom) {

        int n = prevRoom.length;

        tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        // Build tree
        for (int i = 1; i < n; i++) {
            tree[prevRoom[i]].add(i);
        }

        // Precompute factorials
        fact = new long[n + 1];
        invFact = new long[n + 1];

        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        // Modular inverse of factorial[n]
        invFact[n] = modPow(fact[n], MOD - 2);

        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }

        long[] result = dfs(0);

        return (int) result[0];
    }

    /*
        Returns:
        result[0] = number of valid ways
        result[1] = size of subtree
    */

    private long[] dfs(int node) {

        long ways = 1;
        int totalSize = 0;

        for (int child : tree[node]) {

            long[] childResult = dfs(child);

            long childWays = childResult[0];
            int childSize = (int) childResult[1];

            // Multiply ways of child's subtree
            ways = (ways * childWays) % MOD;

            // Interleave current children arrangements
            ways = (ways * combination(totalSize + childSize, childSize)) % MOD;

            totalSize += childSize;
        }

        return new long[]{ways, totalSize + 1};
    }

    private long combination(int n, int r) {

        return (((fact[n] * invFact[r]) % MOD)
                * invFact[n - r]) % MOD;
    }

    private long modPow(long base, long exp) {

        long result = 1;

        while (exp > 0) {

            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }
}
