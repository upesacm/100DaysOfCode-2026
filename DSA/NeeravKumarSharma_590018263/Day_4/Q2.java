import java.util.Arrays;

public class Q2 {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        
        k = k % nums.length;
    
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Q2 obj = new Q2();
        
        int [] nums = {7,8,4,5,9,11};
        int k = 3;

        System.out.println("Original array: " + Arrays.toString(nums));
        
        obj.rotate(nums, k);
        
        System.out.println("Rotated array(by "+k+" shifts):  " + Arrays.toString(nums));

    }
}