public class Main {

    // Find first occurrence
    static int firstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                result = mid;
                high = mid - 1; // search left side
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // Find last occurrence
    static int lastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                result = mid;
                low = mid + 1; // search right side
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    static int countOccurrences(int[] arr, int target) {
        int first = firstOccurrence(arr, target);

        if (first == -1) {
            return 0;
        }

        int last = lastOccurrence(arr, target);

        return last - first + 1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int target = 2;

        System.out.println(countOccurrences(arr, target));
    }
}
