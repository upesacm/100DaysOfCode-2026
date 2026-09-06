import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<Set<Integer>> graph = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                graph.add(new HashSet<>());
            }

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            int start = sc.nextInt();

            int[] dist = new int[n + 1];
            Arrays.fill(dist, -1);

            // Nodes that have not been visited yet
            TreeSet<Integer> unvisited = new TreeSet<>();

            for (int i = 1; i <= n; i++) {
                if (i != start) {
                    unvisited.add(i);
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            dist[start] = 0;

            while (!queue.isEmpty()) {
                int u = queue.poll();

                // Find nodes which are NOT connected to u
                Iterator<Integer> it = unvisited.iterator();

                while (it.hasNext()) {
                    int v = it.next();

                    // No main road means there is a village road
                    if (!graph.get(u).contains(v)) {
                        dist[v] = dist[u] + 1;
                        queue.offer(v);
                        it.remove();
                    }
                }
            }

            // Print distances excluding S
            StringBuilder ans = new StringBuilder();

            for (int i = 1; i <= n; i++) {
                if (i == start) {
                    continue;
                }

                if (ans.length() > 0) {
                    ans.append(" ");
                }

                ans.append(dist[i]);
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
