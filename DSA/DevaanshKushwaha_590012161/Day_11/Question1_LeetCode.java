import java.util.HashMap;

class Solution {                                        
    public boolean isIsomorphic(String s, String t) {  
        HashMap<Character, Character> sToT = new HashMap<>();
        HashMap<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (sToT.containsKey(sc)) {
                if (!sToT.get(sc).equals(tc)) return false;
            } else {
                if (tToS.containsKey(tc)) return false;
                sToT.put(sc, tc);
                tToS.put(tc, sc);
            }
        }
        return true;
    }
}
