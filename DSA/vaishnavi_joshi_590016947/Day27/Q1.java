class Solution {
    public int compress(char[] chars) {

        int i = 0;      // Read pointer
        int index = 0;  // Write pointer

        while (i < chars.length) {

            char current = chars[i];
            int count = 0;

            // Count consecutive same characters
            while (i < chars.length && chars[i] == current) {
                count++;
                i++;
            }

            // Write the character
            chars[index++] = current;

            // Write the count if greater than 1
            if (count > 1) {
                String str = String.valueOf(count);

                for (char c : str.toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
}