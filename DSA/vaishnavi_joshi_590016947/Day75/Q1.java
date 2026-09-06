import java.util.*;

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();

        List<Integer>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            indegree[v]++;
        }

        // dp[node][color] = maximum count of that color
        // on any path ending at node
        int[][] dp = new int[n][26];

        Queue<Integer> queue = new LinkedList<>();

        // Start with nodes having indegree 0
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

            // Include current node's color
            dp[node][color]++;

            answer = Math.max(answer, dp[node][color]);

            // Process neighbours
            for (int next : graph[node]) {

                // Update DP for every color
                for (int c = 0; c < 26; c++) {
                    dp[next][c] = Math.max(
                        dp[next][c],
                        dp[node][c]
                    );
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