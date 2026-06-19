class Solution {

    public boolean canJump(int[] nums) {

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > maxReach) { // Current position cannot be reached
                return false;
            }

            maxReach = Math.max(maxReach, i + nums[i]); // Update farthest reachable index
        }

        return true; // Last index can be reached
    }
}

//logic: keep track of the farthest index reachable.
//If current index exceeds maxReach, the end cannot be reached.
//Otherwise keep extending the reachable range.