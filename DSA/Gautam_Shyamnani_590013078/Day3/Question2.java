public class Question2 {
    public static void main(String[] args){
        int[] arr = {1,1,2,2,2,2,3};
        int target = 2;
        System.out.println(countOccurences(arr,target));
    }

    public static int countOccurences(int[] arr,int target){
        int first = firstOccurence(arr,target);
        if(first == -1) return 0;
        int last = lastOccurence(arr,target);
        return last - first + 1;

    }

    private static int firstOccurence(int[] arr,int target){
        int low = 0,high = arr.length - 1;
        int result = -1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                result = mid;
                high = mid - 1;
            }else if(arr[mid] < target){
                low = mid + 1;
            }else{
                high = low - 1;
            }
        }
        return result;
    }
    private static int lastOccurence(int[] arr,int target){
        int low = 0,high = arr.length - 1;
        int result = -1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                result = mid;
                low = mid + 1;
            }else if(arr[mid] < target){
                low = mid + 1;
            }else{
                high = low - 1;
            }
        }
        return result;
    }
}
