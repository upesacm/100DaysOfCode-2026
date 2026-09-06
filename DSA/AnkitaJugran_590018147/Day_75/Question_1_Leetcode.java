import java.util.*;

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();

        List<Integer>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build graph and indegree array
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            indegree[v]++;
        }

        // dp[node][color] = maximum number of that color
        // on any path ending at 'node'
        int[][] dp = new int[n][26];

        Queue<Integer> queue = new ArrayDeque<>();

        // Start with nodes having no incoming edges
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);

                int color = colors.charAt(i) - 'a';
                dp[i][color] = 1;
            }
        }

        int processed = 0;
        int answer = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            processed++;

            // Update maximum color value
            for (int c = 0; c < 26; c++) {
                answer = Math.max(answer, dp[u][c]);
            }

            for (int v : graph[u]) {
                int vColor = colors.charAt(v) - 'a';

                // Extend paths from u to v
                for (int c = 0; c < 26; c++) {
                    dp[v][c] = Math.max(
                        dp[v][c],
                        dp[u][c] + (c == vColor ? 1 : 0)
                    );
                }

                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        // Not all nodes processed => graph contains a cycle
        if (processed != n) {
            return -1;
        }

        return answer;
    }
}