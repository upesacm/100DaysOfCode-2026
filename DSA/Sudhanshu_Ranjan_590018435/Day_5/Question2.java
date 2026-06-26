package DSA.Sudhanshu_Ranjan_590018435.Day_5;

import java.util.HashMap;

public class Question2 {
    public static boolean areArraysEqual(int[] a, int[] b) {
        if (a.length != b.length)
            return false;

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : a) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : b) {
            if (!freq.containsKey(num))
                return false;
            freq.put(num, freq.get(num) - 1);
            if (freq.get(num) == 0)
                freq.remove(num);
        }

        return freq.isEmpty();
    }
}
