class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> m1 = new HashMap<>();
        HashMap<Character, Character> m2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (m1.containsKey(a) && m1.get(a) != b)
                return false;
            if (m2.containsKey(b) && m2.get(b) != a)
                return false;
            m1.put(a, b);
            m2.put(b, a);
        }

        return true;
    }
}