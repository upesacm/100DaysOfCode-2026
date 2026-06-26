public class Question2 {

    public int search(int[] arr, int target) {
        int f = findFirst(arr, target);

        if (f == -1) {
            return 0;
        }

        int l = findLast(arr, target);

        return l - f + 1;
    }

    private int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int f = -1;

        while (left <= right) {
            int m = left + (right - left) / 2;

            if (arr[m] == target) {
                f = m;
                right = m - 1;
            } else if (arr[m] < target) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }

        return f;
    }

    private int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int l = -1;

        while (left <= right) {
            int m = left + (right - left) / 2;

            if (arr[m] == target) {
                l = m;
                left = m + 1;
            } else if (arr[m] < target) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }

        return l;
    }
}