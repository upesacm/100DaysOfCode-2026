import java.io.*;
import java.util.*;

public class Question2 {
    static int n, t, s, z;
    static int[][] g;

    static int flow() {
        int ans = 0;

        while (true) {
            int[] p = new int[2 * n + 2];
            Arrays.fill(p, -1);
            p[s] = s;

            Queue<Integer> q = new ArrayDeque<>();
            q.add(s);

            while (!q.isEmpty() && p[z] == -1) {
                int u = q.poll();

                for (int v = 0; v <= z; v++) {
                    if (p[v] == -1 && g[u][v] > 0) {
                        p[v] = u;
                        q.add(v);
                    }
                }
            }

            if (p[z] == -1) break;

            int f = Integer.MAX_VALUE;
            for (int v = z; v != s; v = p[v])
                f = Math.min(f, g[p[v]][v]);

            for (int v = z; v != s; v = p[v]) {
                int u = p[v];
                g[u][v] -= f;
                g[v][u] += f;
            }

            ans += f;
        }

        return ans;
    }

    public static void main(String[] a) throws Exception {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();

        while (c-- > 0) {
            n = sc.nextInt();
            t = sc.nextInt();
            int m = sc.nextInt();

            s = 2 * n;
            z = s + 1;
            g = new int[2 * n + 2][2 * n + 2];

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;

                g[u][n + v] = 1;
                g[v][n + u] = 1;
            }

            for (int i = 0; i < n; i++) {
                int d = 0;

                for (int j = 0; j < n; j++)
                    if (g[i][n + j] > 0) d++;

                g[s][i] = Math.min(t, d);
                g[n + i][z] = 1;
            }

            System.out.println(flow());
        }
    }
}