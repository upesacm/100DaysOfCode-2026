package Day_79;

public class Question2 {
    public static int findSingle(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}