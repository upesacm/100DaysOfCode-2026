class Solution {
    int array_sum;
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2;
        for(int i = 0;i<n;i++){
            array_sum += nums[i];
        }
        int missing = sum-array_sum;
        return missing;
    }
}
