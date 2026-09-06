public class Question1_Leetcode {
    private int[] parent, size;
    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        long ans = (long) n * (n - 1) / 2;
        for (int[] e : edges) {
            int a = find(e[0]);
            int b = find(e[1]);

            if (a == b) continue;

            if (size[a] < size[b]) {
                int temp = a;
                a = b;
                b = temp;
            }
            ans -= (long) size[a] * size[b];
            parent[b] = a;
            size[a] += size[b];
        }
        return ans;
    }
}