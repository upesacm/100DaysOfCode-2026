import java.util.*;

class Solution {
    public int[] findClusters(int N, int[][] roads) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0] - 1;
            int v = road[1] - 1;

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[N];
        int clusters = 0;
        int largest = 0;

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                clusters++;
                int size = 0;

                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    size++;

                    for (int next : graph.get(node)) {
                        if (!visited[next]) {
                            visited[next] = true;
                            queue.add(next);
                        }
                    }
                }

                largest = Math.max(largest, size);
            }
        }

        return new int[]{clusters, largest};
    }
}
