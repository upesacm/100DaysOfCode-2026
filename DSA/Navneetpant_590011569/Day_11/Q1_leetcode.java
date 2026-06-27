class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> hm = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (hm.containsKey(c1)) {
                if (hm.get(c1) != c2) {
                    return false;
                }
            } else {
                if (hs.contains(c2)) {
                    return false;
                }

                hm.put(c1, c2);
                hs.add(c2);
            }
        }

        return true;
    }
}