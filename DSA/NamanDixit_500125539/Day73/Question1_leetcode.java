class Question1_leetcode {

    // ------------------------------------------------------------------
    // This function finds the "closest meeting node" reachable from both
    // node1 and node2, where "closest" means the smaller value of
    // max(distance from node1, distance from node2).
    // ------------------------------------------------------------------
    public int closestMeetingNode(int[] edges, int node1, int node2) {

        int n = edges.length;

        // Step 1: Find distance from node1 to every reachable node.
        int[] dist1 = getDistances(edges, node1, n);

        // Step 2: Find distance from node2 to every reachable node.
        int[] dist2 = getDistances(edges, node2, n);

        int bestNode = -1;              // answer node, -1 means "not found yet"
        int bestDistance = Integer.MAX_VALUE; // smallest max-distance found so far

        // Step 3: Check every node from 0 to n-1
        for (int i = 0; i < n; i++) {

            // Only consider nodes reachable from BOTH node1 and node2
            if (dist1[i] != -1 && dist2[i] != -1) {

                // The "cost" to meet at this node is the LARGER of the two distances
                // (because both people need to reach it, so we wait for the slower one)
                int maxDist = Math.max(dist1[i], dist2[i]);

                // If this node is better (smaller max distance), update our answer.
                // Since we loop from i = 0 upwards, the FIRST node we find with the
                // smallest max distance will automatically be the smallest node number
                // in case of a tie (we don't even need extra tie-breaking code).
                if (maxDist < bestDistance) {
                    bestDistance = maxDist;
                    bestNode = i;
                }
            }
        }

        return bestNode;
    }

    // ------------------------------------------------------------------
    // Helper function: starting from "start" node, follow the edges
    // one step at a time, recording how many steps it takes to reach
    // every node. If a node is unreachable, its distance stays -1.
    // We stop walking if we hit a dead end (-1) or if we revisit a
    // node we've already visited (that means we're stuck in a loop).
    // ------------------------------------------------------------------
    private int[] getDistances(int[] edges, int start, int n) {

        int[] distance = new int[n];

        // Initially, mark every node as "unreachable" using -1
        for (int i = 0; i < n; i++) {
            distance[i] = -1;
        }

        int current = start; // we begin walking from the start node
        int steps = 0;        // number of steps taken so far

        // Keep walking forward as long as:
        // - we haven't gone out of bounds (-1 means no outgoing edge)
        // - we haven't already visited this node (avoids infinite loops)
        while (current != -1 && distance[current] == -1) {
            distance[current] = steps; // record how many steps it took to reach "current"
            steps++;                    // next node will be one step further
            current = edges[current];   // move forward along the edge
        }

        return distance;
    }
}