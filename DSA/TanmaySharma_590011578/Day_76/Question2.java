
import java.util.*;

public class Question2 {

    static ArrayList<Integer>[] createGraph(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        return graph;
    }

    static int[][] lineGraph(int n, int[][] edges) {
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            for (int j = i + 1; j < edges.length; j++) {
                if (edges[i][0] == edges[j][0] ||
                    edges[i][0] == edges[j][1] ||
                    edges[i][1] == edges[j][0] ||
                    edges[i][1] == edges[j][1]) {
                    list.add(new int[]{i, j});
                }
            }
        }

        int[][] result = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    static boolean hasEulerTrail(int n, int[][] edges) {
        ArrayList<Integer>[] graph = createGraph(n, edges);

        int start = -1;

        for (int i = 0; i < n; i++) {
            if (graph[i].size() > 0) {
                start = i;
                break;
            }
        }

        if (start == -1) {
            return true;
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (graph[i].size() > 0 && !visited[i]) {
                return false;
            }
        }

        int odd = 0;

        for (int i = 0; i < n; i++) {
            if (graph[i].size() % 2 != 0) {
                odd++;
            }
        }

        return odd == 0 || odd == 2;
    }

    static boolean solve(int n, int[][] edges, int k) {
        int currentN = n;
        int[][] currentEdges = edges;

        for (int i = 0; i < k; i++) {
            currentN = currentEdges.length;
            currentEdges = lineGraph(currentN, currentEdges);
        }

        return hasEulerTrail(currentN, currentEdges);
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
