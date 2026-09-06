public class Question1_LeetCode {
    public int largestPathValue(String colors, int[][] edge) {
        int n = colors.length(), m = edge.length;
        int[] head = new int[n];
        int[] to = new int[m];
        int[] next = new int[m];
        int[] indegree = new int[n];

        java.util.Arrays.fill(head, -1);

        for (int i = 0; i < m; i++) {
            int u = edge[i][0], v = edge[i][1];
            to[i] = v;
            next[i] = head[u];
            head[u] = i;
            indegree[v]++;
        }

        int[] dp = new int[n * 26];
        int[] queue = new int[n];
        int front = 0, end = 0;

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue[end++] = i;
                dp[i * 26 + colors.charAt(i) - 'a'] = 1;
            }
        }
        int processed = 0;
        int answer = 0;

        while (front < end) {
            int u = queue[front++];
            processed++;
            int baseU = u * 26;

            for (int c = 0; c < 26; c++) {
                answer = Math.max(answer, dp[baseU + c]);
            }

            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];
                int baseV = v * 26;

                for (int c = 0; c < 26; c++) {
                    int value = dp[baseU + c];
                    if (value > dp[baseV + c])
                        dp[baseV + c] = value;
                }
                int color = colors.charAt(v) - 'a';
                int value = dp[baseU + color] + 1;
                if (value > dp[baseV + color])
                    dp[baseV + color] = value;

                if (--indegree[v] == 0)
                    queue[end++] = v;
            }
        }
        return processed == n ? answer : -1;
    }
}