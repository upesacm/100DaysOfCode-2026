class Solution {
    public int removeElement(int[] nums, int k) {
        int i = 0;
        for (int n : nums) 
            if (n != k) 
                nums[i++] = n;
        return i;
    }
}