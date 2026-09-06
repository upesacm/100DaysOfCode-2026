class Solution {

    public int minCost(int n, int[][] roads) {

        int clockwise = 0;
        int anticlockwise = 0;

        for (int[] road : roads) {

            int u = road[0];
            int v = road[1];
            int cost = road[2];

            // Clockwise direction: u -> v
            // If road is already u -> v, no cost.
            // Otherwise, reverse it.
            if (isClockwise(u, v, n)) {
                anticlockwise += cost;
            } else {
                clockwise += cost;
            }
        }

        return Math.min(clockwise, anticlockwise);
    }

    private boolean isClockwise(int u, int v, int n) {
        return (u % n) + 1 == v;
    }
}