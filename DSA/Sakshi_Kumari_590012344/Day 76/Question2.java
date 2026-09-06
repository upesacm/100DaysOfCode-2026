import java.util.*;

class Solution {

    public boolean hasEulerTrail(int n, int[][] edges, int k) {
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        while (k-- > 0) {
            graph = makeLineGraph(graph);
        }

        int odd = 0;

        for (int i = 0; i < graph.length; i++) {
            if (graph[i].size() % 2 != 0) {
                odd++;
            }
        }

        if (odd != 0 && odd != 2) {
            return false;
        }

        int start = -1;

        for (int i = 0; i < graph.length; i++) {
            if (graph[i].size() > 0) {
                start = i;
                break;
            }
        }

        if (start == -1) {
            return true;
        }

        boolean[] visited = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }

        for (int i = 0; i < graph.length; i++) {
            if (graph[i].size() > 0 && !visited[i]) {
                return false;
            }
        }

        return true;
    }

    private List<Integer>[] makeLineGraph(List<Integer>[] graph) {

        int n = graph.length;

        ArrayList<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                if (i < j) {
                    edges.add(new int[]{i, j});
                }
            }
        }

        int m = edges.size();

        List<Integer>[] newGraph = new ArrayList[m];

        for (int i = 0; i < m; i++) {
            newGraph[i] = new ArrayList<>();
        }

        ArrayList<Integer>[] connected = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            connected[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = edges.get(i)[0];
            int v = edges.get(i)[1];

            connected[u].add(i);
            connected[v].add(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < connected[i].size(); j++) {
                for (int l = j + 1; l < connected[i].size(); l++) {

                    int a = connected[i].get(j);
                    int b = connected[i].get(l);

                    newGraph[a].add(b);
                    newGraph[b].add(a);
                }
            }
        }

        return newGraph;
    }
}
