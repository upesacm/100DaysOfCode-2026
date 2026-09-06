import java.util.*;

public class Question1_Leetcode {

    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;

        while (xor != 0) {
            xor = xor & (xor - 1);
            count++;
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