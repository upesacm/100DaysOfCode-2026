import java.util.*;

class Solution {
    static final long MOD = 1000000007L;

    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;

        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[prevRoom[i]].add(i);
        }

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

        int[] size = new int[n];
        long[] ways = new long[n];

        Arrays.fill(ways, 1);

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

        for (int i = n - 1; i >= 0; i--) {
            int node = order[i];

            size[node] = 1;
            ways[node] = 1;

            int totalChildren = 0;

            for (int child : tree[node]) {
                size[node] += size[child];
                totalChildren += size[child];

                ways[node] = ways[node] * ways[child] % MOD;
                ways[node] = ways[node] * invFact[size[child]] % MOD;
            }

            ways[node] = ways[node] * fact[totalChildren] % MOD;
        }

        return (int) ways[0];
    }

    static long power(long a, long b) {
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
