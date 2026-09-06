import java.io.*;
import java.util.*;

public class Main {

    static int findCenter(int[][] edges) {
        if (edges[0][0] == edges[1][0] ||
            edges[0][0] == edges[1][1]) {
            return edges[0][0];
        }

        return edges[0][1];
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        int[][] edges = new int[n - 1][2];

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st =
                    new StringTokenizer(br.readLine());

            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findCenter(edges));
    }
}