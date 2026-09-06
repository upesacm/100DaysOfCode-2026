import java.util.*;

public class Question2 {

    public static int[] shortestDistances(int n, ArrayList<Integer>[] graph, int start) {

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        boolean[] visited = new boolean[n + 1];

        TreeSet<Integer> unvisited = new TreeSet<>();

        for (int i = 1; i <= n; i++) {
            if (i != start) {
                unvisited.add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        dist[start] = 0;
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {

            int current = queue.poll();

            ArrayList<Integer> nextLevel = new ArrayList<>();

            for (int node : unvisited) {

                // No main road between current and node
                if (!graph[current].contains(node)) {
                    dist[node] = dist[current] + 1;
                    visited[node] = true;
                    nextLevel.add(node);
                }
            }

            for (int node : nextLevel) {
                unvisited.remove(node);
                queue.offer(node);
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }

        int start = sc.nextInt();

        int[] dist = shortestDistances(n, graph, start);

        for (int i = 1; i <= n; i++) {

            if (i == start) {
                continue;
            }

            System.out.print(dist[i]);

            if (i != n) {
                System.out.print(" ");
            }
        }

        System.out.println();

        sc.close();
    }
}