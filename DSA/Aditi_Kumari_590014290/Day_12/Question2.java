package Day_12;

import java.util.*;

public class Question2 {
    public int shortestSubstring(String s) {
        Set<Character> st = new HashSet<>();
        for (char ch : s.toCharArray())
            st.add(ch);
        int req = st.size();
        Map<Character, Integer> freq = new HashMap<>();
        int l = 0, ans = s.length();
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            while (freq.size() == req) {
                ans = Math.min(ans, r - l + 1);
                char c = s.charAt(l++);
                freq.put(c, freq.get(c) - 1);
                if (freq.get(c) == 0)
                    freq.remove(c);
            }
        }
        return ans;
    }
}