import java.util.*;

class Solution {

    public boolean hasEulerTrail(int n, int[][] edges, int k) {

        List<Set<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        // Original graph
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Convert to line graph k times
        for (int step = 0; step < k; step++) {
            graph = lineGraph(graph);
        }

        return canHaveEulerTrail(graph);
    }

    private List<Set<Integer>> lineGraph(List<Set<Integer>> graph) {

        int n = graph.size();

        // Store all edges of the current graph
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j : graph.get(i)) {
                if (i < j) {
                    edges.add(new int[]{i, j});
                }
            }
        }

        int m = edges.size();

        List<Set<Integer>> newGraph = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            newGraph.add(new HashSet<>());
        }

        // Two line-graph vertices are adjacent
        // if their original edges share a vertex.
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {

                int a = edges.get(i)[0];
                int b = edges.get(i)[1];

                int c = edges.get(j)[0];
                int d = edges.get(j)[1];

                if (a == c || a == d || b == c || b == d) {
                    newGraph.get(i).add(j);
                    newGraph.get(j).add(i);
                }
            }
        }

        return newGraph;
    }

    private boolean canHaveEulerTrail(List<Set<Integer>> graph) {

        if (graph.isEmpty()) {
            return true;
        }

        // Check connectivity
        boolean[] visited = new boolean[graph.size()];
        int start = -1;

        for (int i = 0; i < graph.size(); i++) {
            if (!graph.get(i).isEmpty()) {
                start = i;
                break;
            }
        }

        // Graph with vertices but no edges
        if (start == -1) {
            return true;
        }

        dfs(start, graph, visited);

        for (int i = 0; i < graph.size(); i++) {
            if (!graph.get(i).isEmpty() && !visited[i]) {
                return false;
            }
        }

        // Count odd-degree vertices
        int odd = 0;

        for (Set<Integer> neighbors : graph) {
            if (neighbors.size() % 2 != 0) {
                odd++;

                if (odd > 2) {
                    return false;
                }
            }
        }

        return odd == 0 || odd == 2;
    }

    private void dfs(int node,
                     List<Set<Integer>> graph,
                     boolean[] visited) {

        visited[node] = true;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next, graph, visited);
            }
        }
    }
}