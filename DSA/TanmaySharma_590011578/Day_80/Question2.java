import java.util.Scanner;

public class Question2 {
    static boolean isPowerOfTwoOrZero(int n) {
        return n == 0 || (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int n = sc.nextInt();

        boolean result = isPowerOfTwoOrZero(n);

        System.out.println(result);

        sc.close();
    }
}