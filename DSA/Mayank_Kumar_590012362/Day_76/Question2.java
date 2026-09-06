class Solution {
    public boolean hasEulerTrail(int n, int[][] e, int k) {
        int[] d = new int[n];

        for (int[] x : e) {
            d[x[0]]++;
            d[x[1]]++;
        }

        int c = 0;
        for (int x : d)
            if ((x & 1) == 1)
                c++;

        return c == 0 || c == 2;
    }
}