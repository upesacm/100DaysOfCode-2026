import java.util.Arrays;

public class Union_of_sorted_arr {
    public static void main(String[] args) {

        int[] arr1 = {1, 2};
        int[] arr2 = {2, 3, 4};

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        int[] result = new int[arr1.length + arr2.length];

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            }
            else if (arr2[j] < arr1[i]) {
                result[k++] = arr2[j++];
            }
            else {
                result[k++] = arr1[i];
                i++;
                j++;
            }
        }

        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        System.out.println("Union of two sorted arrays is: ");
        for ( i = 0; i < k; i++) {
        System.out.print(result[i] + " ");
    }
    }
}