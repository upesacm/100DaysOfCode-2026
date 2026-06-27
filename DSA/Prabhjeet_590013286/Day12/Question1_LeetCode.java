//Number of Lines To Write String
//Count lines needed with max width of 100

class Solution {

    public int[] numberOfLines(int[] widths, String s) {

        int lines = 1;
        int width = 0;

        for (int i = 0; i < s.length(); i++) {

            int curr = widths[s.charAt(i) - 'a'];

            if (width + curr > 100) {

                lines++;
                width = curr;

            } else {

                width += curr;
            }
        }

        return new int[]{lines, width};
    }
}

//logic: keep adding width of each character.
//if current line crosses 100, move to next line.
//return total lines and width of last line.