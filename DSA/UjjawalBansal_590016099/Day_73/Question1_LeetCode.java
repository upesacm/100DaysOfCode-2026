package DSA.UjjawalBansal_590016099.Day_73;

import java.util.Arrays;

public class Question1_LeetCode {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);
        
        calculateDistances(node1, edges, dist1);
        calculateDistances(node2, edges, dist2);
        
        int minMaximumDistance = Integer.MAX_VALUE;
        int bestNode = -1;
        
        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                
                int currentMaxDist = Math.max(dist1[i], dist2[i]);
                
                if (currentMaxDist < minMaximumDistance) {
                    minMaximumDistance = currentMaxDist;
                    bestNode = i;
                }
            }
        }
        
        return bestNode;
    }
    private void calculateDistances(int startNode, int[] edges, int[] distances) {
        int currentNode = startNode;
        int currentDistance = 0;
        while (currentNode != -1 && distances[currentNode] == -1) {
            
            distances[currentNode] = currentDistance;
            
            currentDistance++;
            currentNode = edges[currentNode];
        }
    }
}
