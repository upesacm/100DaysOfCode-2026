import java.util.*;

public class Problem2 {

    public static int smallestDistinctWindow(String str) {
        int n = str.length();

        // Count total distinct characters
        HashSet<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }

        int distinctCount = set.size();

        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, minLen = n;
        int count = 0;

        for (int end = 0; end < n; end++) {
            char ch = str.charAt(end);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.get(ch) == 1) {
                count++;
            }

            // Shrink the window
            while (count == distinctCount) {
                minLen = Math.min(minLen, end - start + 1);

                char leftChar = str.charAt(start);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    count--;
                }

                start++;
            }
        }

        return minLen;
    }

    public static void main(String[] args) {
        String str = "abcda";
        System.out.println(smallestDistinctWindow(str));
    }
}