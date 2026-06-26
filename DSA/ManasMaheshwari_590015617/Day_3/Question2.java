class Question2 {
    public static void main(String args[]) {
        int array[] = {1, 1, 2, 2, 2, 2, 3}; 
        int target = 2;
        
        int firstOccurrence = findFirst(array, target);
        
        if (firstOccurrence == -1) {
            System.out.println(0);
        } else {
            int lastOccurrence = findLast(array, target);
            
            int count = lastOccurrence - firstOccurrence + 1;
            System.out.println(count);
        }
    }
    
    public static int findFirst(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (array[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    
    public static int findLast(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (array[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
