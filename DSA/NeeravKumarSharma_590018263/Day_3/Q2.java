class Q2 {
    public int countOcc(int[] nums, int target) {
        int first = First(nums, target);

        if (first == -1) {
            return 0;
        }
        
        int last = Last(nums, target);
        
        return last - first + 1;
    }

    private int First(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int fstIndx = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                fstIndx = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return fstIndx;
    }

    private int Last(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int lastIndx = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                lastIndx = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return lastIndx;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,2,4,5,5,6};
        int target = 2;

        Q2 solution = new Q2();
        
        System.out.println(solution.countOcc(nums, target));
    }
}