class Solution {
    
    public int countOccurrences(int[] arr, int target) {
        int first = firstOccurrence(arr, target);
        
        if (first == -1) {
            return 0;
        }
        
        int last = lastOccurrence(arr, target);
        return last - first + 1;
    }
    
    private int firstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int ans = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                ans = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }
    
    private int lastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int ans = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                ans = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }
}
