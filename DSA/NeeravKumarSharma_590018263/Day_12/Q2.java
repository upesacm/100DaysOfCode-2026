import java.util.HashMap;
import java.util.HashSet;

class Q2 {
    public int shortestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        HashSet<Character> distinctChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            distinctChars.add(c);
        }
        int totalDistinct = distinctChars.size();

        HashMap<Character, Integer> counts = new HashMap<>();
        int left = 0, minLength = s.length();
        int formed = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            counts.put(rightChar, counts.getOrDefault(rightChar, 0) + 1);

            if (counts.get(rightChar) == 1) {
                formed++;
            }

            while (formed == totalDistinct) {
                minLength = Math.min(minLength, right - left + 1);

                char leftChar = s.charAt(left);
                counts.put(leftChar, counts.get(leftChar) - 1);
                if (counts.get(leftChar) == 0) {
                    formed--;
                }
                left++;
            }
        }

        return minLength;
    }

    public static void main(String[] args) {
        Q2 sol = new Q2();
        String input = "abcda";
        System.out.println("Input: " + input + ", Output: " + sol.shortestSubstring(input));
    }
}