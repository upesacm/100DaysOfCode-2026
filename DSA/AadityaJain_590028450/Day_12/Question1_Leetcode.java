/*Number of Lines To Write String
Explanation
Calculate the number of lines required to write a string based on the width of each character, where each line can hold at most 100 units, and return the result as an array [totalLines, lastLineWidth], representing the total number of lines used and the width occupied by the last line
 */

class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int i;
        int lines = 1;
        int curr = 0;

        for(i = 0; i < s.length(); i++){
            int width = widths[s.charAt(i) - 'a'];

            if(curr + width <= 100){
                curr += width;
            }else{
                lines++;
                curr = width;
            }
        }

        return new int[]{lines, curr};
    }
}
