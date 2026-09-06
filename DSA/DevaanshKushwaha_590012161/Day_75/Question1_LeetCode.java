import java.util.*;

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n];

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }

        // count[u][c] = max number of nodes with color c on any path ending at u
        int[][] count = new int[n][26];

        Deque<Integer> queue = new ArrayDeque<>();
        for (int u = 0; u < n; u++) {
            if (indegree[u] == 0) queue.offer(u);
        }

        int visited = 0;
        int maxValue = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited++;

            int cIdx = colors.charAt(u) - 'a';
            count[u][cIdx]++;
            maxValue = Math.max(maxValue, count[u][cIdx]);

            for (int v : adj.get(u)) {
                for (int c = 0; c < 26; c++) {
                    count[v][c] = Math.max(count[v][c], count[u][c]);
                }
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == n ? maxValue : -1;
    }
}
