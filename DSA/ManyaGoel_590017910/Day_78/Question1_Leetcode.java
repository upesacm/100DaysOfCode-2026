public class Question1_Leetcode{
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int x : nums)  ans ^= x;
        return ans;     
    }
}