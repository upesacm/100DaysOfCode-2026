
public class Question1_leetcode {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (nums[i] == 0) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }

            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }
    }

}
