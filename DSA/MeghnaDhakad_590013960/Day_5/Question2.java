package DSA.MeghnaDhakad_590013960.Day_5;

import java.util.*;

public class Question2 {
    public boolean identical(int[] arr1, int[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {4, 3, 2, 1};

        Question2 obj = new Question2();
        System.out.println(obj.identical(arr1, arr2));
    }
}