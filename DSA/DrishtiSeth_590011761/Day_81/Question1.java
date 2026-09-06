import java.util.*;

public class Main {

    public static int hammingDistance(int x, int y) {

        int xor = x ^ y;
        int count = 0;

        while (xor != 0) {
            count += xor & 1;
            xor = xor >>> 1;
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println(hammingDistance(x, y));

        sc.close();
    }
}
