import java.util.*;

public class Main {
    public static int smallestDistinctWindow(String str) {
        int n = str.length();

        // Find total distinct characters in the string
        Set<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }

        int distinctCount = set.size();

        // Sliding window
        Map<Character, Integer> window = new HashMap<>();
        int start = 0, minLen = n;
        int count = 0;

        for (int end = 0; end < n; end++) {
            char ch = str.charAt(end);

            window.put(ch, window.getOrDefault(ch, 0) + 1);

            // New distinct character added to window
            if (window.get(ch) == 1) {
                count++;
            }

            // If window contains all distinct characters
            while (count == distinctCount) {

                // Update minimum length
                minLen = Math.min(minLen, end - start + 1);

                // Remove leftmost character
                char leftChar = str.charAt(start);
                window.put(leftChar, window.get(leftChar) - 1);

                if (window.get(leftChar) == 0) {
                    count--;
                }

                start++;
            }
        }

        return minLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(smallestDistinctWindow(str));

        sc.close();
    }
}
