package DSA.MuditaSingh_500122701.Day1;

public class Question2_Leetcode {
     public static int missingNumber(int[] nums) {
        
        int n=nums.length;
        int sum = (n*(n+1))/2;
        int actual =0;

        for(int num : nums){
            actual += num;
        }

        return sum-actual;
    }

    public static void main(String[] args){
        int [] nums = {0, 1, 2, 4, 5};
        System.out.println("The missing number is: " + missingNumber(nums));
    }
    
}
