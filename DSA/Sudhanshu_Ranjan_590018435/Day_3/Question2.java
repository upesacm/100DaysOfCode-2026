public class Question2 {

    public int search(int[] array, int target) {
        int start = first(array, target);

        if (start == -1) {
            return 0;
        }

        int end = last(array, target);
        return end - start + 1;
    }

    private int first(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] >= target) {
                if (array[mid] == target) {
                    index = mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }

    private int last(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] <= target) {
                if (array[mid] == target) {
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
