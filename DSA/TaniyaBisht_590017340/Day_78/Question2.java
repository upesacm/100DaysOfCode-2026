
import java.util.*;
class MaxXOR {
    public static int findMaximumXOR(int[] nums) {
        int maxXor = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int xor = nums[i] ^ nums[j];
                maxXor = Math.max(maxXor, xor);
            }
        }
        return maxXor;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int ans = findMaximumXOR(nums);
        System.out.println("Maximum XOR:" + ans);
    }
}