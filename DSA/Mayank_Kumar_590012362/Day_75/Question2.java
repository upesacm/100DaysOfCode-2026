public class Question2 {
    public static int solve(int n, int[][] roads) {
        int[][] g = new int[n][2];
        int[][] c = new int[n][2];
        int[] d = new int[n];
        for (int[] e : roads) {
            int u = e[0] - 1, v = e[1] - 1;
            g[u][d[u]] = v;
            c[u][d[u]++] = e[2];
            g[v][d[v]] = u;
            c[v][d[v]++] = e[2];
        }
        int[] p = new int[n], w = new int[n];
        boolean[] vis = new boolean[n];
        int k = 0, u = 0;
        while (k < n) {
            vis[u] = true;
            int v = g[u][0] == (k == 0 ? -1 : p[k - 1]) ? g[u][1] : g[u][0];
            int j = g[u][0] == v ? 0 : 1;
            p[k] = u;
            w[k++] = (roads.length == 0 ? 0 : c[u][j]);
            u = v;
        }
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            int u1 = p[i], v = p[(i + 1) % n];
            int j = g[u1][0] == v ? 0 : 1;
            boolean ok = false;
            for (int[] e : roads) {
                if (e[0] - 1 == u1 && e[1] - 1 == v) {
                    y += e[2];
                    ok = true;
                    break;
                }
            }
            if (!ok) x += c[u1][j];
        } return Math.min(x, y);
    }
}