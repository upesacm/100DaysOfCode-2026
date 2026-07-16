import java.util.Scanner;
public class Question2 
{
    public static long countSubarray(int[] arr, int limit) 
    {
        long count = 0;
        int len = 0;

        for (int num : arr) 
        {
            if (num <= limit) 
                len++;
            else
                len=0;
            count += len;
        }
        return count;
    }
    public static long boundedSubarray(int[] arr, int l, int r) 
    {
        return countSubarray(arr, r) - countSubarray(arr, l - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) 
        {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter l: ");
        int l = sc.nextInt();
        System.out.print("Enter r: ");
        int r = sc.nextInt();
        long ans = boundedSubarray(arr, l, r);
        System.out.println("Count of valid subarrays = " + ans);

        sc.close();
    }
}
