package Day_13;
import java.util.*;
public class Question2 {
    static int solve(String str) {
        int len = str.length();
        int[] ways = new int[len + 1];
        ways[0] = 1;

        HashMap<Character, Integer> prev = new HashMap<>();
        for (int i = 1; i <= len; i++) {
            ways[i] = 2 * ways[i - 1];
            char ch = str.charAt(i - 1);
            if (prev.containsKey(ch))
                ways[i] -= ways[prev.get(ch) - 1];
            prev.put(ch, i);
        }
        return ways[len];
    }
    static String betterString(String s1, String s2) {
        int first = solve(s1);
        int second = solve(s2);
        return first >= second ? s1 : s2;
    }
}
