class Solution {

    public int closestMeetingNode(int[] edges, int node1, int node2) {

        int n = edges.length;

        int[] dist1 = new int[n];
        int[] dist2 = new int[n];

        // -1 means not reachable
        for (int i = 0; i < n; i++) {
            dist1[i] = -1;
            dist2[i] = -1;
        }

        // Find distances from both nodes
        findDistances(edges, node1, dist1);
        findDistances(edges, node2, dist2);

        int answer = -1;
        int minDistance = Integer.MAX_VALUE;

        // Check every node
        for (int i = 0; i < n; i++) {

            // Must be reachable from both nodes
            if (dist1[i] != -1 && dist2[i] != -1) {

                int current = Math.max(dist1[i], dist2[i]);

                if (current < minDistance) {
                    minDistance = current;
                    answer = i;
                }
            }
        }

        return answer;
    }

    private void findDistances(int[] edges, int start, int[] dist) {

        int current = start;
        int distance = 0;

        while (current != -1 && dist[current] == -1) {

            dist[current] = distance;

            current = edges[current];
            distance++;
        }
    }
}