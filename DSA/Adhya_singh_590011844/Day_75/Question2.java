import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int to;
        int cost;
        boolean originalDirection;

        Edge(int to, int cost, boolean originalDirection) {
            this.to = to;
            this.cost = cost;
            this.originalDirection = originalDirection;
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();

        List<Edge>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {

            int a = fs.nextInt();
            int b = fs.nextInt();
            int c = fs.nextInt();

            graph[a].add(new Edge(b, c, true));

            graph[b].add(new Edge(a, c, false));
        }

        int clockwiseCost = 0;
        int counterClockwiseCost = 0;

        int current = 1;
        int previous = -1;

        while (true) {

            Edge next = null;

            for (Edge e : graph[current]) {
                if (e.to != previous) {
                    next = e;
                    break;
                }
            }

            if (next == null || next.to == 1) {
                break;
            }

            if (!next.originalDirection) {
                clockwiseCost += next.cost;
            }

            previous = current;
            current = next.to;
        }

        int totalCost = 0;

        for (int i = 1; i <= n; i++) {
            for (Edge e : graph[i]) {
                if (e.originalDirection) {
                    totalCost += e.cost;
                }
            }
        }

        counterClockwiseCost = totalCost - clockwiseCost;

        System.out.println(
            Math.min(clockwiseCost, counterClockwiseCost)
        );
    }

    static class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {

            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len == -1) {
                    return -1;
                }
            }

            return buffer[ptr++];
        }

        int nextInt() throws IOException {

            int c;

            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            int result = 0;

            while (c > ' ') {
                result = result * 10 + (c - '0');
                c = read();
            }

            return result * sign;
        }
    }
}