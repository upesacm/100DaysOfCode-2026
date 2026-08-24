import java.util.*;

public class Question1_Leetcode {

    static int findJudge(int n, int[][] trust) {
        int[] score = new int[n + 1];

        for (int[] pair : trust) {
            score[pair[0]]--;
            score[pair[1]]++;
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

        for (int test = 0; test < t; test++) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] trust = new int[m][2];

            for (int i = 0; i < m; i++) {
                trust[i][0] = sc.nextInt();
                trust[i][1] = sc.nextInt();
            }

            int answer = findJudge(n, trust);

            System.out.println(answer);
        }

        sc.close();
    }
}