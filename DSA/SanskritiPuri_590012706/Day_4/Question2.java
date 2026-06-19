import java.util.Arrays;

public class Main {

    public static void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k % n; // Handle cases where k > n

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        rotate(arr1, k1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {-1, -100, 3, 99};
        int k2 = 2;
        rotate(arr2, k2);
        System.out.println(Arrays.toString(arr2));
    }
}
