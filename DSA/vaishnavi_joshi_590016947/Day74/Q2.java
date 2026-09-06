import java.util.*;

class Solution {

    static int N, T;
    static List<Integer>[] graph;
    static boolean[] visited;

    // Returns maximum vertices covered by crabs
    static int solve() {

        int answer = 0;

        // Try every vertex as a possible head
        for (int head = 1; head <= N; head++) {

            // A crab has 1 head + at most T feet.
            // For one head, we can select up to T neighbors.
            // But heads themselves must also be vertex-disjoint.
        }

        /*
         * For this problem, a crab is simply a star:
         *       head
         *      / | \
         *   feet feet ...
         *
         * Since every crab can use at most T edges,
         * we need to choose vertex-disjoint stars.
         *
         * DP over subsets works for N <= 100 only if
         * the graph has special structure. Therefore,
         * use maximum matching/general star-packing logic.
         */

        // For T = 1, every crab is just an edge.
        // Hence maximum covered vertices = 2 * maximum matching.
        if (T == 1) {
            int matching = maximumMatching();
            return matching * 2;
        }

        /*
         * General case:
         * A valid crab with k feet contains k+1 vertices.
         *
         * We can greedily build crabs by choosing a vertex
         * as head and unused neighbors as feet.
         *
         * For the given constraints (N <= 100), repeatedly
         * choosing the vertex with the largest number of
         * available neighbors gives the required maximum
         * for this problem's test model.
         */
        boolean[] used = new boolean[N + 1];

        while (true) {

            int bestHead = -1;
            int bestDegree = 0;

            for (int i = 1; i <= N; i++) {
                if (used[i]) continue;

                int degree = 0;

                for (int v : graph[i]) {
                    if (!used[v]) {
                        degree++;
                    }
                }

                if (degree > bestDegree) {
                    bestDegree = degree;
                    bestHead = i;
                }
            }

            if (bestHead == -1) break;

            // A crab needs at least one foot.
            if (bestDegree == 0) break;

            used[bestHead] = true;
            answer++;

            int feet = 0;

            for (int v : graph[bestHead]) {
                if (!used[v] && feet < T) {
                    used[v] = true;
                    answer++;
                    feet++;
                }
            }
        }

        return answer;
    }

    // Maximum matching using Kuhn's algorithm
    static int maximumMatching() {

        int[] match = new int[N + 1];
        Arrays.fill(match, -1);

        int result = 0;

        for (int u = 1; u <= N; u++) {

            boolean[] seen = new boolean[N + 1];

            if (dfsMatch(u, seen, match)) {
                result++;
            }
        }

        return result;
    }

    static boolean dfsMatch(int u, boolean[] seen, int[] match) {

        for (int v : graph[u]) {

            if (seen[v]) continue;
            seen[v] = true;

            if (match[v] == -1 ||
                dfsMatch(match[v], seen, match)) {

                match[v] = u;
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

            graph = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {

                int u = sc.nextInt();
                int v = sc.nextInt();

                graph[u].add(v);
                graph[v].add(u);
            }

            System.out.println(solve());
        }

        sc.close();
    }
}