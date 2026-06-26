import java.util.Arrays;

public class Rotate_arr_by_k {

    private static void reverse(int start, int end, int[] arr) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};

        System.out.println("Original: " + Arrays.toString(arr));

        int k = 3;
        k = k % arr.length;

        reverse(0, arr.length - 1, arr);
        reverse(0, k - 1, arr);
        reverse(k, arr.length - 1, arr);

        System.out.println("Rotated: " + Arrays.toString(arr));
    }
}