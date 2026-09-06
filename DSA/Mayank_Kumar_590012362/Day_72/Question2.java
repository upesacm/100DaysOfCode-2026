public class Question2 {
    static int[] p;
    static int f(int x) {
        return p[x] == x ? x : (p[x] = f(p[x]));
    }
    public static long mst(int n, int[][] e) {
        Arrays.sort(e, (a, b) -> a[2] - b[2]);
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) p[i] = i;
        long s = 0;
        for (int[] x : e) {
            int a = f(x[0]), b = f(x[1]);
            if (a != b) {
                p[a] = b;
                s += x[2];
            }
        } return s;
    }
}