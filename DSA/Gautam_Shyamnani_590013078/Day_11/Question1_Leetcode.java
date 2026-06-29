class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mapST = new int[256];
        int[] mapTS = new int[256];

        for(int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(mapST[c1] != mapTS[c2]){
                return false;
            }
            mapST[c1] = i + 1;
            mapTS[c2] = i + 1;
        }
        return true;
    }
}