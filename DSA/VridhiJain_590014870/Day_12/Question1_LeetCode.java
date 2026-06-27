class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int l = 1;
        int w = 0;
        for (int i = 0; i < s.length(); i++) {
            int x = widths[s.charAt(i) - 'a'];
            if (w + x > 100) {
                l++;
                w = x;
            } else {
                w = w + x;
            }
        }
        return new int[]{l, w};
    }
}