import java.util.*;

public class Question2 {

    static class Edge {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static int[] parent;

    static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);

        return parent[x];
    }

    static boolean union(int u, int v) {
        int parentU = find(u);
        int parentV = find(v);

        if (parentU == parentV)
            return false;

        parent[parentV] = parentU;
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Edge[] edges = new Edge[m];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            edges[i] = new Edge(u, v, w);
        }

        Arrays.sort(edges, (a, b) -> {
            if (a.w != b.w)
                return a.w - b.w;

            return (a.u + a.v + a.w) - (b.u + b.v + b.w);
        });

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++)
            parent[i] = i;

        long answer = 0;
        int count = 0;

        for (Edge e : edges) {

            if (union(e.u, e.v)) {
                answer += e.w;
                count++;

                if (count == n - 1)
                    break;
            }
        }

        System.out.println(answer);

        sc.close();
    }
}