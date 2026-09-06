int compress(char* chars, int charsSize) {
    int read = 0;
    int write = 0;

    while (read < charsSize) {
        char current = chars[read];
        int count = 0;

        // Count consecutive same characters
        while (read < charsSize && chars[read] == current) {
            read++;
            count++;
        }

        // Store the character
        chars[write++] = current;

        // Store count only if greater than 1
        if (count > 1) {
            char digits[10];
            int d = 0;

            while (count > 0) {
                digits[d++] = (count % 10) + '0';
                count /= 10;
            }

            // Reverse digits while writing
            while (d > 0) {
                chars[write++] = digits[--d];
            }
        }
    }

    return write;
}