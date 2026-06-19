import java.util.Scanner;
class Question2 
{
    public static int findFirst(int[] arr, int target)
    {
        int left = 0, right = arr.length - 1;
        int first = -1;
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
            {
                first = mid;
                right = mid - 1;
            }
            else if(arr[mid] < target)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        return first;
    }
    public static int findLast(int[] arr, int target)
    {
        int left = 0, right = arr.length - 1;
        int last = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
            {
                last = mid;
                left = mid + 1;
            }
            else if (arr[mid] < target)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        return last;
    }
    public static int countOccurrences(int[] arr, int target)
    {
        int first = findFirst(arr, target);
        if (first == -1)
        {
            return 0;
        }
        int last = findLast(arr, target);
        return last - first + 1;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(countOccurrences(arr, target));
        sc.close();
    }
}