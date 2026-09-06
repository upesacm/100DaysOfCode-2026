import java.util.*;

class Solution {

    public int maxVertices(int C, int N, int T, int M, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] used = new boolean[N + 1];
        int covered = 0;

        // C = maximum number of crabs
        int crabs = 0;

        for (int head = 1; head <= N && crabs < C; head++) {

            if (used[head])
                continue;

            int feet = 0;

            for (int neighbor : graph.get(head)) {

                if (feet == T)
                    break;

                if (!used[neighbor]) {
                    used[neighbor] = true;
                    feet++;
                }
            }

            if (feet > 0) {
                used[head] = true;
                covered += 1 + feet;
                crabs++;
            }
        }

        return covered;
    }
}