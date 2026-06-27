class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sMap = new int[256];
        int[] tMap = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (sMap[c1] != tMap[c2]) {
                return false;
            }

            sMap[c1] = i + 1;
            tMap[c2] = i + 1;
        }

        return true;
    }
}