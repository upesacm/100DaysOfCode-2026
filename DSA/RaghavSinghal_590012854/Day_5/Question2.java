import java.util.HashMap;

class Question2 {
    public static boolean areEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int x : arr1) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        for (int x : arr2) {
            Integer count = freq.get(x);

            if (count == null) return false;

            if (count == 1)
                freq.remove(x);
            else
                freq.put(x, count - 1);
        }

        return freq.isEmpty();
    }
}