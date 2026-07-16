public class Q2 {

    public static long countSubarrays(int[] arr, int l, int r) {
        return countValid(arr, r) - countValid(arr, l - 1);
    }
    
    private static long countValid(int[] arr, int bound) {
        long totalSubarrays = 0;
        long currentLength = 0;
        
        for (int num : arr) {
            if (num <= bound) {
                currentLength++;
                totalSubarrays += currentLength;
            } else {
                currentLength = 0;
            }
        }
        
        return totalSubarrays;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int l = 2;
        int r = 5;
        
        long result = countSubarrays(arr, l, r);
        
        System.out.println("Output: " + result); 
    }
}