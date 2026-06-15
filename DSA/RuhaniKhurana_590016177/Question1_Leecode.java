class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int Sum = n * (n + 1) / 2;
        int realsum = 0;
        for (int num : nums) {
            realsum += num;
        }
        return Sum - realsum;
    }
}