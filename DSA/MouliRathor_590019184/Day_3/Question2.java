class Solution {
    public static int firstOccurrence(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int result = -1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                end = mid - 1; 
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return result;
    }
    public static int lastOccurrence(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int result = -1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                start = mid + 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return result;
    }

    public static int countFreq(int[] arr, int target) {
        int first = firstOccurrence(arr, target);
        int last = lastOccurrence(arr, target);
        if (first == -1 || last == -1) {
            return 0;
        }
        return last - first + 1;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int target = 2;
        System.out.println(countFreq(arr, target)); // Output: 4
    }
}
