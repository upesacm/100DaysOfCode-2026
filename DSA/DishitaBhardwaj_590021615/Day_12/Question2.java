import java.util.*;

public class Question2 {
    public static int shortestSubstring(String str) {
        Set<Character> set = new HashSet<>();

        // Count distinct characters
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }

        int distinct = set.size();

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Shrink the window while it contains all distinct characters
            while (map.size() == distinct) {
                minLen = Math.min(minLen, right - left + 1);

                char leftChar = str.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;
            }
        }

        return minLen;
    }

    public static void main(String[] args) {
        String str = "abcda";
        System.out.println(shortestSubstring(str));
    }
}