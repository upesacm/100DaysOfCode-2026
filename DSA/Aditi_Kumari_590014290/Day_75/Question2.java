package Day_75;
import java.util.*;
public class Question2 {
    static class Road {
        int to;
        int cost;
        boolean original;
        Road(int to, int cost, boolean original) {
            this.to = to;
            this.cost = cost;
            this.original = original;
        }
    }
    public static int minCost(int n, int[][] roads) {
        List<List<Road>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int cost = road[2];
            graph.get(u).add(new Road(v, cost, true));
            graph.get(v).add(new Road(u, cost, false));
        }
        int[] order = new int[n];
        int[] costForward = new int[n];
        order[0] = 1;
        int prev = -1;
        int current = 1;
        for (int i = 1; i < n; i++) {
            Road next = null;
            for (Road r : graph.get(current)) {
                if (r.to != prev) {
                    next = r;
                    break;
                }
            }
            prev = current;
            current = next.to;
            order[i] = current;
            if (next.original) {
                costForward[i - 1] = 0;
            } else {
                costForward[i - 1] = next.cost;
            }
        }
        int first = order[0];
        int last = order[n - 1];
        for (Road r : graph.get(last)) {
            if (r.to == first) {
                if (r.original) {
                    costForward[n - 1] = 0;
                } else {
                    costForward[n - 1] = r.cost;
                }
                break;
            }
        }

        int clockwise = 0;
        int counterClockwise = 0;

        for (int i = 0; i < n; i++) {
            clockwise += costForward[i];
            
            int total = 0;
            for (int[] road : roads) {
                total += road[2];
            }

            counterClockwise = total - clockwise;
        }

        return Math.min(clockwise, counterClockwise);
    }