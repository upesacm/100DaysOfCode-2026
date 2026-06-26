class Solution {
public:
    bool canJump(vector<int>& nums) {
        //n-i-nums[i]==0
        int n=nums.size(),max=0,final_position=n-1;
        for(int i=n-2;i>=0;i--)  
        {
            if((i+nums[i])>=final_position)
            {
                final_position =i;
            }
        }
        
      if(final_position==0)
      {
        return true ;
      }  
      return false ;
    }
};