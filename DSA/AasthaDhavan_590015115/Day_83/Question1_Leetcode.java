class Solution {
    public int singleNumber(int[] nums) {
        int once=0;
        int second=0;
        for(int i:nums){
            once=~second & (once^i);
            second=~once & (second^i);
        }
        return once;
    }
}