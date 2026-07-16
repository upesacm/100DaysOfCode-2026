class Solution {
    public int minLength(String s) {
        StringBuilder a = new StringBuilder();
        for (char c : s.toCharArray()) {
            int n = a.length();
            if (n > 0) {
                char t = a.charAt(n - 1);
                if ((t == 'A' && c == 'B') || (t == 'C' && c == 'D')) {
                    a.deleteCharAt(n - 1); continue;
                }
            } a.append(c);
        } return a.length();
    }
}