import java.util.*;

class Solution {
    static class Graph {
        int n;
        ArrayList<Integer>[] adj;
        int[] eu, ev;

        Graph(int n, int m) {
            this.n = n;
            adj = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }

            eu = new int[m];
            ev = new int[m];
        }

        void addEdge(int id, int u, int v) {
            eu[id] = u;
            ev[id] = v;
            adj[u].add(id);
            adj[v].add(id);
        }

        int m() {
            return eu.length;
        }

        int degree(int v) {
            return adj[v].size();
        }
    }

    static Graph lineGraph(Graph g) {

        int m = g.m();

        long totalEdges = 0;

        for (int v = 0; v < g.n; v++) {
            int d = g.adj[v].size();
            totalEdges += (long) d * (d - 1) / 2;
        }

        if (totalEdges > Integer.MAX_VALUE) {
            throw new RuntimeException("Line graph is too large");
        }

        Graph res = new Graph(m, (int) totalEdges);

        int id = 0;

        for (int v = 0; v < g.n; v++) {

            ArrayList<Integer> incident = g.adj[v];

            for (int i = 0; i < incident.size(); i++) {
                for (int j = i + 1; j < incident.size(); j++) {

                    int e1 = incident.get(i);
                    int e2 = incident.get(j);

                    res.addEdge(id++, e1, e2);
                }
            }
        }

        return res;
    }

    static int oddCount(Graph g) {

        int count = 0;

        for (int v = 0; v < g.n; v++) {
            if ((g.adj[v].size() & 1) != 0) {
                count++;

                // We only care whether it is exactly 2.
                if (count > 2) {
                    return count;
                }
            }
        }

        return count;
    }

    static boolean hasEulerTrail(Graph g) {
        return oddCount(g) <= 2;
    }

    static int trailingPathLength(Graph g, int start) {

        int length = 0;

        int prev = -1;
        int cur = start;

        while (true) {
            length++;

            int next = -1;

            for (int edgeId : g.adj[cur]) {

                int a = g.eu[edgeId];
                int b = g.ev[edgeId];

                int to = (a == cur ? b : a);

                if (to != prev) {
                    next = to;
                    break;
                }
            }

            if (next == -1) {
                return length;
            }

            prev = cur;
            cur = next;
            if (g.degree(cur) != 2) {
                return length;
            }
        }
    }

    static int[] getTwoTrailingPaths(Graph g) {

        ArrayList<Integer> leaves = new ArrayList<>();

        for (int v = 0; v < g.n; v++) {
            if (g.degree(v) == 1) {
                leaves.add(v);

                if (leaves.size() > 2) {
                    return null;
                }
            }
        }

        if (leaves.size() != 2) {
            return null;
        }

        int l1 = trailingPathLength(g, leaves.get(0));
        int l2 = trailingPathLength(g, leaves.get(1));

        return new int[]{l1, l2};
    }

    static boolean specialAdjacentOddCase(Graph g) {

        ArrayList<Integer> odd = new ArrayList<>();

        for (int v = 0; v < g.n; v++) {
            if ((g.degree(v) & 1) != 0) {
                odd.add(v);
            }
        }

        if (odd.size() != 2) {
            return false;
        }

        int a = odd.get(0);
        int b = odd.get(1);

        if (!((g.degree(a) == 1 && g.degree(b) == 3) ||
              (g.degree(a) == 3 && g.degree(b) == 1))) {
            return false;
        }

        for (int edgeId : g.adj[a]) {
            int u = g.eu[edgeId];
            int v = g.ev[edgeId];

            int other = (u == a ? v : u);

            if (other == b) {
                return true;
            }
        }

        return false;
    }

    public static boolean solve(
            int n,
            int[][] edges,
            int k) {

        Graph g = new Graph(n, edges.length);

        for (int i = 0; i < edges.length; i++) {
            g.addEdge(i, edges[i][0], edges[i][1]);
        }

        if (k == 0) {
            return true;
        }

        if (oddCount(g) == 0) {
            return true;
        }

        Graph l1 = lineGraph(g);

        boolean e1 = hasEulerTrail(l1);

        if (k == 1) {
            return e1;
        }

        Graph l2 = lineGraph(l1);

        boolean e2 = hasEulerTrail(l2);

        if (k == 2) {
            return e2;
        }

        Graph l3 = lineGraph(l2);

        boolean e3 = hasEulerTrail(l3);

        if (k == 3) {
            return e3;
        }

        if (!e2) {
            return false;
        }


        if (!e3) {
            return false;
        }

        int[] paths = getTwoTrailingPaths(l2);

        if (paths == null) {
            return specialAdjacentOddCase(l2) ? false : false;
        }

        int minLength = Math.min(paths[0], paths[1]);

        return k <= 2 + minLength;
    }
}