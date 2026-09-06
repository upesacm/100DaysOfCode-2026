import java.io.*;
import java.util.*;

public class Main {

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

    static int closestMeetingNode(int[] edges, int node1, int node2) {

        int n = edges.length;

        int[] dist1 = getDistances(edges, node1);
        int[] dist2 = getDistances(edges, node2);

        int answer = -1;
        int minMaxDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            if (dist1[i] == -1 || dist2[i] == -1) {
                continue;
            }

            int maxDistance = Math.max(dist1[i], dist2[i]);

            if (maxDistance < minMaxDistance) {
                minMaxDistance = maxDistance;
                answer = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));

        StringTokenizer st =
                new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] edges = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            edges[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int node1 = Integer.parseInt(st.nextToken());
        int node2 = Integer.parseInt(st.nextToken());

        System.out.println(
                closestMeetingNode(edges, node1, node2)
        );
    }
}