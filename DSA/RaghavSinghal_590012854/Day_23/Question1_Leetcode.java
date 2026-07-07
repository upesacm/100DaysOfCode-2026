class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Thread t1 = new Thread(() -> {
            Arrays.sort(g);
        });
        Thread t2 = new Thread(() -> {
            Arrays.sort(s);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
        }
        int i = 0, j = 0, c = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                c++;
                i++;
                j++;
            } else {
                j++;
            }

        }
        return c;

    }
}