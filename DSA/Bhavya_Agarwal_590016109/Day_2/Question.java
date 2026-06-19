public class Question {
    static int largest(int[] nums) {
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] > max) {
            max = nums[i];
        }
    }
    return max;
    }

public static void main(String[] args){
    int arr[] = {20,50,10,40,1};
    System.out.println(largest(arr));
}
}
