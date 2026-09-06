class Solution {
    public boolean hasEulerTrail(int n, int[][] edges, int k) {

        int[] degree = new int[n];

        for (int[] e : edges) {
            degree[e[0] - 1]++;
            degree[e[1] - 1]++;
        }

        for (int d : degree) {
            if ((d & 1) == 1) {
                return false;
            }
        }

        return true;
    }
}