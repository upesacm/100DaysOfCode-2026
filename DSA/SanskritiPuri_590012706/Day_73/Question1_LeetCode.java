class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = computeDistances(edges, node1);
        int[] dist2 = computeDistances(edges, node2);

        int best = -1;
        int bestDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < bestDist) {
                    bestDist = maxDist;
                    best = i;
                }
            }
        }

        return best;
    }

    private int[] computeDistances(int[] edges, int start) {
        int n = edges.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        int curr = start;
        int d = 0;
        while (curr != -1 && dist[curr] == -1) {
            dist[curr] = d;
            curr = edges[curr];
            d++;
        }

        return dist;
    }
}
