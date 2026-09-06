import java.util.*;

class Solution {
    public int[] shortestPath(int n, int m, int[][] edges, int s) {
        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Main roads
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            u--;
            v--;

            adj[u].add(v);
            adj[v].add(u);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        TreeSet<Integer> unvisited = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            unvisited.add(i);
        }

        Queue<Integer> queue = new LinkedList<>();

        s--; 

        dist[s] = 0;
        queue.offer(s);
        unvisited.remove(s);

        boolean[] blocked = new boolean[n];

        while (!queue.isEmpty()) {

            int u = queue.poll();

            for (int v : adj[u]) {
                blocked[v] = true;
            }
            Iterator<Integer> it = unvisited.iterator();

            while (it.hasNext()) {

                int v = it.next();

                if (!blocked[v]) {
                    dist[v] = dist[u] + 1;
                    queue.offer(v);

                    it.remove();
                }
            }

            for (int v : adj[u]) {
                blocked[v] = false;
            }
        }

        int[] answer = new int[n - 1];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (i != s) {
                answer[idx++] = dist[i];
            }
        }

        return answer;
    }
}