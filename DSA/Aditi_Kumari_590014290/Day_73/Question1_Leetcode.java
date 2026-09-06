package Day_73;
import java.util.*;
class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] dist1 = getDistance(edges, node1);
        int[] dist2 = getDistance(edges, node2);
        int answer = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDistance = Math.max(dist1[i], dist2[i]);
                if (maxDistance < minDistance) {
                    minDistance = maxDistance;
                    answer = i;
                }
            }
        }
        return answer;
    }
    private int[] getDistance(int[] edges, int start) {
        int n = edges.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        int current = start;
        int distance = 0;
        while (current != -1 && dist[current] == -1) {
            dist[current] = distance++;
            current = edges[current];
        }
        return dist;
    }
}