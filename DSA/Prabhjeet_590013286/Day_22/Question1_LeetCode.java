//Need to move all zeroes to the end while keeping the order same

class Solution {

    public void moveZeroes(int[] nums) {

        int index = 0;

        // first place all non-zero numbers in front
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {

                nums[index] = nums[i];
                index++;
            }
        }

        // now fill the remaining places with zeroes
        while (index < nums.length) {

            nums[index] = 0;
            index++;
        }
    }
}