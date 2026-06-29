package DSA.MeghnaDhakad_590013960.Day_5;

public class Question1_Leetcode {
    public boolean canJump(int[] nums) {
        int last = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > last) {
                return false;
            }

            last = Math.max(last, i + nums[i]);

            if (last >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
    public static void main(String[] args){
        Question1_Leetcode obj = new Question1_Leetcode();
        int[] nums = {2,3,1,1,4};

        System.out.println(obj.canJump(nums));
    }
}