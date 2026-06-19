public class Question2 {

    public int countOccurrences(int[] nums, int target) {

        int startIndex = findStart(nums, target);

        if (startIndex == -1) {
            return 0;
        }

        int endIndex = findEnd(nums, target);

        return endIndex - startIndex + 1;
    }

    private int findStart(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int answer = -1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                answer = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    private int findEnd(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int answer = -1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                answer = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }
}