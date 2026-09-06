class Solution {
    int count, size;

    public int[] solve(int n, int[][] edges) {
        ArrayList<Integer>[] g = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++)
            g[i] = new ArrayList<>();

        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        boolean[] vis = new boolean[n + 1];
        int wells = 0;
        int largest = 0;

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                size = 0;
                dfs(i, g, vis);

                wells++;
                largest = Math.max(largest, size);
            }
        }

        return new int[]{wells, largest};
    }

    void dfs(int x, ArrayList<Integer>[] g, boolean[] vis) {
        vis[x] = true;
        size++;

        for (int y : g[x]) {
            if (!vis[y])
                dfs(y, g, vis);
        }
    }
}
