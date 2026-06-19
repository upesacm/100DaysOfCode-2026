public class Problem2 {
    public int Count(int[] arr, int target) {
        int first = firstIndex(arr, target);
        if (first == -1) {
            return 0;
        }
        int last = lastIndex(arr, target);
        return last - first + 1;
    }
    private int firstIndex(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                if (arr[mid] == target) {
                    index = mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
    private int lastIndex(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                if (arr[mid] == target) {
                    index = mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}