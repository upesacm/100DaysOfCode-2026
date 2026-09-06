import java.util.*;
public class Question2 {
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans = ans ^ num;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2, 4, 7};
        System.out.println(singleNumber(nums));
    }
}
