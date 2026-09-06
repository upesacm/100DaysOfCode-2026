import java.util.*;

class Solution {
    public int maxCrabs(int n, int[][] edges, int T) {
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] used = new boolean[n];
        int answer = 0;

        for (int head = 0; head < n; head++) {
            if (used[head]) {
                continue;
            }

            int feet = 0;

            for (int neighbor : graph[head]) {
                if (!used[neighbor] && neighbor != head) {
                    used[neighbor] = true;
                    feet++;

                    if (feet == T) {
                        break;
                    }
                }
            }

            if (feet > 0) {
                used[head] = true;
                answer += 1 + feet;
            }
        }

        return answer;
    }
}
