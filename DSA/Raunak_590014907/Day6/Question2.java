import java.util.*;

public class Question {

    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2) {

        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] <= arr2[j]) {

                if (ans.isEmpty() || ans.get(ans.size() - 1) != arr1[i]) {
                    ans.add(arr1[i]);
                }

                i++;

            } else {

                if (ans.isEmpty() || ans.get(ans.size() - 1) != arr2[j]) {
                    ans.add(arr2[j]);
                }

                j++;
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