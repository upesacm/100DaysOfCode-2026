
class Solution {
    public int singleNumber(int[] nums) {
        int once=0, sec=0;
        for(int i:nums){
            once= ~sec & (once^i);
            sec = ~once & (sec^i);
        }
        return once;
    }
}