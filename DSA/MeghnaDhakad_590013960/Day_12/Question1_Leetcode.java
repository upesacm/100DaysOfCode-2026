class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] st = new int[256];
        int[] ts = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (st[s.charAt(i)] != ts[t.charAt(i)]) {
                return false;
            }

            st[s.charAt(i)] = i + 1;
            ts[t.charAt(i)] = i + 1;
        }

        return true;
    }
}