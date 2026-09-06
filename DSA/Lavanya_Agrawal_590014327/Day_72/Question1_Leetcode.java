import java.util.*;

public class Question1_Leetcode {

    public static int findCenter(int[][] edges) {
        int a = edges[0][0];
        int b = edges[0][1];

        if (edges[1][0] == a || edges[1][1] == a) {
            return a;
        }

        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] edges = new int[n - 1][2];

        for (int i = 0; i < n - 1; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        System.out.println(findCenter(edges));

        sc.close();
    }
}