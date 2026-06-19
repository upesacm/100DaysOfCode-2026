bool canJump(int* nums, int numsSize) {
    int maxReach = 0;

    for(int i = 0; i < numsSize; i++) {

        // Cannot reach this index
        if(i > maxReach) {
            return false;
        }

        // Update farthest reachable index
        if(i + nums[i] > maxReach) {
            maxReach = i + nums[i];
        }

        // Last index is reachable
        if(maxReach >= numsSize - 1) {
            return true;
        }
    }

    return true;
}