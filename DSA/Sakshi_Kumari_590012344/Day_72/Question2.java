import java.util.*;

class Result {

    static int[] parent;

    static int find(int x) {
        if (parent[x] == x)
            return x;

        parent[x] = find(parent[x]);
        return parent[x];
    }

    static boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x == y)
            return false;

        parent[y] = x;
        return true;
    }

    public static int kruskals(int gNodes, List<Integer> gFrom,
                               List<Integer> gTo, List<Integer> gWeight) {

        int n = gFrom.size();

        Integer[] index = new Integer[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (a, b) -> 
            Integer.compare(gWeight.get(a), gWeight.get(b))
        );

        parent = new int[gNodes + 1];

        for (int i = 1; i <= gNodes; i++) {
            parent[i] = i;
        }

        int total = 0;
        int count = 0;

        for (int i : index) {
            int u = gFrom.get(i);
            int v = gTo.get(i);
            int weight = gWeight.get(i);

            if (union(u, v)) {
                total += weight;
                count++;

                if (count == gNodes - 1)
                    break;
            }
        }

        return total;
    }
}
