package DSA.MeghnaDhakad_590013960.Day_6;
import java.util.*;

public class Question2 {
    public static void main(String[] args) {

        int[] arr1 = {1, 2};
        int[] arr2 = {2, 3};

        TreeSet<Integer> union = new TreeSet<>();

        for (int x : arr1) {
            union.add(x);
        }

        for (int x : arr2) {
            union.add(x);
        }

        System.out.println(union);
    }
}
