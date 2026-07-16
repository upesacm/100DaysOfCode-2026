
class SBM{
    public static int countSubarrays(int[] arr, int bound) {
        int count = 0;
        int length = 0;
        for (int num : arr) {
            if (num <= bound) {
                length++;
            } 
            else {
                length = 0;
            }
            count += length;
        }
        return count;
    }
    public static int numSubarrayBoundedMax(int[] arr, int l, int r) {
        return countSubarrays(arr, r) - countSubarrays(arr, l - 1);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int l = 2;
        int r = 5;
        int result = numSubarrayBoundedMax(arr, l, r);
        System.out.println("Number of valid subarrays:" + result);
    }
}