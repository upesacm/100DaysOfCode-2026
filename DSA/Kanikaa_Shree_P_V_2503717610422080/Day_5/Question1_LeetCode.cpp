class Solution {
public:
    bool canJump(vector<int>& nums) 
    {
        int c=nums.size(),a=nums[0];
        if(c==1)
           return true;
        for(int i=0;i<c;i++)
        {
            if(i>a)
               return false;
           
           if(nums[i]+i>a)
           {
            a=nums[i]+i;
          }
           
        }
        if(a>=c-1)
        {
            return true;
        }
        else
           return false;
    }
};