import java.util.*;

public class Question2 {
    public static int smallestWindow(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) set.add(c);

        int distinct = set.size(), ans = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() == distinct) {
                ans = Math.min(ans, r - l + 1);
                char ch = s.charAt(l++);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) map.remove(ch);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(smallestWindow("abcda")); // 4
    }
}