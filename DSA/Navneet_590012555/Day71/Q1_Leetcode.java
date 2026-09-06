class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] a = new int[n + 1];

        for (int[] x : trust) {
            a[x[0]]--;
            a[x[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (a[i] == n - 1)
                return i;
        }

        return -1;
    }
}