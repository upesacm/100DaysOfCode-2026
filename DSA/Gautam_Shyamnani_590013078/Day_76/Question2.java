import java.io.*;
import java.util.*;

public class Question2 {

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;

            do {
                c = read();
            } while (c <= ' ' && c != -1);

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            int num = 0;

            while (c > ' ') {
                num = num * 10 + (c - '0');
                c = read();
            }

            return num * sign;
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int m = fs.nextInt();
        int k = fs.nextInt();

        int[] u = new int[m];
        int[] v = new int[m];
        int[] degree = new int[n];

        for (int i = 0; i < m; i++) {
            u[i] = fs.nextInt() - 1;
            v[i] = fs.nextInt() - 1;

            degree[u[i]]++;
            degree[v[i]]++;
        }

        List<Integer> oddVertices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if ((degree[i] & 1) == 1) {
                oddVertices.add(i);
            }
        }

        if (oddVertices.size() == 0) {
            System.out.println(true);
            return;
        }

        int differentParityEdges = 0;

        for (int i = 0; i < m; i++) {
            if ((degree[u[i]] & 1) != (degree[v[i]] & 1)) {
                differentParityEdges++;
            }
        }

        if (k == 1) {
            System.out.println(differentParityEdges <= 2);
            return;
        }

        if (differentParityEdges == 0) {
            System.out.println(true);
            return;
        }

        int odd1 = oddVertices.get(0);
        int odd2 = oddVertices.get(1);

        boolean vertexCover = true;

        for (int i = 0; i < m; i++) {
            boolean touchesOdd1 = (u[i] == odd1 || v[i] == odd1);
            boolean touchesOdd2 = (u[i] == odd2 || v[i] == odd2);

            if (!touchesOdd1 && !touchesOdd2) {
                vertexCover = false;
                break;
            }
        }

        System.out.println(vertexCover);
    }
}