import java.util.*;
public class Question2 {
    static class Edge {
        int to, capacity, rev;

        Edge(int to, int capacity, int rev) {
            this.to = to;
            this.capacity = capacity;
            this.rev = rev;
        }
    }
    static ArrayList<Edge>[] graph;
    static int[] level, ptr;
    static void addEdge(int u, int v, int capacity) {
        Edge a = new Edge(v, capacity, graph[v].size());
        Edge b = new Edge(u, 0, graph[u].size());
        graph[u].add(a);
        graph[v].add(b);
    }
    static boolean bfs(int source, int sink) {
        Arrays.fill(level, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        level[source] = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (Edge e : graph[u]) {
                if (e.capacity > 0 && level[e.to] == -1) {
                    level[e.to] = level[u] + 1;
                    q.add(e.to);
                }
            }
        }
        return level[sink] != -1;
    }
    static int dfs(int u, int sink, int flow) {
        if (u == sink) return flow;
        while (ptr[u] < graph[u].size()) {
            Edge e = graph[u].get(ptr[u]);
            if (e.capacity > 0 && level[e.to] == level[u] + 1) {
                int pushed = dfs(e.to, sink, Math.min(flow, e.capacity));
                if (pushed > 0) {
                    e.capacity -= pushed;
                    graph[e.to].get(e.rev).capacity += pushed;
                    return pushed;
                }
            }
            ptr[u]++;
        }
        return 0;
    }
    static int maxFlow(int source, int sink) {
        int flow = 0;
        while (bfs(source, sink)) {
            Arrays.fill(ptr, 0);
            int pushed;
            while ((pushed = dfs(source, sink, Integer.MAX_VALUE)) > 0) {
                flow += pushed;
            }
        }
        return flow;
    }

    static int crabChaos(int n, int t, int[][] edges) {
        int source = 0;
        int sink = 2 * n + 1;
        int nodes = sink + 1;
        graph = new ArrayList[nodes];
        for (int i = 0; i < nodes; i++) {
            graph[i] = new ArrayList<>();
        }
        level = new int[nodes];
        ptr = new int[nodes];
        for (int i = 1; i <= n; i++) {
            addEdge(source, i, t);
            addEdge(n + i, sink, 1);
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            addEdge(u, n + v, 1);
            addEdge(v, n + u, 1);
        }
        return maxFlow(source, sink) * 2;
    }
public static void main(String[] args) {
        int C = 1;
        int N = 4;
        int T = 1;
        int M = 2;
        int[][] edges = {
            {1, 2},
            {3, 4}
        };
        System.out.println(crabChaos(N, T, edges));
    }
}