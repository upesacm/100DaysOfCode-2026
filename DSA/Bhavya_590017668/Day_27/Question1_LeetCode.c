int compress(char* chars, int charsSize) {
    int i = 0, index = 0;

    while (i < charsSize) {
        char current = chars[i];
        int count = 0;

        while (i < charsSize && chars[i] == current) {
            i++;
            count++;
        }

        chars[index++] = current;

        if (count > 1) {
            char temp[12];
            int len = 0;

            while (count > 0) {
                temp[len++] = (count % 10) + '0';
                count /= 10;
            }

            while (len > 0) {
                chars[index++] = temp[--len];
            }
        }
    }

    return index;
}