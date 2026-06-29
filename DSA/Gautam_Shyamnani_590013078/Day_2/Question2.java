class Question2{
    public static int findLargest(int[] nums){
        int max = nums[0];
        for(int i = 1;i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }
    public static void main(String[] args){
        int[] nums = {35,1,6,19,43};
        System.out.println(findLargest(nums));
    }
}