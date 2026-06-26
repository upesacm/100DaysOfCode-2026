class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0;
        int temp;
        for(int j=i;j<=nums.length-1;j++){
            if(nums[i]==val){
                if(nums[j]!=val){
                    temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    i++;
                }

            }
            else i++;

        }
        return i;
    }
}