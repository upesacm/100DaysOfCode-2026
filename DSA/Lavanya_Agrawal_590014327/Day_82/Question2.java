import java.util.*;

public class Question2 {

    public static int turnOffRightmostSetBit(int n) {
        return n & (n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(turnOffRightmostSetBit(n));

        sc.close();
    }
}