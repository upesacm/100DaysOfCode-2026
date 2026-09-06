import java.util.Scanner;

public class Question1 {

    public static int findJudge(int n, int[][] trust) {
        int[] score = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            int a = trust[i][0];
            int b = trust[i][1];

            score[a]--;
            score[b]++;
        }

        for (int i = 1; i <= n; i++) {
            if (score[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] trust = new int[m][2];

            for (int i = 0; i < m; i++) {
                trust[i][0] = sc.nextInt();
                trust[i][1] = sc.nextInt();
            }

            System.out.println(findJudge(n, trust));
        }
    }
}