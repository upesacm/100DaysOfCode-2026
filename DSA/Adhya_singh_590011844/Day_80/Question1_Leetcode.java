import java.io.*;

public class Main {

    static int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n &= (n - 1);
            count++;
        }

        return count;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int n = Integer.parseInt(br.readLine().trim());

        System.out.println(hammingWeight(n));
    }
}