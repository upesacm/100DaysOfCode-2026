class Question2 {
    static int[] solve(int n, int[][] e) {
        int[] p = new int[n + 1], s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
            s[i] = 1;
        }
        for (int[] x : e) {
            int a = x[0], b = x[1];
            while (p[a] != a) a = p[a];
            while (p[b] != b) b = p[b];
            if (a != b) {
                if (s[a] < s[b]) { int t = a; a = b; b = t; }
                p[b] = a;
                s[a] += s[b];
            }
        }
        int c = 0, mx = 0;
        for (int i = 1; i <= n; i++) {
            if (p[i] == i) {
                c++;
                mx = Math.max(mx, s[i]);
            }
        }
        return new int[]{c, mx};
    }
}