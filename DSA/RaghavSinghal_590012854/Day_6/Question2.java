import java.util.*;

class Solution {
    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2) {
        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            int val;

            if (arr1[i] < arr2[j]) {
                val = arr1[i++];
            } else if (arr1[i] > arr2[j]) {
                val = arr2[j++];
            } else {
                val = arr1[i];
                i++;
                j++;
            }

            if (ans.isEmpty() || ans.get(ans.size() - 1) != val) {
                ans.add(val);
            }
        }

        while (i < arr1.length) {
            if (ans.isEmpty() || ans.get(ans.size() - 1) != arr1[i]) {
                ans.add(arr1[i]);
            }
            i++;
        }

        while (j < arr2.length) {
            if (ans.isEmpty() || ans.get(ans.size() - 1) != arr2[j]) {
                ans.add(arr2[j]);
            }
            j++;
        }

        return ans;
    }
}