public class Question1_LeetCode {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            ans ^= nums[i];
        }
        System.gc();
        return ans;
    }
}
