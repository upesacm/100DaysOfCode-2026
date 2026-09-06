import java.util.*;
public class Question2 {
    public static boolean isPowerOfTwo(int n) {
        if(n == 0){
            return true;
        }
        return (n & (n - 1)) == 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPowerOfTwo(n));
    }
}