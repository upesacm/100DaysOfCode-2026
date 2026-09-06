char* addBinary(char* a, char* b) {
    int i = strlen(a) - 1;
    int j = strlen(b) - 1;
    int carry = 0;
    int size = strlen(a) + strlen(b) + 1;
    char *result = (char *)malloc(size);
    int index = 0;
    while (i >= 0 || j >= 0 || carry) {
        int sum = carry;
        if (i >= 0) {
            sum += a[i] - '0';
            i--;
        }
        if (j >= 0) {
            sum += b[j] - '0';
            j--;
        }
        result[index] = (sum % 2) + '0';
        index++;
        carry = sum / 2;
    }
    result[index] = '\0';
    for (int left = 0, right = index - 1; left < right; left++, right--) {
        char temp = result[left];
        result[left] = result[right];
        result[right] = temp;
    }
    return result;
}