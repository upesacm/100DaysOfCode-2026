class Question1_leetcode {

    public int compress(char[] chars) {

        // Position to write compressed characters
        int index = 0;

        // Pointer to traverse array
        int i = 0;

        // Traverse the array
        while (i < chars.length) {

            // Current character
            char currentChar = chars[i];

            // Count frequency
            int count = 0;

            // Count consecutive same characters
            while (i < chars.length && chars[i] == currentChar) {
                count++;
                i++;
            }

            // Store character
            chars[index] = currentChar;
            index++;

            // Store count if greater than 1
            if (count > 1) {

                String number = String.valueOf(count);

                // Store every digit separately
                for (int j = 0; j < number.length(); j++) {
                    chars[index] = number.charAt(j);
                    index++;
                }
            }
        }

        // Return new length
        return index;
    }
}