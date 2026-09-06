public class Question1_Leetcode {
    static final long MOD = 1000000007L;

    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;
        int[] head = new int[n];
        int[] next = new int[n];
        java.util.Arrays.fill(head, -1);

        for (int i = 1; i < n; i++) {
            next[i] = head[prevRoom[i]];
            head[prevRoom[i]] = i;
        }

        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];

        fact[0] = 1;
        for (int i = 1; i <= n; i++) fact[i] = fact[i - 1] * i % MOD;
        invFact[n] = power(fact[n], MOD - 2);
        for (int i = n; i >= 1; i--)
            invFact[i - 1] = invFact[i] * i % MOD;

        int[] order = new int[n];
        int[] stack = new int[n];

        int top = 0, idx = 0;
        stack[top++] = 0;

        while (top > 0) {
            int u = stack[--top];
            order[idx++] = u;

            for (int v = head[u]; v != -1; v = next[v])
                stack[top++] = v;
        }

        int[] size = new int[n];
        long[] ways = new long[n];

        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];

            int total = 0;
            long cur = 1;

            for (int v = head[u]; v != -1; v = next[v]) {
                total += size[v];
                cur = cur * ways[v] % MOD;
                cur = cur * invFact[size[v]] % MOD;
            }

            size[u] = total + 1;
            ways[u] = cur * fact[total] % MOD;
        }

        return (int) ways[0];
    }

    private long power(long a, long b) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) != 0)
                res = res * a % MOD;

            a = a * a % MOD;
            b >>= 1;
        }

        return res;
    }
}