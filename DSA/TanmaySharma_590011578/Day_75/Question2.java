import java.util.*;

public class Question2 {
    public static int minCost(int n, int[][] roads) {
        int cost1 = 0;
        int cost2 = 0;

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int cost = road[2];

            map.putIfAbsent(u, new HashMap<>());
            map.putIfAbsent(v, new HashMap<>());

            map.get(u).put(v, cost);
            map.get(v).put(u, -cost);
        }

        for (int i = 1; i <= n; i++) {
            int next = i == n ? 1 : i + 1;

            int value = map.get(i).get(next);

            if (value < 0) {
                cost1 += -value;
            }
        }

        for (int i = 1; i <= n; i++) {
            int next = i == n ? 1 : i + 1;

            int value = map.get(i).get(next);

            if (value > 0) {
                cost2 += value;
            }
        }

        return Math.min(cost1, cost2);
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] roads = {
            {1, 3, 1},
            {1, 2, 1},
            {3, 2, 1}
        };

        System.out.println(minCost(n, roads));
    }
}