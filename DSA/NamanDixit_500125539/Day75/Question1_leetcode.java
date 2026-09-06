class Question1_leetcode {

    public int largestPathValue(String colors, int[][] edges) {

        // Number of nodes
        int n = colors.length();

        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        // Create an empty list for every node
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Store the number of incoming edges for every node
        int[] indegree = new int[n];

        // Build the graph
        for (int[] edge : edges) {

            int from = edge[0];
            int to = edge[1];

            // Add the directed edge
            graph.get(from).add(to);

            // Increase indegree of the destination
            indegree[to]++;
        }

        /*
         * dp[node][color]
         *
         * Stores the maximum number of a particular color
         * on a path ending at this node.
         *
         * 26 columns = a to z
         */
        int[][] dp = new int[n][26];

        // Queue for Topological Sort
        Queue<Integer> queue = new LinkedList<>();

        // Add all nodes having no incoming edge
        for (int i = 0; i < n; i++) {

            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Count how many nodes we process
        int processed = 0;

        // Store the final answer
        int answer = 0;

        // Process the graph
        while (!queue.isEmpty()) {

            // Take one node from the queue
            int node = queue.poll();

            // This node has been processed
            processed++;

            // Get the color of the current node
            int color = colors.charAt(node) - 'a';

            /*
             * Add the current node to its own color count.
             *
             * For example, if node color is 'b',
             * dp[node][1] increases by 1.
             */
            dp[node][color]++;

            // Check all 26 colors
            for (int c = 0; c < 26; c++) {

                // Update the maximum color value
                answer = Math.max(answer, dp[node][c]);
            }

            // Visit all neighbours
            for (int neighbour : graph.get(node)) {

                /*
                 * Pass the best color counts from current node
                 * to the neighbour.
                 */
                for (int c = 0; c < 26; c++) {

                    dp[neighbour][c] =
                        Math.max(dp[neighbour][c], dp[node][c]);
                }

                // Remove this edge
                indegree[neighbour]--;

                // If all incoming edges are removed,
                // this node can now be processed
                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        /*
         * If we could not process all nodes,
         * there is a cycle.
         *
         * A valid answer does not exist in this case.
         */
        if (processed != n) {
            return -1;
        }

        // Return the largest color value
        return answer;
    }
}