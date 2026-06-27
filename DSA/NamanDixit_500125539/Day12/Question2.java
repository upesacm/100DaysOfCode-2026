import java.util.HashMap;
import java.util.HashSet;

public class Question2 {
    public static int smallestDistinctWindow(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        // Step 1: Find total distinct characters in the string
        HashSet<Character> distinctSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            distinctSet.add(str.charAt(i));
        }
        int totalDistinct = distinctSet.size();

        // Map to keep track of character counts in the current window
        HashMap<Character, Integer> windowMap = new HashMap<>();
        
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int uniqueInWindow = 0;

        // Step 2: Expand the window using the right pointer
        for (int right = 0; right < str.length(); right++) {
            char rightChar = str.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            // If this is the first time we see this character in the current window
            if (windowMap.get(rightChar) == 1) {
                uniqueInWindow++;
            }

            // Step 3: Shrink the window from the left if it contains all distinct characters
            while (uniqueInWindow == totalDistinct) {
                int currentWindowLen = right - left + 1;
                minLen = Math.min(minLen, currentWindowLen);

                char leftChar = str.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                // If a character count drops to 0, it's no longer fully inside the window
                if (windowMap.get(leftChar) == 0) {
                    uniqueInWindow--;
                }
                
                left++; // Move the left pointer forward
            }
        }

        return minLen;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String str = sc.nextLine(); // Example input: "aabcbcdbca"
        System.out.println("Smallest window length: " + smallestDistinctWindow(str)); 
        // Output: 4
    }
}