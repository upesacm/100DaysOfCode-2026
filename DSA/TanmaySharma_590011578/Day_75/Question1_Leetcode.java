class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();

        List<Integer>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            indegree[v]++;
        }

       
        int[][] dp = new int[n][26];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }

        
            dp[i][colors.charAt(i) - 'a'] = 1;
        }

        int processed = 0;
        int answer = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            processed++;

         
            for (int c = 0; c < 26; c++) {
                answer = Math.max(answer, dp[u][c]);
            }

            for (int v : graph[u]) {

                int vColor = colors.charAt(v) - 'a';

                for (int c = 0; c < 26; c++) {
                    int value = dp[u][c];

                    if (c == vColor) {
                        value++;
                    }

                    dp[v][c] = Math.max(dp[v][c], value);
                }

                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        if (processed != n) {
            return -1;
        }

        return answer;
    }
}