public class Question1_Leetcode {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = getDistances(edges, node1);
        int[] dist2 = getDistances(edges, node2);
        
        int best = -1;
        int bestDist = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (dist1[i] == -1 || dist2[i] == -1) continue;
            int d = Math.max(dist1[i], dist2[i]);
            if (d < bestDist) {
                bestDist = d;
                best = i;
            }
        }     
        return best;
    }
    private int[] getDistances(int[] edges, int start) {
        int n = edges.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        int cur = start;
        int d = 0;
        while (cur != -1 && dist[cur] == -1) {
            dist[cur] = d++;
            cur = edges[cur];
        }
        return dist;
    }
}