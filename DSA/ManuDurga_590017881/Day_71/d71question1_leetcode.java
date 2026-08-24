package Day_71;

public class d71question1_leetcode {
    public int findJudge(int n, int[][] trust) {
        int[] into = new int[n + 1];
        int[] outof = new int[n + 1];

        for (int[] t : trust) {
            outof[t[0]]++;into[t[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (outof[i] == 0 && into[i] == n - 1) return i;
        }
        return -1;
    }
}
