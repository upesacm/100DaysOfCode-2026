import java.util.Scanner;

public class Question2 {
    public static int findSingleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num; 
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of elements (n): ");
        int n = sc.nextInt();
        
        int[] nums = new int[n];
        System.out.print("Enter the " + n + " integers: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        int result = findSingleNumber(nums);
        System.out.println("Output: " + result);
        sc.close();
    }
}