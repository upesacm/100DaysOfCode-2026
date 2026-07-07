// Move Zeroes to end of array
// LeetCode 203
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
       int j = 0;//postion
       int i = 0;//traversing
       int n = nums.size();
       while(i <nums.size() ) {
        if(nums[i] != 0){
          nums[j]=nums[i];
          j++;
        }
            i++;
       }
       while(j < n)
      { nums[j] = 0;
          j++;}

    }
};