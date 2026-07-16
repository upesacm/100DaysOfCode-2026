import java.util.Arrays;

public class Q2 {
    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            result[i] = -1;
            
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    break; 
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        
        int[] result = nextGreaterElement(arr);
        
        System.out.println("Output: " + Arrays.toString(result)); 
    }
}