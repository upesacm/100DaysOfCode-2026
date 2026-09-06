import java.util.*;
class Question2 {
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                ans = ans | (1 << i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 5, 5, 5, 9};
        System.out.println(singleNumber(nums));
    }
}