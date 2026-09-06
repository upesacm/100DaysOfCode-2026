package Day_76;
import java.util.*;
class Solution {
    static final long MOD = 1000000007L;

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
        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
        long[] result = dfs(0, tree, fact, invFact);
        return (int) result[0];
    }

    private long[] dfs(int node, List<List<Integer>> tree,
                       long[] fact, long[] invFact) {

        long ways = 1;
        int size = 0;

        for (int child : tree.get(node)) {
            long[] result = dfs(child, tree, fact, invFact);
            int childSize = (int) result[1];
            ways = ways * result[0] % MOD;
            ways = ways * invFact[childSize] % MOD;
            size += childSize;
        }
        ways = ways * fact[size] % MOD;
        return new long[]{ways, size + 1};
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