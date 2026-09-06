package Day_83;

public class Question2 {
    public static int countSetBits(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}