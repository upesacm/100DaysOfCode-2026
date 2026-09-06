package Day_82;

public class Question2 {
    public static int turnOffRightmostBit(int n) {
        return n & (n - 1);
    }
}
