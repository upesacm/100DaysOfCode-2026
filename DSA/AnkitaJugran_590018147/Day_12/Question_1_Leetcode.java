class Solution {
    public int[] numberOfLines(int[] widths, String s) {

        int no_of_lines = 1 , current_width = 0;

        for ( int i = 0 ; i < s.length() ; i++ ){
            char ch = s.charAt(i);
            int index = ch - 'a';
            current_width += widths[index];
            if( current_width > 100 ){
                no_of_lines++;
                current_width = widths[index];
            }
        }
        return new int[] {no_of_lines ,current_width};
    }
}