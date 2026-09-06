
import java.util.*;
class CC{
    static List<Integer>[] graph; static boolean[] used; static int T;
    static int solve(int n){
        int covered = 0;
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            covered++;
            int feet = 0;
            for (int neighbor : graph[i]) {
                if (!used[neighbor] && feet < T) {
                    used[neighbor] = true;
                    covered++;
                    feet++;
                }
            }
        }
        return covered;
    }
    public static void main(String[] args){
        int C = 1;int N = 4;T = 1;int M = 2;
        int[][] edges = { {1, 2},{3, 4}};
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        used = new boolean[N + 1];
        int answer = solve(N);
        System.out.println("Maximum covered vertices:" + answer);
    }
}