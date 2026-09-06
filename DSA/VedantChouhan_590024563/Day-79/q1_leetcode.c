//q1_leetcode
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* addBinary(char* a, char* b) {
    int i = strlen(a) - 1;
    int j = strlen(b) - 1;

    int maxLen = (i > j ? i : j) + 2;

    char* result = malloc(maxLen + 1);

    int k = maxLen - 1;
    result[k] = '\0';

    int carry = 0;

    while (i >= 0 || j >= 0 || carry) {
        int sum = carry;

        if (i >= 0)
            sum += a[i--] - '0';

        if (j >= 0)
            sum += b[j--] - '0';

        result[--k] = (sum % 2) + '0';
        carry = sum / 2;
    }

    return result + k;
}

int main() {
    char a[10005], b[10005];

    printf("Enter first binary number: ");
    scanf("%s", a);

    printf("Enter second binary number: ");
    scanf("%s", b);

    char* result = addBinary(a, b);

    printf("Sum: %s\n", result);

    /*
       result may point inside the allocated memory,
       so free the original allocated address.
    */
    free(result - (result - result));

    return 0;
}