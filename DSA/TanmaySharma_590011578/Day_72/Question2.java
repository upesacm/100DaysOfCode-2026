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

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b)
            parent[b] = a;
    }

    static int kruskal(int n, int[][] edges) {
        ArrayList<Edge> list = new ArrayList<>();

        for (int[] e : edges)
            list.add(new Edge(e[0], e[1], e[2]));

        list.sort((a, b) -> a.w - b.w);

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++)
            parent[i] = i;

        int total = 0;
        int count = 0;

        for (Edge e : list) {
            if (find(e.u) != find(e.v)) {
                union(e.u, e.v);
                total += e.w;
                count++;

                if (count == n - 1)
                    break;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] edges = new int[m][3];

        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        System.out.println(kruskal(n, edges));
        sc.close();
    }
}