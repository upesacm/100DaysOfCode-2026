class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] dist1 = new int[n];
        int[] dist2 = new int[n];

        java.util.Arrays.fill(dist1, -1);
        java.util.Arrays.fill(dist2, -1);

        int curr = node1;
        int dist = 0;

        while (curr != -1 && dist1[curr] == -1) {
            dist1[curr] = dist;
            dist++;
            curr = edges[curr];
        }

        curr = node2;
        dist = 0;

        while (curr != -1 && dist2[curr] == -1) {
            dist2[curr] = dist;
            dist++;
            curr = edges[curr];
        }

        int answer = -1;
        int minMaxDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);

                if (maxDist < minMaxDist) {
                    minMaxDist = maxDist;
                    answer = i;
                }
            }
        }

        return answer;
    }
}
