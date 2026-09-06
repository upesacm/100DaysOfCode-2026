class Solution {
    public int singleNumber(int[] nums) {
        int xorr=0;
        for(int x: nums){
            xorr^=x;
        }
        return xorr;
    }
}