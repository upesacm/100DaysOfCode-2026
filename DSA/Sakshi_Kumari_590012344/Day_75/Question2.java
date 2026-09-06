class Solution {
    public int minCost(int n, int[][] a) {
        int x = 0, y = 0;

        for (int[] e : a) {
            int u = e[0], v = e[1], c = e[2];
            int nxt = u == n ? 1 : u + 1;

            if (v == nxt) y += c; 
            else x += c;         
        }

        return Math.min(x, y);
    }
}
