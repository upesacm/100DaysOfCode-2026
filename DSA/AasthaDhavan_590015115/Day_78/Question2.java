import java.util.*;
public class Question2 {
    public static int maximumXOR(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, nums[i] ^ nums[j]);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(maximumXOR(nums));
    }
}