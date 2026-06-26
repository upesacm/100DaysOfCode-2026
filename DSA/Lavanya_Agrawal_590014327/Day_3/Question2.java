import java.util.*;

public class Question2 {

    public static int firstOccurrence(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int first = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return first;
    }

    public static int lastOccurrence(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int last = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return last;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int first = firstOccurrence(arr, target);

        if (first == -1) {
            System.out.println(0);
        } else {
            int last = lastOccurrence(arr, target);
            System.out.println(last - first + 1);
        }

        sc.close();
    }
}