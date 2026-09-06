import java.util.*;

class Solution {
    public int minCostToMakeRingStronglyConnected(int n, int[][] roads) {
        // adjacency: node -> list of {neighbor, cost, matchesOriginalDirection}
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] r : roads) {
            int u = r[0], v = r[1], cost = r[2];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, cost, 1}); // u -> v is original direction
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, cost, 0}); // v -> u is reverse of original
        }

        Set<Integer> visited = new HashSet<>();
        int start = roads[0][0];
        int current = start;
        visited.add(current);

        long costClockwise = 0, costCounterClockwise = 0;

        for (int step = 0; step < n; step++) {
            int[] chosen = null;
            for (int[] edge : adj.get(current)) {
                int neighbor = edge[0];
                boolean isClosingEdge = (step == n - 1 && neighbor == start);
                if (!visited.contains(neighbor) || isClosingEdge) {
                    chosen = edge;
                    break;
                }
            }
            if (chosen == null) break; // input wasn't a valid ring

            int neighbor = chosen[0], cost = chosen[1], dir = chosen[2];
            if (dir == 1) {
                // current -> neighbor already matches this walk direction
                costCounterClockwise += cost; // would need flipping to reverse the whole ring
            } else {
                // current -> neighbor is opposite of the original edge
                costClockwise += cost; // needs flipping to complete this walk direction
            }

            visited.add(neighbor);
            current = neighbor;
        }

        return (int) Math.min(costClockwise, costCounterClockwise);
    }
}
