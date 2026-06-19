package DSA.MuditaSingh_500122701.Day1;

public class Question1 {

    public static int findMissingNumber(int[] nums){

        int sum =0;

        for(int i=0 ;i<nums.length ;i++){
            sum +=nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5};

        System.out.println("The missing number is: " + findMissingNumber(nums));
    }
    
}
