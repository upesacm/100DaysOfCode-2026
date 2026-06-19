class Solution {
    public int Problem2_leetcode(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        int expectedSum = n * (n + 1) / 2;

        return expectedSum - sum;
    }
}