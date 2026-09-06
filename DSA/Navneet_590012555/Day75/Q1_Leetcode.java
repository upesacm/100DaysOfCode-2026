class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();

        ArrayList<Integer>[] g = new ArrayList[n];
        int[] in = new int[n];
        int[][] dp = new int[n][26];

        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<>();

        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            in[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                q.offer(i);
                dp[i][colors.charAt(i) - 'a'] = 1;
            }
        }

        int count = 0;
        int ans = 0;

        while (!q.isEmpty()) {
            int x = q.poll();
            count++;

            for (int c = 0; c < 26; c++)
                ans = Math.max(ans, dp[x][c]);

            for (int y : g[x]) {

                for (int c = 0; c < 26; c++) {
                    int add = (colors.charAt(y) - 'a' == c) ? 1 : 0;
                    dp[y][c] = Math.max(dp[y][c], dp[x][c] + add);
                }

                in[y]--;

                if (in[y] == 0)
                    q.offer(y);
            }
        }

        if (count != n)
            return -1;

        return ans;
    }
