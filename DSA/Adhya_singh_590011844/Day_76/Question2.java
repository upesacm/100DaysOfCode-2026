import java.io.*;
import java.util.*;

public class Main {

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
            } while (c <= ' ');

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

        int[] degree = new int[n];

        int[] U = new int[m];
        int[] V = new int[m];

        for (int i = 0; i < m; i++) {

            int u = fs.nextInt();
            int v = fs.nextInt();

            --u;
            --v;

            U[i] = u;
            V[i] = v;

            degree[u]++;
            degree[v]++;
        }

        int k = fs.nextInt();

        int oddCount = 0;
        int odd1 = -1;
        int odd2 = -1;

        for (int i = 0; i < n; i++) {

            if ((degree[i] & 1) == 1) {

                if (oddCount == 0) {
                    odd1 = i;
                } else if (oddCount == 1) {
                    odd2 = i;
                }

                oddCount++;
            }
        }

        if (oddCount == 0) {
            System.out.println("true");
            return;
        }



        boolean adjacent = false;

        for (int i = 0; i < m; i++) {

            if ((U[i] == odd1 && V[i] == odd2) ||
                (U[i] == odd2 && V[i] == odd1)) {

                adjacent = true;
                break;
            }
        }

        int oddInLineGraph =
                degree[odd1] +
                degree[odd2] -
                (adjacent ? 2 : 0);

     
        boolean lineGraphEulerian =
                oddInLineGraph <= 2;

        if (k == 1) {
            System.out.println(lineGraphEulerian ? "true" : "false");
        } else {
 
            System.out.println(lineGraphEulerian ? "true" : "false");
        }
    }
}