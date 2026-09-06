class Solution {
    public int largestPathValue(String s, int[][] e) {
        int n = s.length();
        List<Integer>[] g = new ArrayList[n];
        int[] in = new int[n];

        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] x : e) {
            g[x[0]].add(x[1]);
            in[x[1]]++;
        }

        int[][] d = new int[n][26];
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++)
            if (in[i] == 0) q.offer(i);

        int c = 0, ans = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            c++;

            d[u][s.charAt(u) - 'a']++;

            for (int v : g[u]) {
                for (int j = 0; j < 26; j++)
                    d[v][j] = Math.max(d[v][j], d[u][j]);

                if (--in[v] == 0) q.offer(v);
            }

            for (int j = 0; j < 26; j++)
                ans = Math.max(ans, d[u][j]);
        }

        return c == n ? ans : -1;
    }
}
