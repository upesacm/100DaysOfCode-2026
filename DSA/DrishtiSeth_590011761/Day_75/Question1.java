import java.util.*;

class Solution {

    public int largestPathValue(String colors, int[][] edges) {

        int n = colors.length();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        // Build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            indegree[v]++;
        }

        // count[i][j] = maximum occurrences of color j
        // in a path ending at node i
        int[][] count = new int[n][26];

        Queue<Integer> queue = new LinkedList<>();

        // Add all nodes with indegree 0
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int processedNodes = 0;
        int answer = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();
            processedNodes++;

            int color = colors.charAt(node) - 'a';

            // Include current node's color
            count[node][color]++;

            // Update answer
            for (int i = 0; i < 26; i++) {
                answer = Math.max(answer, count[node][i]);
            }

            // Process neighbours
            for (int neighbour : graph.get(node)) {

                // Transfer maximum color frequencies
                for (int i = 0; i < 26; i++) {
                    count[neighbour][i] =
                            Math.max(count[neighbour][i], count[node][i]);
                }

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        // If not all nodes were processed, cycle exists
        if (processedNodes != n) {
            return -1;
        }

        return answer;
    }
}
