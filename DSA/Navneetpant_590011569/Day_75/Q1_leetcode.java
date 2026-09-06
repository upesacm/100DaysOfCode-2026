class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            indegree[v]++;
        }

        int[][] dp = new int[n][26];

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int processed = 0;
        int answer = 0;

        while (!q.isEmpty()) {

            int u = q.poll();
            processed++;

            int color = colors.charAt(u) - 'a';

            dp[u][color]++;

            answer = Math.max(answer, dp[u][color]);

            for (int v : graph.get(u)) {

                for (int c = 0; c < 26; c++) {
                    dp[v][c] = Math.max(dp[v][c], dp[u][c]);
                    answer = Math.max(answer, dp[v][c]);
                }

                indegree[v]--;

                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        if (processed != n) {
            return -1;
        }

        return answer;
    }
}