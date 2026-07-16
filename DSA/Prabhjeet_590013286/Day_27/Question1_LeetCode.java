/**
 * LeetCode 443 - String Compression
 * https://leetcode.com/problems/string-compression/
 */

//Need to compress the character array in-place

class Solution {

    public int compress(char[] chars) {

        int index = 0;
        int i = 0;

        while (i < chars.length) {

            char curr = chars[i];
            int count = 0;

            // count how many times this character appears
            while (i < chars.length && chars[i] == curr) {
                i++;
                count++;
            }

            chars[index++] = curr;

            // only write the count if it's more than 1
            if (count > 1) {

                String num = Integer.toString(count);

                for (char ch : num.toCharArray()) {
                    chars[index++] = ch;
                }
            }
        }

        return index;
    }
}