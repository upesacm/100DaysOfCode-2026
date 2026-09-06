import java.util.*;

public class Question2 {

    static int N, T;
    static List<Integer>[] graph;
    static int best;

    static void solve(int usedMask, int covered) {
        int unused = N - Integer.bitCount(usedMask);

        if (covered + unused <= best) {
            return;
        }
        int v = -1;
        for (int i = 0; i < N; i++) {
            if ((usedMask & (1 << i)) == 0) {
                v = i;
                break;
            }
        }

        if (v == -1) {
            best = Math.max(best, covered);
            return;
        }

        solve(usedMask | (1 << v), covered);
        List<Integer> availableNeighbors = new ArrayList<>();

        for (int u : graph[v]) {
            if ((usedMask & (1 << u)) == 0) {
                availableNeighbors.add(u);
            }
        }

        int maxFeet = Math.min(T, availableNeighbors.size());

        for (int k = 1; k <= maxFeet; k++) {
            chooseFeet(
                    availableNeighbors,
                    0,
                    k,
                    new ArrayList<>(),
                    v,
                    usedMask,
                    covered
            );
        }
    }

    static void chooseFeet(
            List<Integer> neighbors,
            int index,
            int remaining,
            List<Integer> chosen,
            int head,
            int usedMask,
            int covered
    ) {

        if (remaining == 0) {
            int newMask = usedMask | (1 << head);

            for (int u : chosen) {
                newMask |= (1 << u);
            }
            int crabSize = 1 + chosen.size();

            solve(newMask, covered + crabSize);
            return;
        }

        if (index >= neighbors.size()) {
            return;
        }

        if (neighbors.size() - index < remaining) {
            return;
        }

        chosen.add(neighbors.get(index));
        chooseFeet(
                neighbors,
                index + 1,
                remaining - 1,
                chosen,
                head,
                usedMask,
                covered
        );
        chosen.remove(chosen.size() - 1);

        chooseFeet(
                neighbors,
                index + 1,
                remaining,
                chosen,
                head,
                usedMask,
                covered
        );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while (C-- > 0) {

            N = sc.nextInt();
            T = sc.nextInt();
            int M = sc.nextInt();

            graph = new ArrayList[N];

            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;

                graph[u].add(v);
                graph[v].add(u);
            }

            best = 0;

            solve(0, 0);

            System.out.println(best);
        }

        sc.close();
    }
}
