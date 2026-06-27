import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static int smallestDistinctWindow(String str) {

        // Count total distinct characters
        HashSet<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }

        int totalDistinct = set.size();

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < str.length(); right++) {

            char ch = str.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Shrink the window while it contains all distinct characters
            while (map.size() == totalDistinct) {

                minLength = Math.min(minLength, right - left + 1);

                char leftChar = str.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;
            }
        }

        return minLength;
    }

    public static void main(String[] args) {

        System.out.println(smallestDistinctWindow("abcda"));
        System.out.println(smallestDistinctWindow("zzxyzz"));
        System.out.println(smallestDistinctWindow("abcaac"));
    }
}
