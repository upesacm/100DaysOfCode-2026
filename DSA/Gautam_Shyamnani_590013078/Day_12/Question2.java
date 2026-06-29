import java.util.*;

public class Question2 {

    public static int smallestWindow(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        int required = set.size();

        int[] freq = new int[256];
        int left = 0, count = 0, minLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            if (freq[ch] == 0) {
                count++;
            }
            freq[ch]++;
            while (count == required) {
                minLen = Math.min(minLen, right - left + 1);

                char leftChar = s.charAt(left);
                freq[leftChar]--;

                if (freq[leftChar] == 0) {
                    count--; 
                }

                left++;
            }
        }

        return minLen;
    }

    public static void main(String[] args) {
        System.out.println(smallestWindow("abbcd"));  
    }
}