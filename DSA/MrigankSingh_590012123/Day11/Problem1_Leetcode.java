public class Problem1_Leetcode {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] mapST = new int[256];
        int[] mapTS = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (mapST[cs] != mapTS[ct]) {
                return false;
            }
            mapST[cs] = i + 1;
            mapTS[ct] = i + 1;
        }
        return true;
    }
}