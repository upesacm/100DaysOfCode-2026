package DSA.MuditaSingh_500122701.Day_2;

class Question1{
    public static int largestElement(int[] nums){

        int max = Integer.MIN_VALUE;

        for(int i=0 ;i<nums.length ;i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }
        return max;
    }
    public static void main(String[] args){
        int[] nums = {10 ,5 ,10};

        System.out.println("The largest element is: " + largestElement(nums));
    }
}