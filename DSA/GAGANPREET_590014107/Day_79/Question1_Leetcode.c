#include <stdlib.h>
#include <string.h>

char* addBinary(char* a, char* b) {
    int i = strlen(a) - 1;
    int j = strlen(b) - 1;

    int n = (i > j ? i : j) + 2;

    char* result = (char*)malloc(n + 1);
    result[n] = '\0';

    int k = n - 1;
    int carry = 0;

    while (i >= 0 || j >= 0 || carry) {
        int sum = carry;

        if (i >= 0)
            sum += a[i--] - '0';

        if (j >= 0)
            sum += b[j--] - '0';

        result[k--] = (sum % 2) + '0';
        carry = sum / 2;
    }

    if (k >= 0) {
        memmove(result, result + k + 1, n - k);
    }

    return result;
}
