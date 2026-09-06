import java.util.*;

public class Question2 {

    static int n, t;
    static ArrayList<Integer>[] graph;
    static boolean[] used;

    static int findMaximumCrab() {

        int covered = 0;

        for (int head = 1; head <= n; head++) {

            if (used[head]) {
                continue;
            }

            ArrayList<Integer> feet = new ArrayList<>();

            for (int neighbor : graph[head]) {

                if (!used[neighbor] && neighbor != head) {
                    feet.add(neighbor);

                    if (feet.size() == t) {
                        break;
                    }
                }
            }

            if (!feet.isEmpty()) {
                used[head] = true;
                covered++;

                for (int foot : feet) {
                    used[foot] = true;
                    covered++;
                }
            }
        }

        return covered;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        while (testCases-- > 0) {

            n = sc.nextInt();
            t = sc.nextInt();
            int m = sc.nextInt();

            graph = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {

                int u = sc.nextInt();
                int v = sc.nextInt();

                graph[u].add(v);
                graph[v].add(u);
            }

            used = new boolean[n + 1];

            System.out.println(findMaximumCrab());
        }

        sc.close();
    }
}