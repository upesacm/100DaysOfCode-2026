public class Problem2 {
    public boolean Equal(int[] a, int[] b) {
        if (a.length != b.length) return false;
        java.util.HashMap<Integer, Integer> freq = new java.util.HashMap<>();
        for (int x : a) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        for (int y : b) {
            if (!freq.containsKey(y)) return false;
            freq.put(y, freq.get(y) - 1);
            if (freq.get(y) == 0) freq.remove(y);
        }
        return freq.isEmpty();
    }
}
