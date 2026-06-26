// LeetCode Problem 205: Isomorphic Strings

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int count1 = s.length();
        int count2 = t.length();
        
        if (count1 != count2) {
            return false;
        }
        
        int mapS[] = new int[256];
        int mapT[] = new int[256];
        
        for (int i = 0; i < count1; i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            
            if (mapS[charS] != mapT[charT]) {
                return false;
            }
            
            mapS[charS] = i + 1;
            mapT[charT] = i + 1;
        }
        
        return true;
    }
}
