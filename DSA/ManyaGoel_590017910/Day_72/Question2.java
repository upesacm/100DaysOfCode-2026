import java.io.*;
import java.util.*;
public class Question2 {
    static class Edge {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    static int[] parent, size;

    static int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    static boolean union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb)
            return false;

        if (size[ra] < size[rb]) {
            int t = ra;
            ra = rb;
            rb = t;
        }

        parent[rb] = ra;
        size[ra] += size[rb];
        return true;
    }

    static long reallySpecialSubTree(int n, Edge[] edges) {

        Arrays.sort(edges, (a, b) -> {
            if (a.w != b.w)
                return Integer.compare(a.w, b.w);

            return Integer.compare(a.u + a.v, b.u + b.v);
        });

        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        long total = 0;
        int count = 0;

        for (Edge e : edges) {
            if (union(e.u, e.v)) {
                total += e.w;

                if (++count == n - 1)
                    break;
            }
        }

        return total;
    }

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0)
                    return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            int num = 0;
            while (c > ' ') {
                num = num * 10 + c - '0';
                c = read();
            }
            return num;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        System.out.print("Enter the number of nodes (n): ");
        int n = fs.nextInt();

        System.out.print("Enter the number of edges (m): ");
        int m = fs.nextInt();

        Edge[] edges = new Edge[m];

        System.out.println("Enter each edge as: u v w");

        for (int i = 0; i < m; i++) {
            System.out.print("Edge " + (i + 1) + ": ");

            int u = fs.nextInt();
            int v = fs.nextInt();
            int w = fs.nextInt();

            edges[i] = new Edge(u, v, w);
        }

        long answer = reallySpecialSubTree(n, edges);
        System.out.println("Total weight of the Really Special SubTree: " + answer);
    }
}