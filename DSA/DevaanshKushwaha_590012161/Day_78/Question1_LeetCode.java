class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;   // pairs cancel out to 0
        }
        return result;
    }
}
