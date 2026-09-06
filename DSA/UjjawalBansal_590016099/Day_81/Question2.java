import java.util.Scanner;

public class Question2 {
    public static int findSingleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        
        return ones;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        
        int[] nums = new int[n];
        System.out.print("Enter the " + n + " integers: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int ans = findSingleNumber(nums);
        System.out.println(ans);
        
        sc.close();
    }
}