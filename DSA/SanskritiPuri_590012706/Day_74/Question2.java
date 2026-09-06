import java.util.*;

public class Main {

    static int N, T;
    static List<Integer>[] graph;
    static int[] match;
    static boolean[] visited;

    static boolean dfs(int head) {
        for (int foot : graph[head]) {
            if (visited[foot]) continue;

            visited[foot] = true;

            if (match[foot] == -1 || dfs(match[foot])) {
                match[foot] = head;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while (C-- > 0) {
            N = sc.nextInt();
            T = sc.nextInt();
            int M = sc.nextInt();

            graph = new ArrayList[N];

            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;

                graph[u].add(v);
                graph[v].add(u);
            }

            int maxCovered = 0;

            /*
             * Try every vertex as a possible head.
             * Each head can have at most T feet.
             */
            for (int head = 0; head < N; head++) {

                match = new int[N];
                Arrays.fill(match, -1);

                int feet = 0;

                for (int i = 0; i < N; i++) {
                    visited = new boolean[N];

                    if (dfs(i)) {
                        feet++;
                    }

                    if (feet == T) {
                        break;
                    }
                }

                if (feet > 0) {
                    maxCovered = Math.max(maxCovered, feet + 1);
                }
            }

            System.out.println(maxCovered);
        }

        sc.close();
    }
}
