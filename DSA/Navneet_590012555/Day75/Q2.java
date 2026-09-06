class Solution {
    public int minCost(int n, int[][] roads) {
        int a = 0;
        int b = 0;

        for (int[] r : roads) {
            int u = r[0];
            int v = r[1];
            int cost = r[2];

            // Direction u -> v
            // Direction v -> u
            if (v == u % n + 1)
                b += cost;
            else
                a += cost;
        }

        return Math.min(a, b);
    }
}