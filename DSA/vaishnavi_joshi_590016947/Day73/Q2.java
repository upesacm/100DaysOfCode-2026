import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            List<List<Integer>> graph = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
            }

            // Undirected graph
            for (int i = 0; i < M; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            int S = sc.nextInt();

            int[] dist = new int[N];
            Arrays.fill(dist, -1);

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(S);
            dist[S] = 0;

            // BFS
            while (!queue.isEmpty()) {
                int u = queue.poll();

                for (int v : graph.get(u)) {
                    if (dist[v] == -1) {
                        dist[v] = dist[u] + 1;
                        queue.offer(v);
                    }
                }
            }

            // Print distances from S, excluding S
            for (int i = 1; i <= N; i++) {
                if (i != S) {
                    System.out.print(dist[i] + " ");
                }
            }

            System.out.println();
        }

        sc.close();
    }
}