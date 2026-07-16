import java.util.Scanner;

public class Question2 {

    private static long countSubarraysWithMaxBound(int[] arr, int limit) {
        long totalSubarrays = 0;
        long currentValidLength = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= limit) {
                currentValidLength++;
                totalSubarrays += currentValidLength;
            } else {
                currentValidLength = 0;
            }
        }

        return totalSubarrays;
    }

    public static long numSubarraysBoundedMax(int[] arr, int l, int r) {
        long countAtMostR = countSubarraysWithMaxBound(arr, r);

        long countStrictlyLessThanL = countSubarraysWithMaxBound(arr, l - 1);

        return countAtMostR - countStrictlyLessThanL;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the least element in the range ");
        int l = sc.nextInt();

        System.out.println("Enter the largest element in the range ");
        int r = sc.nextInt();

        System.out.println("Count of subarrays whose maximum element lies within the range [" + l + ", " + r + "]: "
                + numSubarraysBoundedMax(arr, l, r));
        sc.close();
    }
}