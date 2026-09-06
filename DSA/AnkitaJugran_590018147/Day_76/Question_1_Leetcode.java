import java.util.*;

class Solution {

    static final long MOD = 1_000_000_007L;

    public int waysToBuildRooms(int[] prevRoom) {

        int n = prevRoom.length;

        // Build tree
        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[prevRoom[i]].add(i);
        }

        // factorials
        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];

        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[n] = power(fact[n], MOD - 2);

        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }

        // Find an order where parent comes before child
        int[] order = new int[n];
        int index = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            order[index++] = node;

            for (int child : tree[node]) {
                stack.push(child);
            }
        }

        // Calculate subtree sizes from bottom to top
        int[] size = new int[n];
        Arrays.fill(size, 1);

        for (int i = n - 1; i > 0; i--) {
            int node = order[i];
            int parent = prevRoom[node];

            size[parent] += size[node];
        }

        // Calculate number of ways
        long[] ways = new long[n];
        Arrays.fill(ways, 1);

        for (int i = n - 1; i >= 0; i--) {

            int node = order[i];

            int used = 0;
            long currentWays = 1;

            for (int child : tree[node]) {

                // Ways inside child's subtree
                currentWays = currentWays * ways[child] % MOD;

                // Interleave child's subtree with previous subtrees
                currentWays = currentWays
                        * combination(
                            used + size[child],
                            size[child],
                            fact,
                            invFact
                        ) % MOD;

                used += size[child];
            }

            ways[node] = currentWays;
        }

        return (int) ways[0];
    }

    long combination(
        int n,
        int r,
        long[] fact,
        long[] invFact
    ) {
        return fact[n]
                * invFact[r] % MOD
                * invFact[n - r] % MOD;
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