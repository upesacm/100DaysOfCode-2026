package Day_80;

public class Question2 {
    public static boolean isPowerOfTwoOrZero(int n) {
        return n == 0 || (n > 0 && (n & (n - 1)) == 0);
    }

    public static void main(String[] args) {
        int n = 0;
        System.out.println(isPowerOfTwoOrZero(n));
    }
}