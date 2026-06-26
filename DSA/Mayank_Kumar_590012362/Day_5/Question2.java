import java.util.HashMap;
class Question2 {
    public static boolean areEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        HashMap<Integer, Integer> f = new HashMap<>();

        for (int n : arr1) f.put(n, f.getOrDefault(n, 0) + 1);
        for (int n : arr2) {
            if (!f.containsKey(n)) return false;
            f.put(n, f.get(n) - 1);
            if (f.get(n) == 0) f.remove(n);
        } 
        return f.isEmpty();
    }
}