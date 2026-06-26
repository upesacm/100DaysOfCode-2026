import java.util.*;

public class UnionOfSortedArrays {
    
    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2) {
        Set<Integer> set = new TreeSet<>();

        for (int num : arr1) {
            set.add(num);
        }
        for (int num : arr2) {
            set.add(num);
        }
        return new ArrayList<>(set);
    }
}
