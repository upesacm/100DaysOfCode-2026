class Solution {
    public int rob(int[] a) {
        int n = a.length;

        if (n == 1) {
            return a[0];
        }

        return Math.max(
                f(a, 0, n - 2),
                f(a, 1, n - 1));
    }

    private int f(int[] a, int s, int e) {
        int p1 = 0;
        int p2 = 0;

        for (int i = s; i <= e; i++) {
            int c = Math.max(p1, a[i] + p2);
            p2 = p1;
            p1 = c;
        }

        return p1;
    }
}