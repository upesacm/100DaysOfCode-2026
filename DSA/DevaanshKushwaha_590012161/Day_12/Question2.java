public class SmallestDistinctWindow {
    public static int smallestWindow(String s) {
        int n = s.length();
        
        // Step 1: find all distinct characters
        Set<Character> distinct = new HashSet<>();
        for (char c : s.toCharArray()) distinct.add(c);
        int required = distinct.size();

        // Step 2: sliding window
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, formed = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            // expand right
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // check if this char is fully "formed" (count >= 1)
            if (window.get(c) == 1) formed++;

            // shrink left when all distinct chars are covered
            while (formed == required) {
                minLen = Math.min(minLen, right - left + 1);

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (window.get(leftChar) == 0) formed--;
                left++;
            }
        }

        return minLen;
    }

    public static void main(String[] args) {
        System.out.println(smallestWindow("abcda")); // 4
        System.out.println(smallestWindow("aabcbcdbca")); // 4
    }
}
