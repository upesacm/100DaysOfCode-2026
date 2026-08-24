import java.util.*;

public class Main {

    static int findJudge(int n, int[][] trust) {
        int[] degree = new int[n + 1];

        for (int[] t : trust) {
            degree[t[0]]--;
            degree[t[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (degree[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] trust = new int[m][2];

            for (int i = 0; i < m; i++) {
                trust[i][0] = sc.nextInt();
                trust[i][1] = sc.nextInt();
            }

            System.out.println(findJudge(n, trust));
        }

        sc.close();
    }
}