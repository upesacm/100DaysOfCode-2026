import java.util.HashMap;

public class Main {

    static boolean areEqual(int[] a, int[] b) {

        if (a.length != b.length) {
            return false;
        }

        HashMap<Integer, Integer> freq = new HashMap<>();

        // Count frequency of elements in first array
        for (int num : a) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Decrease frequency using second array
        for (int num : b) {
            if (!freq.containsKey(num)) {
                return false;
            }

            freq.put(num, freq.get(num) - 1);

            if (freq.get(num) == 0) {
                freq.remove(num);
            }
        }

        return freq.isEmpty();
    }

    public static void main(String[] args) {

        int[] a1 = {1, 2, 5, 4, 0};
        int[] b1 = {2, 4, 5, 0, 1};

        System.out.println(areEqual(a1, b1)); // true

        int[] a2 = {1, 2, 5};
        int[] b2 = {2, 4, 15};

        System.out.println(areEqual(a2, b2)); // false
    }
}
