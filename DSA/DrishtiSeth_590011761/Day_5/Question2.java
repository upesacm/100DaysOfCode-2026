import java.util.*;

class Solution {
    public static boolean checkEqual(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : b) {
            if (!map.containsKey(num)) {
                return false;
            }

            map.put(num, map.get(num) - 1);

            if (map.get(num) == 0) {
                map.remove(num);
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 5, 4, 0};
        int[] b1 = {2, 4, 5, 0, 1};
        System.out.println(checkEqual(a1, b1)); // true

        int[] a2 = {1, 2, 5};
        int[] b2 = {2, 4, 15};
        System.out.println(checkEqual(a2, b2)); // false
    }
}
