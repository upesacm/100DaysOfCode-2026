import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (sToT.containsKey(c1) && sToT.get(c1) != c2) {
                return false;
            }

            if (tToS.containsKey(c2) && tToS.get(c2) != c1) {
                return false;
            }

            sToT.put(c1, c2);
            tToS.put(c2, c1);
        }

        return true;
    }
}