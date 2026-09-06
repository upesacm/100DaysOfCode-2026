package Day_75;
import java.util.*;
class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        int[][] dp = new int[n][26];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        int answer = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            int color = colors.charAt(node) - 'a';
            dp[node][color]++;
            answer = Math.max(answer, dp[node][color]);
            for (int next : graph.get(node)) {
                for (int c = 0; c < 26; c++) {
                    dp[next][c] = Math.max(dp[next][c], dp[node][c]);
                }
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        if (count != n) {
            return -1;
        }
        return answer;
    }
}