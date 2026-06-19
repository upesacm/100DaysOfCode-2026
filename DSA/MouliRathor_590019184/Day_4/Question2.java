public class rotateArr {
    
    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return;
        k = k % n;
        if (k == 0) return;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    private static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            // Swap elements
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        
        System.out.println("Original: " + arr);
        rotate(arr, k);
        System.out.println("Rotated by " + k + " steps: " + arr);
       
    }
}
