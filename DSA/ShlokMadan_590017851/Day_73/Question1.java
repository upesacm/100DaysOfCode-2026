import java.util.Arrays;
public class Question1 
{
    public static int[] getDistance(int[] edges, int start) 
    {
        int[] distance = new int[edges.length];
        Arrays.fill(distance, -1);
        int current = start;
        int dist = 0;
        while (current != -1 && distance[current] == -1) 
            {
            distance[current] = dist;
            dist++;
            current = edges[current];
        }
        return distance;
    }
    public static int closestMeetingNode(int[] edges, int node1, int node2) 
    {
        int[] dist1 = getDistance(edges, node1);
        int[] dist2 = getDistance(edges, node2);
        int answer = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) 
            {
            if (dist1[i] != -1 && dist2[i] != -1) 
                {
                int maxDistance = Math.max(dist1[i], dist2[i]);
                if (maxDistance < minDistance) 
                    {
                    minDistance = maxDistance;
                    answer = i;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) 
    {
        int[] edges = {2, 2, 3, -1};
        int node1 = 0;
        int node2 = 1;
        System.out.println(closestMeetingNode(edges, node1, node2));
    }
}