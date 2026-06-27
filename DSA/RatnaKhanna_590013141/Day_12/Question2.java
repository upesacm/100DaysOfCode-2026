import java.util.*;
public class Main {
    public static int smallestWindow(String str) {
        // Count total distinct characters
        HashSet<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }
        int distinct = set.size();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) == 1)
                count++;
            while (count == distinct) {
                minLen = Math.min(minLen, right - left + 1);
                char leftChar = str.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    count--;
                }

                left++;
            }
        }

        return minLen;
    }

    public static void main(String[] args) {

        String str = "abcda";

        System.out.println(smallestWindow(str));
    }
}
