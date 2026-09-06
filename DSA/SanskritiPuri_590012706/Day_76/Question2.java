import java.io.*;
import java.util.*;

public class Main {

    static int n, m, k;
    static ArrayList<Integer>[] graph;
    static int[] degree;

    // Returns the length of the trailing path starting from start.
    // If start has degree > 2, there is no trailing path.
    static int trailingPathLength(int start) {
        if (degree[start] > 2) {
            return 0;
        }

        int current = start;
        int previous = -1;
        int length = 0;

        while (degree[current] <= 2) {
            length++;

            int next = -1;

            for (int v : graph[current]) {
                if (v != previous) {
                    next = v;
                    break;
                }
            }

            if (next == -1) {
                break;
            }

            previous = current;
            current = next;
        }

        return length;
    }

    // Check the case where L^k(G) has an Euler cycle.
    static boolean checkEulerCycle() {

        int odd = 0;

        for (int i = 0; i < n; i++) {
            if (degree[i] % 2 == 1) {
                odd++;
            }
        }

        // G itself has an Euler cycle.
        // Then every line graph also has an Euler cycle.
        if (odd == 0) {
            return true;
        }

        // Check whether every edge connects vertices
        // having different parity.
        boolean allDifferentParity = true;

        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                if ((degree[u] & 1) == (degree[v] & 1)) {
                    allDifferentParity = false;
                    break;
                }
            }

            if (!allDifferentParity) {
                break;
            }
        }

        // If every edge joins odd-even vertices,
        // L^2(G) has an Euler cycle.
        if (allDifferentParity && k >= 2) {
            return true;
        }

        return false;
    }

    static boolean checkEulerPath() {

        int[] odd = new int[2];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (degree[i] % 2 == 1) {
                odd[count++] = i;
            }
        }

        // The input guarantees an Euler trail,
        // so here there must be exactly two odd vertices.
        if (count != 2) {
            return false;
        }

        int len0 = trailingPathLength(odd[0]);
        int len1 = trailingPathLength(odd[1]);

        // Make len0 the smaller one.
        if (len0 > len1) {
            int temp = len0;
            len0 = len1;
            len1 = temp;

            temp = odd[0];
            odd[0] = odd[1];
            odd[1] = temp;
        }

        // If the shorter trailing path is long enough,
        // L^k(G) still has an Euler path.
        if (len0 >= k) {
            return true;
        }

        // A non-zero trailing path shorter than k means NO.
        if (len0 > 0) {
            return false;
        }

        /*
         * Special case for k = 1:
         *
         * One odd vertex has degree 3,
         * the other odd vertex is a leaf,
         * and they are directly connected.
         */
        if (len1 == 1 &&
            degree[odd[0]] == 3 &&
            graph[odd[1]].contains(odd[0]) &&
            k == 1) {

            return true;
        }

        // If the two odd vertices are adjacent,
        // the remaining special cases fail.
        if (graph[odd[0]].contains(odd[1])) {
            return false;
        }

        // Only k = 2 can possibly work now.
        if (k == 1 || k >= 3) {
            return false;
        }

        // ------------------------------------------
        // k == 2 special structural condition
        // ------------------------------------------

        boolean[] removed = new boolean[n];

        removed[odd[0]] = true;
        removed[odd[1]] = true;

        // Find a non-isolated vertex after removing
        // the two odd vertices.
        int start = -1;

        for (int i = 0; i < n; i++) {
            if (!removed[i]) {

                boolean hasRemainingEdge = false;

                for (int v : graph[i]) {
                    if (!removed[v]) {
                        hasRemainingEdge = true;
                        break;
                    }
                }

                if (hasRemainingEdge) {
                    start = i;
                    break;
                }
            }
        }

        // If there is no such component, condition fails.
        if (start == -1) {
            return false;
        }

        // Check that all non-isolated vertices form
        // exactly one connected component.
        boolean[] visited = new boolean[n];

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            int u = queue.poll();

            for (int v : graph[u]) {

                if (removed[v] || visited[v]) {
                    continue;
                }

                visited[v] = true;
                queue.add(v);
            }
        }

        for (int i = 0; i < n; i++) {

            if (removed[i]) {
                continue;
            }

            boolean hasEdge = false;

            for (int v : graph[i]) {
                if (!removed[v]) {
                    hasEdge = true;
                    break;
                }
            }

            if (hasEdge && !visited[i]) {
                return false;
            }
        }

        /*
         * Every non-isolated vertex in the remaining component
         * that is connected to an odd vertex must have degree 2.
         *
         * Also, there must be at most two edges connecting
         * the component to the two odd vertices.
         */

        int connectingEdges = 0;

        for (int i = 0; i < n; i++) {

            if (removed[i]) {
                continue;
            }

            int connections = 0;

            for (int v : graph[i]) {

                if (v == odd[0] || v == odd[1]) {
                    connections++;
                    connectingEdges++;
                }
            }

            if (connections > 0 && degree[i] > 2) {
                return false;
            }
        }

        if (connectingEdges > 2) {
            return false;
        }

        return true;
    }

    static void solve(FastScanner fs) throws Exception {

        n = fs.nextInt();
        m = fs.nextInt();
        k = fs.nextInt();

        graph = new ArrayList[n];
        degree = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {

            int u = fs.nextInt() - 1;
            int v = fs.nextInt() - 1;

            graph[u].add(v);
            graph[v].add(u);

            degree[u]++;
            degree[v]++;
        }

        if (checkEulerCycle()) {
            System.out.println("YES");
            return;
        }

        if (checkEulerPath()) {
            System.out.println("YES");
            return;
        }

        System.out.println("NO");
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();

        while (t-- > 0) {
            solve(fs);
        }
    }

    // Fast input
    static class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {

            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0) {
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
