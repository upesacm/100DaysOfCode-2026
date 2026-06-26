class Solution {
    public int[] numberOfLines(int[] arr, String s) {
        int l = 1, wd = 0;
        for (char c : s.toCharArray()) {
            int w = arr[c - 'a'];
            wd += w;
            if (wd > 100) { l++; wd = w; }
        } return new int[] { l, wd };
    }
}