public class Question1_Leetcode {
    class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor_one = 0;
        int xor_two = 0;

        for(int i = 0; i <= n; i++){
            xor_one = xor_one ^ i;
        }

        for (int x: nums){
            xor_two ^= x;
        }

        return xor_one ^ xor_two;
    }
}
}
