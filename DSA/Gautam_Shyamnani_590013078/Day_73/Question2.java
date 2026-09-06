import java.util.*;

public class Question2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
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
        dist[start] = 0;

        TreeSet<Integer> unvisited = new TreeSet<>();

        for (int i = 1; i <= n; i++) {
            if (i != start) {
                unvisited.add(i);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        int[] mark = new int[n + 1];
        int currentMark = 0;

        while (!queue.isEmpty()) {

            int u = queue.poll();

            currentMark++;

            for (int v : graph.get(u)) {
                mark[v] = currentMark;
            }

            Iterator<Integer> it = unvisited.iterator();

            while (it.hasNext()) {

                int v = it.next();

                if (mark[v] != currentMark) {

                    dist[v] = dist[u] + 1;

                    queue.add(v);

                    it.remove();
                }
            }
        }

        boolean first = true;

        for (int i = 1; i <= n; i++) {

            if (i == start) {
                continue;
            }

            if (!first) {
                System.out.print(" ");
            }

            System.out.print(dist[i]);
            first = false;
        }

        System.out.println();

        sc.close();
    }
}