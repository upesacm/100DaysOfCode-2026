
int compress(char* chars, int charsSize) {
    int left = 0;
    int right = 0;
    while (right < charsSize) {
        char current = chars[right];
        int count = 0;
        while (right < charsSize && chars[right] == current) {
            right++;
            count++;
        }
        chars[left++] = current;if (count > 1) {
            char temp[12];
            sprintf(temp, "%d", count);
            int i = 0;
            while (temp[i] != '\0') {
                chars[left++] = temp[i];
                i++;
            }
        }
    }
    return left;
}