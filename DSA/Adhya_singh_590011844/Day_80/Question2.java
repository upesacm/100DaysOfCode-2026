import java.io.*;

public class Main {

    static boolean isPowerOfTwoOrZero(int n) {
        return n == 0 || (n & (n - 1)) == 0;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int n = Integer.parseInt(br.readLine().trim());

        System.out.println(isPowerOfTwoOrZero(n));
    }
}