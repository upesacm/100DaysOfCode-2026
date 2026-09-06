public class Question1_LeetCode {
    private static final int MOD = 1_000_000_007;
    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;
        
        int[] outDegree = new int[n];
        for (int i = 1; i < n; i++) {
            outDegree[prevRoom[i]]++;
        }
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
        }

        int[] queue = new int[n];
        int head = 0, tail = 0;

        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 0) {
                queue[tail++] = i;
            }
        }

        while (head < tail) {
            int u = queue[head++];
            int p = prevRoom[u];
            
            if (p != -1) {
                size[p] += size[u];
                
                outDegree[p]--;
                
                if (outDegree[p] == 0) {
                    queue[tail++] = p;
                }
            }
        }
        long[] inv = new long[n + 1];
        if (n >= 1) {
            inv[1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            inv[i] = (MOD - (MOD / i) * inv[MOD % i] % MOD) % MOD;
        }

        long ans = 1;
        
        for (int i = 2; i <= n; i++) {
            ans = (ans * i) % MOD;
        }

        for (int i = 0; i < n; i++) {
            ans = (ans * inv[size[i]]) % MOD;
        }

        return (int) ans;
    }
}
