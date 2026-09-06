import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;

    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;

        // Build tree
        List<Integer>[] children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            children[prevRoom[i]].add(i);
        }

        // factorial and inverse factorial
        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];

        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[n] = modPow(fact[n], MOD - 2);

        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }

        /*
         * We need postorder traversal.
         * Since n can be 100000, avoid recursive DFS
         * because Java recursion may cause StackOverflowError.
         */
        int[] order = new int[n];
        int index = 0;

        int[] stack = new int[n];
        int top = 0;
        stack[top++] = 0;

        while (top > 0) {
            int u = stack[--top];
            order[index++] = u;

            for (int v : children[u]) {
                stack[top++] = v;
            }
        }

        long[] dp = new long[n];
        int[] size = new int[n];

        // Process in reverse order = postorder
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];

            size[u] = 1;
            long ways = 1;

            // Total number of nodes in all child subtrees
            int totalChildren = 0;

            for (int v : children[u]) {
                size[u] += size[v];
                totalChildren += size[v];

                // Ways inside child's subtree
                ways = ways * dp[v] % MOD;
            }

            /*
             * Number of ways to interleave the child subtrees:
             *
             * totalChildren!
             * ---------------------------
             * product(size[v]!)
             */
            ways = ways * fact[totalChildren] % MOD;

            for (int v : children[u]) {
                ways = ways * invFact[size[v]] % MOD;
            }

            dp[u] = ways;
        }

        return (int) dp[0];
    }

    // Fast modular exponentiation
    static long modPow(long a, long b) {
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