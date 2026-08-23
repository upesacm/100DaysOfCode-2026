package DSA.Saransh_590024524.DAy50;

public class Question1_Leetcode {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int i,j,g=0;
        int sml = nums[0];
        for(i=0 ; i<k ; i++)
        {
            g=0;    
            sml = nums[0];
            for(j=0 ; j<nums.length ; j++)
            {
                if(nums[j] < sml)
                {   sml = nums[j];
                    g = j;
                }
            }
            nums[g] = nums[g]*multiplier;
            sml = 0;
        }
        return nums;
    }
}
