import java.util.*;

public class Main {

    public static int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0;

        while (n != 0) {
            n &= (n - 1);
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