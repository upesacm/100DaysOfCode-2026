import java.io.*;
import java.util.*;

public class AdityaChase {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // If the input starts with T, use the first line as T.
        // Otherwise, this problem's format is N M directly.
        String firstLine = br.readLine().trim();
        StringTokenizer st = new StringTokenizer(firstLine);

        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        /*
         * The statement is ambiguous about T.
         *
         * If the first line has only N M, then:
         * first = N
         * second = M
         *
         * If your actual platform has T test cases, use the
         * alternative code mentioned below.
         */

        int n = first;
        int m = second;

        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        int s = Integer.parseInt(br.readLine().trim());

        int[] distance = bfsComplementGraph(graph, n, s);

        StringBuilder answer = new StringBuilder();

        // Print distances excluding S
        for (int i = 1; i <= n; i++) {
            if (i == s) {
                continue;
            }

            if (answer.length() > 0) {
                answer.append(" ");
            }

            answer.append(distance[i]);
        }

        System.out.println(answer);
    }

    static int[] bfsComplementGraph(List<Integer>[] graph, int n, int start) {

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        /*
         * unvisited contains all vertices that have not yet
         * been reached by BFS.
         *
         * TreeSet lets us efficiently remove vertices.
         */
        TreeSet<Integer> unvisited = new TreeSet<>();

        for (int i = 1; i <= n; i++) {
            if (i != start) {
                unvisited.add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        distance[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {

            int current = queue.poll();

            /*
             * Mark all main-road neighbours of current.
             *
             * We cannot move to these vertices using a village road.
             */
            HashSet<Integer> mainRoadNeighbours = new HashSet<>();

            for (int neighbour : graph[current]) {
                mainRoadNeighbours.add(neighbour);
            }

            /*
             * Every unvisited vertex which is NOT a main-road
             * neighbour is connected to current by a village road.
             */
            ArrayList<Integer> reached = new ArrayList<>();

            for (int vertex : unvisited) {

                if (!mainRoadNeighbours.contains(vertex)) {

                    distance[vertex] = distance[current] + 1;

                    queue.offer(vertex);

                    reached.add(vertex);
                }
            }

            /*
             * Remove newly discovered vertices from unvisited.
             */
            for (int vertex : reached) {
                unvisited.remove(vertex);
            }
        }

        return distance;
    }
}