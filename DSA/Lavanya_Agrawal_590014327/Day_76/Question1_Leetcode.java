import java.util.*;

class Question1_Leetcode {

    static final long MOD = 1000000007L;

    static List<Integer>[] tree;
    static long[] fact;
    static long[] invFact;
    static int[] size;

    static int dfs(int node) {
        size[node] = 1;

        long ways = 1;
        int total = 0;

        for (int child : tree[node]) {
            int childWays = dfs(child);

            ways = ways * childWays % MOD;

            ways = ways * combination(
                    total + size[child],
                    size[child]
            ) % MOD;

            total += size[child];
            size[node] += size[child];
        }

        return (int) ways;
    }

    static long combination(int n, int r) {
        return fact[n] * invFact[r] % MOD
                * invFact[n - r] % MOD;
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

    static int solve(int[] prevRoom) {
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
        size = new int[n];

        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[n] = power(fact[n], MOD - 2);

        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }

        return dfs(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] prevRoom = new int[n];

        for (int i = 0; i < n; i++) {
            prevRoom[i] = sc.nextInt();
        }

        System.out.println(solve(prevRoom));

        sc.close();
    }
}