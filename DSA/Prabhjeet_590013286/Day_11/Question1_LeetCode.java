//Isomorphic Strings
//Same pattern mapping between both strings

class Solution {

    public boolean isIsomorphic(String s, String t) {

        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {

            if (mapS[s.charAt(i)] != mapT[t.charAt(i)]) {
                return false;
            }

            mapS[s.charAt(i)] = i + 1;
            mapT[t.charAt(i)] = i + 1;
        }

        return true;
    }
}

//logic: each char from s should always map to the same char in t.
//store last seen positions for both strings.
//if mapping breaks at any point, return false.