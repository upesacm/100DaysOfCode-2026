import java.util.*;

class Question2 {

    static class Edge {
        int u, v;

        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    static boolean hasEulerTrail(int oddCount) {
        return oddCount == 0 || oddCount == 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Edge[] edges = new Edge[m];
        int[] degree = new int[n];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            edges[i] = new Edge(u, v);

            degree[u]++;
            degree[v]++;
        }

        int k = sc.nextInt();

        if (k == 0) {
            int odd = 0;

            for (int d : degree) {
                if (d % 2 != 0) {
                    odd++;
                }
            }

            System.out.println(hasEulerTrail(odd));
            sc.close();
            return;
        }

        int odd = 0;

        for (int d : degree) {
            if (d % 2 != 0) {
                odd++;
            }
        }

        int lineOdd = 0;

        for (Edge e : edges) {
            if ((degree[e.u] + degree[e.v]) % 2 != 0) {
                lineOdd++;
            }
        }

        if (!hasEulerTrail(lineOdd)) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }

        sc.close();
    }
}