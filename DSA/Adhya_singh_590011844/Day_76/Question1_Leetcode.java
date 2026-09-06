import java.io.*;
import java.util.*;

public class Main {

    static final long MOD = 1_000_000_007L;

    static long[] factorial;
    static long[] invFactorial;

    static long modPow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }

            base = base * base % MOD;
            exp >>= 1;
        }

        return result;
    }

    static long combination(int n, int r) {
        return factorial[n]
                * invFactorial[r] % MOD
                * invFactorial[n - r] % MOD;
    }

    static int solve(int[] prevRoom) {

        int n = prevRoom.length;

        List<Integer>[] children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            children[prevRoom[i]].add(i);
        }

        factorial = new long[n + 1];
        invFactorial = new long[n + 1];

        factorial[0] = 1;

        for (int i = 1; i <= n; i++) {
            factorial[i] =
                    factorial[i - 1] * i % MOD;
        }

        invFactorial[n] =
                modPow(factorial[n], MOD - 2);

        for (int i = n - 1; i >= 0; i--) {
            invFactorial[i] =
                    invFactorial[i + 1] * (i + 1) % MOD;
        }

        int[] order = new int[n];
        int count = 0;

        int[] stack = new int[n];
        int top = 0;

        stack[top++] = 0;

        while (top > 0) {

            int node = stack[--top];
            order[count++] = node;

            for (int child : children[node]) {
                stack[top++] = child;
            }
        }

        long[] ways = new long[n];
        int[] size = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            int node = order[i];

            ways[node] = 1;
            size[node] = 1;

            int processed = 0;

            for (int child : children[node]) {

                ways[node] =
                        ways[node] * ways[child] % MOD;

                ways[node] =
                        ways[node]
                        * combination(
                            processed + size[child],
                            size[child]
                        ) % MOD;

                processed += size[child];
                size[node] += size[child];
            }
        }

        return (int) ways[0];
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();

        int[] prevRoom = new int[n];

        for (int i = 0; i < n; i++) {
            prevRoom[i] = fs.nextInt();
        }

        System.out.println(solve(prevRoom));
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