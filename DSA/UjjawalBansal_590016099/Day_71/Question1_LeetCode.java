public class Question1_LeetCode {
    public int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) {
            return 1;
        }

        int[] trustArr = new int[n + 1];

        for (int[] relation : trust) {
            int trust1 = relation[0];
            int trust2 = relation[1];

            trustArr[trust1]--;

            trustArr[trust2]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trustArr[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
