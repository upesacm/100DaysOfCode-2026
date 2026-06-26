class Solution {
    public int strStr(String h, String n) {
        for (int i = 0; i <= h.length() - n.length(); i++) {
            int j;

            for (j = 0; j < n.length(); j++) {
                if (h.charAt(i + j) != n.charAt(j))
                    break;
            }

            if (j == n.length())
                return i;
        }

        return -1;
    }
}