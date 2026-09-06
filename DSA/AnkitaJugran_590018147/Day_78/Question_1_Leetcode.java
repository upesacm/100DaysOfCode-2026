class Solution {
    public int singleNumber(int[] nums) {
        
        int result = 0;

        for ( int i = 0 ; i < nums.length ; i ++ ){
            //XOR operator
            result = result ^ nums[i];
        }

        return result;
    }
}