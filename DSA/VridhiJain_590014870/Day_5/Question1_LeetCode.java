package DSA.VridhiJain_590014870.Day_5;
class Solution {
    public boolean canJump(int[] nums) {

        int i = 0;

        while (i < nums.length - 1) {

            if (nums[i] == 0) {
                return false;
            }

            int bestIndex = i;
            int farthest = i;

            for (int jump = 1; jump <= nums[i] && i + jump < nums.length; jump++) {

                if (i + jump + nums[i + jump] > farthest) {
                    farthest = i + jump + nums[i + jump];
                    bestIndex = i + jump;
                }
            }

            if (bestIndex == i) {
                i = i + nums[i];
            } else {
                i = bestIndex;
            }
        }

        return true;
    }
}