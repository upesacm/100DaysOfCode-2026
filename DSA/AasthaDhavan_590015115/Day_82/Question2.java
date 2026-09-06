import java.util.*;
public class Question2 {
    public static int turnOffRightmost(int n) {
        return n & (n - 1);
    }

    public static void main(String[] args) {
        int n = 12;

        System.out.println(turnOffRightmost(n));
    }
}