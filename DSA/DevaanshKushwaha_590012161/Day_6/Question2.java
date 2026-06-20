import java.util.*;

class Solution {
    public static int[] unionSortedArrays(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            // Skip duplicates in arr1
            if (i > 0 && arr1[i] == arr1[i - 1]) { i++; continue; }

            if (arr1[i] < arr2[j]) {
                result.add(arr1[i++]);
            } else if (arr1[i] > arr2[j]) {
                result.add(arr2[j++]);
            } else {
                result.add(arr1[i++]); // same element, add once
                j++;
            }
        }

        // Remaining elements
        while (i < arr1.length) {
            if (i == 0 || arr1[i] != arr1[i - 1]) result.add(arr1[i]);
            i++;
        }
        while (j < arr2.length) {
            if (j == 0 || arr2[j] != arr2[j - 1]) result.add(arr2[j]);
            j++;
        }

        return result.stream().mapToInt(x -> x).toArray();
    }
}
