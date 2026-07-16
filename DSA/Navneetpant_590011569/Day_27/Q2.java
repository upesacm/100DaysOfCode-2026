class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int result = 0;
        int lastGreater = -1;   
        int lastValid = -1;     

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > right) {
                lastGreater = i;
            }

            if (nums[i] >= left && nums[i] <= right) {
                lastValid = i;
            }

            result += Math.max(0, lastValid - lastGreater);
        }

        return result;
    }
}