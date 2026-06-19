package DSA.MuditaSingh_500122701.Day_2;

class Question2_Leetcode{
    public static int removeElement(int[] nums, int val) {

        int k = 0;

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;      

    }
    public static void main(String[] args){
        int[] nums = {3,2,2,3};
        System.out.println("The new length of the array is: " + removeElement(nums, 3));
    }
}