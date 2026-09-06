import java.util.*;

public class KthLineGraphEuler {

    static class Graph {
        int numVertices;
        List<int[]> edges;
        Graph(int numVertices, List<int[]> edges) {
            this.numVertices = numVertices;
            this.edges = edges;
        }
    }

    // Build L(G): vertices of L(G) = edges of G; connect edges sharing an endpoint.
    static Graph buildLineGraph(Graph g) {
        int m = g.edges.size();
        List<List<Integer>> incident = new ArrayList<>();
        for (int i = 0; i < g.numVertices; i++) incident.add(new ArrayList<>());

        for (int idx = 0; idx < m; idx++) {
            int[] e = g.edges.get(idx);
            incident.get(e[0]).add(idx);
            incident.get(e[1]).add(idx);
        }

        List<int[]> lineEdges = new ArrayList<>();
        for (List<Integer> inc : incident) {
            int d = inc.size();
            for (int i = 0; i < d; i++)
                for (int j = i + 1; j < d; j++)
                    lineEdges.add(new int[]{inc.get(i), inc.get(j)});
        }
        return new Graph(m, lineEdges);
    }

    // degree[] + odd-count + connectivity (ignoring isolated vertices)
    static int[] degrees(Graph g) {
        int[] deg = new int[g.numVertices];
        for (int[] e : g.edges) { deg[e[0]]++; deg[e[1]]++; }
        return deg;
    }

    static boolean isConnectedOverEdgeVertices(Graph g, int[] deg) {
        int n = g.numVertices;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int[] e : g.edges) union(parent, e[0], e[1]);

        int root = -1;
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) continue;
            int r = find(parent, i);
            if (root == -1) root = r;
            else if (root != r) return false;
        }
        return true;
    }

    static int find(int[] p, int x) { while (p[x] != x) { p[x] = p[p[x]]; x = p[x]; } return x; }
    static void union(int[] p, int a, int b) { int ra = find(p,a), rb = find(p,b); if (ra != rb) p[ra] = rb; }

    static boolean allEven(int[] deg) {
        for (int d : deg) if (d % 2 != 0) return false;
        return true;
    }

    static boolean hasEulerTrail(Graph g) {
        if (g.numVertices == 0 || g.edges.isEmpty()) return true; // trivial
        int[] deg = degrees(g);
        if (!isConnectedOverEdgeVertices(g, deg)) return false;
        int odd = 0;
        for (int d : deg) if (d % 2 != 0) odd++;
        return odd == 0 || odd == 2;
    }

    public static boolean kthLineGraphHasEulerTrail(int n, int[][] edges1Indexed, int k) {
        List<int[]> edgeList = new ArrayList<>();
        for (int[] e : edges1Indexed) edgeList.add(new int[]{e[0] - 1, e[1] - 1});
        Graph g = new Graph(n, edgeList);

        int steps = 0;
        while (steps < k) {
            if (g.edges.isEmpty()) break; // no edges left to transform meaningfully

            int[] deg = degrees(g);
            // Shortcut: if already Eulerian circuit & connected -> stays true forever
            if (allEven(deg) && isConnectedOverEdgeVertices(g, deg)) {
                return true;
            }
            g = buildLineGraph(g);
            steps++;
        }
        return hasEulerTrail(g);
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {4, 1}};
        int k = 1;
        System.out.println(kthLineGraphHasEulerTrail(n, edges, k)); // true
    }
}
