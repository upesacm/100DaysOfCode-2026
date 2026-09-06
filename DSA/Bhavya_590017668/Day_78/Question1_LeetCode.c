char* addBinary(char* a, char* b) {
    int lenA = strlen(a);
    int lenB = strlen(b);
    int maxLen = lenA > lenB ? lenA : lenB;
    char *result = malloc(maxLen + 2);
    int i = lenA - 1, j = lenB - 1, k = maxLen, carry = 0;

    result[maxLen + 1] = '\0';

    while (i >= 0 || j >= 0 || carry) {
        int sum = carry;
        if (i >= 0) sum += a[i--] - '0';
        if (j >= 0) sum += b[j--] - '0';
        result[k--] = (sum % 2) + '0';
        carry = sum / 2;
    }

    char *ans = malloc(strlen(result + k + 1) + 1);
    strcpy(ans, result + k + 1);
    free(result);
    return ans;
}