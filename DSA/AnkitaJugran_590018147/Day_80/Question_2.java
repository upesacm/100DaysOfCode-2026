public class PowerOf_Two_or_Zero {

    public static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return true;
        }

        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(0));   // true
        System.out.println(isPowerOfTwo(1));   // true
        System.out.println(isPowerOfTwo(2));   // true
        System.out.println(isPowerOfTwo(4));   // true
        System.out.println(isPowerOfTwo(8));   // true
        System.out.println(isPowerOfTwo(10));  // false
        System.out.println(isPowerOfTwo(15));  // false
        System.out.println(isPowerOfTwo(16));  // true
    }
}