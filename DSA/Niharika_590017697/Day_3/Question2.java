import java.util.Scanner;
public class Question2
{
    static int firstOccurrence(int[] arr, int target)
    {
        int low=0, high=arr.length-1;
        int result=-1;

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid] == target)
            {
                result = mid;
                high = mid - 1; 
            }
            else if(arr[mid] < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }

        return result;
    }

    static int lastOccurrence(int[] arr, int target)
    {
        int low=0, high=arr.length - 1;
        int result=-1;

        while(low<=high)
        {
            int mid=low+(high-low)/2;

            if(arr[mid] == target)
            {
                result = mid;
                low = mid + 1; 
            }
            else if(arr[mid] < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter sorted array elements:");
        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target value: ");
        int target = sc.nextInt();

        int f = firstOccurrence(arr, target);

        if(f == -1)
        {
            System.out.println("Output: 0");
        }
        else
        {
            int l = lastOccurrence(arr, target);
            int count = l - f + 1;
            System.out.println("Output: " + count);
        }

        sc.close();
    }
}