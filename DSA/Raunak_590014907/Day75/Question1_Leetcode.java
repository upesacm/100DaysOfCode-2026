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

        // dp[node][color]
        // Maximum number of occurrences of 'color'
        // in a path ending at this node
        int[][] dp = new int[n][26];

        Queue<Integer> queue = new LinkedList<>();

        // Start with nodes having no incoming edges
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int processed = 0;
        int answer = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();
            processed++;

            int color = colors.charAt(node) - 'a';

            // Count the current node's color
            dp[node][color]++;

            answer = Math.max(answer, dp[node][color]);

            for (int next : graph.get(node)) {

                // Transfer all color counts to next node
                for (int c = 0; c < 26; c++) {
                    dp[next][c] =
                        Math.max(dp[next][c], dp[node][c]);
                }

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // If not all nodes were processed, graph contains a cycle
        if (processed != n) {
            return -1;
        }

        return answer;
    }
}