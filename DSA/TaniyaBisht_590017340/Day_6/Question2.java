
import java.util.*;
class  UnionArr{
    public static void main(String[] args) {
        int[] arr1 = {9, 9};
        int[] arr2 = {4, 3};
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        System.out.println(set);
    }
}
