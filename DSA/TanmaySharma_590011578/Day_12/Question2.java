import java.util.*;

public class Question2 {

    public static int smallestSubstring(String str) {
        // Count distinct characters
        HashSet<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }

        int totalDistinct = set.size();
        HashMap<Character, Integer> freq = new HashMap<>();

        int left = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);

            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            if (freq.get(ch) == 1) {
                count++;
            }

            while (count == totalDistinct) {
                minLen = Math.min(minLen, right - left + 1);

                char leftChar = str.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);

                if (freq.get(leftChar) == 0) {
                    count--;
                }

                left++;
            }
        }

        return minLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(smallestSubstring(str));

        sc.close();
    }
}