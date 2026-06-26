public class Question {
  class Solution {
    public int sumofarray(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i< n; i++){
            sum = sum + nums[i];
        }
        return sum;
    }
  }
}