class Solution {
    public long countPairs(int n, int[][] edges) {
        ArrayList<Integer>[] g = new ArrayList[n];

        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<>();

        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        boolean[] vis = new boolean[n];
        long ans = 0;
        long seen = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int size = dfs(i, g, vis);

                ans += (long) size * seen;
                seen += size;
            }
        }

        return ans;
    }

    int dfs(int x, ArrayList<Integer>[] g, boolean[] vis) {
        vis[x] = true;
        int size = 1;

        for (int y : g[x]) {
            if (!vis[y])
                size += dfs(y, g, vis);
        }

        return size;
    }
}
