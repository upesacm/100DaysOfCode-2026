
import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;

    List<Integer>[] tree;
    long[] fact;
    long[] invFact;
    long[] ways;
    int[] size;

    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;

        // Build tree
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[prevRoom[i]].add(i);
        }

        // Precompute factorials
        fact = new long[n + 1];
        invFact = new long[n + 1];

        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        // Fermat's little theorem:
        // invFact[n] = (fact[n])^(MOD-2)
        invFact[n] = modPow(fact[n], MOD - 2);

        for (int i = n; i >= 1; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }

        ways = new long[n];
        size = new int[n];

        dfs(0);

        return (int) ways[0];
    }

    private void dfs(int u) {
        size[u] = 1;
        ways[u] = 1;

        for (int v : tree[u]) {
            dfs(v);

            // Add child's subtree
            size[u] += size[v];

            // Number of ways inside child's subtree
            ways[u] = ways[u] * ways[v] % MOD;
        }

        // Number of nodes belonging to child subtrees
        int childrenNodes = size[u] - 1;

        /*
         * Interleave child subtrees:
         *
         * (size[u]-1)! / product(size[child]!)
         */
        ways[u] = ways[u] * fact[childrenNodes] % MOD;

        for (int v : tree[u]) {
            ways[u] = ways[u] * invFact[size[v]] % MOD;
        }
    }

    private long modPow(long a, long b) {
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

