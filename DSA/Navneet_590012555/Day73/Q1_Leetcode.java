class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] a = new int[n];
        int[] b = new int[n];

        Arrays.fill(a, -1);
        Arrays.fill(b, -1);

        int d = 0;
        int x = node1;

        while (x != -1 && a[x] == -1) {
            a[x] = d++;
            x = edges[x];
        }

        d = 0;
        x = node2;

        while (x != -1 && b[x] == -1) {
            b[x] = d++;
            x = edges[x];
        }

        int ans = -1;
        int best = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (a[i] != -1 && b[i] != -1) {
                int max = Math.max(a[i], b[i]);

                if (max < best) {
                    best = max;
                    ans = i;
                }
            }
        }

        return ans;
    }
}
