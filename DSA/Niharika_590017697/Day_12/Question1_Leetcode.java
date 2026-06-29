class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int l = 1;
        int currWidth = 0;

        for (int i = 0; i < s.length(); i++) 
        {
            int w = widths[s.charAt(i) - 'a'];

            if (currWidth + w > 100) 
            {
                l++;
                currWidth = w;
            } 
            else
                currWidth += w;
        }
        return new int[]{l, currWidth}; 
    }
}
