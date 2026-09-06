import java.util.*;

public class Question2 {

    static int findJudge(int n, int[][] trust) {
        int[] score = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            int person1 = trust[i][0];
            int person2 = trust[i][1];

            score[person1]--;
            score[person2]++;
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

        System.out.print("Enter number of people: ");
        int n = sc.nextInt();

        System.out.print("Enter number of trust relationships: ");
        int m = sc.nextInt();

        int[][] trust = new int[m][2];

        System.out.println("Enter trust relationships:");

        for (int i = 0; i < m; i++) {
            trust[i][0] = sc.nextInt();
            trust[i][1] = sc.nextInt();
        }

        int result = findJudge(n, trust);

        System.out.println("Town Judge: " + result);

        sc.close();
    }
}