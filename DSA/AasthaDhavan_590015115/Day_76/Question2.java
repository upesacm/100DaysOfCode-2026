import java.util.*;
class Question2 {
    static boolean hasEulerTrail(int n, List<int[]> edges) {
        if (edges.isEmpty()) return true;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int start = -1;
        for (int i = 0; i < n; i++) {
            if (!adj.get(i).isEmpty()) {
                start = i;
                break;
            }
        }
        if (start == -1) return true;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!adj.get(i).isEmpty() && !visited[i]) {
                return false;
            }
        }

        int odd = 0;
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() % 2 != 0) {
                odd++;
            }
        }
        return odd == 0 || odd == 2;
    }
    static List<int[]> lineGraph(List<int[]> edges) {
        List<int[]> next = new ArrayList<>();
        for (int i = 0; i < edges.size(); i++) {
            for (int j = i + 1; j < edges.size(); j++) {
                int a = edges.get(i)[0];
                int b = edges.get(i)[1];
                int c = edges.get(j)[0];
                int d = edges.get(j)[1];
                if (a == c || a == d || b == c || b == d) {
                    next.add(new int[]{i, j});
                }
            }
        }
        return next;
    }
    static boolean solve(int n, int[][] inputEdges, int k) {
        List<int[]> edges = new ArrayList<>();
        for (int[] e : inputEdges) {
            edges.add(new int[]{e[0], e[1]});
        }
        int vertices = n;
        for (int i = 0; i < k; i++) {
            edges = lineGraph(edges);
            vertices = inputEdges.length;
            if (edges.isEmpty()) {
                return true;
            }
            int maxVertex = -1;
            for (int[] e : edges) {
                maxVertex = Math.max(maxVertex, Math.max(e[0], e[1]));
            }
            vertices = maxVertex + 1;
        }
        return hasEulerTrail(vertices, edges);
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 0}
        };
        int k = 1;
        System.out.println(solve(n, edges, k));
    }
}