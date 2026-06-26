import java.util.Arrays;

public class CheckEqualArrays {
    
    public static boolean areEqual(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2);
    }
    
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] arr3 = {1, 2, 3, 4, 6};
        
        System.out.println("Equal: " + areEqual(arr1, arr2)); 
        System.out.println("Not Equal: " + areEqual(arr1, arr3));  
    }
}
