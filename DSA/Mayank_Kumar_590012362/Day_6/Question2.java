import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
class Question2 {
    public static List<Integer> union(int[] arr1, int[] arr2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : arr1) set.add(num);
        for (int num : arr2) set.add(num);
        return new ArrayList<>(set);
    }
}