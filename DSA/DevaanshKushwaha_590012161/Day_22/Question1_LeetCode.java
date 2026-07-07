class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0; // next position to place a non-zero element

        // Step 1: shift all non-zero elements to the front, in order
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        // Step 2: fill the remaining positions with 0
        for (int i = insertPos; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
