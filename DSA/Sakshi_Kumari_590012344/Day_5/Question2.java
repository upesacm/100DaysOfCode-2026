import java.util.HashMap;

class Solution {

    public boolean checkEqualArrays(int[] a, int[] b) {

        if (a.length != b.length) {
            return false;
        }

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < a.length; i++) {

            if (freq.containsKey(a[i])) {
                freq.put(a[i], freq.get(a[i]) + 1);
            } else {
                freq.put(a[i], 1);
            }
        }

        for (int i = 0; i < b.length; i++) {

            if (!freq.containsKey(b[i])) {
                return false;
            }

            freq.put(b[i], freq.get(b[i]) - 1);

            if (freq.get(b[i]) == 0) {
                freq.remove(b[i]);
            }
        }

        return freq.size() == 0;
    }
}
