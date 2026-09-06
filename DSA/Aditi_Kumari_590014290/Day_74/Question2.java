package Day_74;

import java.util.*;

class Question2 {
    public static int crabGraph(int C, int N, int T, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] used = new boolean[N + 1];
        int covered = 0;

        for (int i = 1; i <= N; i++) {
            if (used[i]) {
                continue;
            }

            int feet = 0;

            for (int neighbour : graph.get(i)) {
                if (!used[neighbour] && feet < T) {
                    used[neighbour] = true;
                    feet++;
                }
            }

            if (feet > 0) {
                used[i] = true;
                covered += feet + 1;
            }
        }

        return covered;
    }

    public static void main(String[] args) {
        int C = 1;
        int N = 4;
        int T = 1;

        int[][] edges = {
            {1, 2},
            {3, 4}
        };

        System.out.println(crabGraph(C, N, T, edges));
    }
}