import java.io.*;
import java.util.*;

public class Main {

    static int findJudge(int n, int[][] trust) {

        int[] score = new int[n + 1];

        for (int[] relation : trust) {
            int a = relation[0];
            int b = relation[1];

            score[a]--;

            score[b]++;
        }

        for (int person = 1; person <= n; person++) {
            if (score[person] == n - 1) {
                return person;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder output = new StringBuilder();

        while (T-- > 0) {

            int n = Integer.parseInt(br.readLine().trim());

            int m = Integer.parseInt(br.readLine().trim());

            int[][] trust = new int[m][2];

            for (int i = 0; i < m; i++) {

                st = new StringTokenizer(br.readLine());

                trust[i][0] = Integer.parseInt(st.nextToken());
                trust[i][1] = Integer.parseInt(st.nextToken());
            }

            int answer = findJudge(n, trust);

            output.append(answer).append('\n');
        }

        System.out.print(output);
    }
}