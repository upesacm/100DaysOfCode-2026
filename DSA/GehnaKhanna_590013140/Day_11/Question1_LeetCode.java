class Solution {
    public boolean isIsomorphic(String s, String t) {

        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            if (mapS[chS] != mapT[chT]) {
                return false;
            }

            mapS[chS] = i + 1;
            mapT[chT] = i + 1;
        }

        return true;
    }
}
