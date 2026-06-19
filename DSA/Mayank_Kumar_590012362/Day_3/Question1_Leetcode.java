class Solution {
    public int[] plusOne(int[] d) {
        int n = d.length; int[] r = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            if (d[i] < 9) { d[i] += 1; return d; }
            d[i] = 0;
        }
        r[0] = 1; return r;
    }
}