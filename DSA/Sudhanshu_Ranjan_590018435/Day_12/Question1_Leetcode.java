package DSA.Sudhanshu_Ranjan_590018435.Day_12;

class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int l = 1, width = 0;
        for (char c: S.toCharArray()) {
            int w = widths[c - 'a'];
            width += w;
            if (width > 100) {
                l++;
                width = w;
            }
        }

        return new int[]{l, width};
    }
}