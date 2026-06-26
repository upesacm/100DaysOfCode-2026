package DSA.Bhavya_Agarwal_590016109.Day_6;

import java.util.*;

public class Question {

    static ArrayList<Integer> union(int[] arr1, int[] arr2) {

        ArrayList<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] < arr2[j]) {

                if (result.isEmpty() ||
                    result.get(result.size() - 1) != arr1[i]) {
                    result.add(arr1[i]);
                }

                i++;
            }

            else if (arr1[i] > arr2[j]) {

                if (result.isEmpty() ||
                    result.get(result.size() - 1) != arr2[j]) {
                    result.add(arr2[j]);
                }

                j++;
            }

            else {

                if (result.isEmpty() ||
                    result.get(result.size() - 1) != arr1[i]) {
                    result.add(arr1[i]);
                }

                i++;
                j++;
            }
        }

        while (i < arr1.length) {

            if (result.isEmpty() ||
                result.get(result.size() - 1) != arr1[i]) {
                result.add(arr1[i]);
            }

            i++;
        }

        while (j < arr2.length) {

            if (result.isEmpty() ||
                result.get(result.size() - 1) != arr2[j]) {
                result.add(arr2[j]);
            }

            j++;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 2};
        int[] arr2 = {2, 3};

        System.out.println(union(arr1, arr2));
    }
}