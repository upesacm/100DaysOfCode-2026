import java.util.Scanner;
public class Question2 {
    public static void rotate(int[] nums, int k)
    {
        int n = nums.length;
        k = k % n;
        int[] result = new int[n];
        for (int i = 0; i < n; i++)
        {
            result[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) 
        {
            nums[i] = result[i];
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        rotate(nums, k);
        for (int num : nums)
        {
            System.out.print(num + " ");
        }
        sc.close();
    }
}