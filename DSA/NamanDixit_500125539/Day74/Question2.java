import java.util.*;

public class Question2 {

    /*
     * A crab has:
     * 1 head
     * Up to T feet
     *
     * Every foot must be directly connected to the head.
     *
     * We use a simple greedy approach:
     * - Try every vertex as a head.
     * - Give the head as many unused neighbours as possible as feet.
     * - Once a vertex is used, it cannot be used again.
     *
     * C is the number of test cases.
     */

    public static void main(String[] args) {

        // Scanner is used to take input from the user
        Scanner sc = new Scanner(System.in);

        // Number of test cases
        int C = sc.nextInt();

        // Process every test case
        while (C-- > 0) {

            // Number of vertices
            int N = sc.nextInt();

            // Maximum number of feet for one crab
            int T = sc.nextInt();

            // Number of edges
            int M = sc.nextInt();

            // Create adjacency list
            // graph[i] contains all vertices connected to vertex i
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            // Create an empty list for every vertex
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            // Take all edges as input
            for (int i = 0; i < M; i++) {

                // First vertex
                int u = sc.nextInt();

                // Second vertex
                int v = sc.nextInt();

                // The graph is undirected,
                // so add both directions
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            // used[i] tells whether vertex i
            // is already part of a crab
            boolean[] used = new boolean[N + 1];

            // This stores the maximum number of
            // vertices covered by crabs
            int answer = 0;

            /*
             * Try every vertex as a possible head.
             */
            for (int head = 1; head <= N; head++) {

                // If the head is already used,
                // we cannot use it again
                if (used[head]) {
                    continue;
                }

                // Count how many feet this crab has
                int feet = 0;

                /*
                 * Look at all neighbours of this head.
                 */
                for (int neighbour : graph.get(head)) {

                    // We can use this neighbour as a foot
                    // only if it has not already been used
                    if (!used[neighbour]) {

                        // Mark the foot as used
                        used[neighbour] = true;

                        // Increase number of feet
                        feet++;

                        // One head + this foot
                        // increases the covered vertices
                        answer++;

                        // A crab can have at most T feet
                        if (feet == T) {
                            break;
                        }
                    }
                }

                /*
                 * If this head got at least one foot,
                 * then the head is also part of the crab.
                 */
                if (feet > 0) {

                    // Mark the head as used
                    used[head] = true;

                    // Add the head to the answer
                    answer++;
                }
            }

            // Print the maximum number of covered vertices
            System.out.println(answer);
        }

        // Close Scanner
        sc.close();
    }
}

/*
Example:

Input:
1
4
1
2
1 2
3 4

Explanation:

T = 1
So every crab can have maximum 1 foot.

Edge 1-2:
    1 (Head)
    |
    2 (Foot)

This crab covers 2 vertices.

Edge 3-4:
    3 (Head)
    |
    4 (Foot)

This crab covers 2 vertices.

Total covered vertices = 2 + 2 = 4

Output:
4
*/