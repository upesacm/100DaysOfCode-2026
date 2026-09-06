import java.util.*;

public class Question1_Leetcode {

    static int largestPathValue(String colors, int[][] edges) {

        int n = colors.length();

        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];

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
        }

        int processed = 0;
        int answer = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();
            processed++;

            int color = colors.charAt(node) - 'a';

            dp[node][color]++;

            answer = Math.max(answer, dp[node][color]);

            for (int next : graph[node]) {

                for (int c = 0; c < 26; c++) {
                    dp[next][c] = Math.max(dp[next][c], dp[node][c]);
                }

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // If all nodes were not processed, a cycle exists.
        if (processed != n) {
            return -1;
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String colors = sc.nextLine();

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] edges = new int[m][2];

        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        System.out.println(largestPathValue(colors, edges));

        sc.close();
    }
}