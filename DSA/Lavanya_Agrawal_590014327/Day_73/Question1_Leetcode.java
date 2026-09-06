import java.util.*;

public class Question1_Leetcode {

    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] dist1 = getDistances(edges, node1);
        int[] dist2 = getDistances(edges, node2);

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

    static int[] getDistances(int[] edges, int start) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] edges = new int[n];

        for (int i = 0; i < n; i++) {
            edges[i] = sc.nextInt();
        }

        int node1 = sc.nextInt();
        int node2 = sc.nextInt();

        System.out.println(closestMeetingNode(edges, node1, node2));

        sc.close();
    }
}