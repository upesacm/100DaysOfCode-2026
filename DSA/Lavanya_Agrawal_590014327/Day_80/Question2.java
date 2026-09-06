import java.util.*;

public class Question2 {

    public static boolean isPowerOfTwoOrZero(int n) {
        return n == 0 || (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(isPowerOfTwoOrZero(n));

        sc.close();
    }
}