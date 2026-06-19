public class Question2 {
    public int LargestElement(int[] nums) {
        int element=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>element){
                element=nums[i];
            }
        }
        return element;
    }
}
