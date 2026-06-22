#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

    int digits[101];

    for (int i = 0; i < n; i++) {
        scanf("%d", &digits[i]);
    }

    int carry = 1;  // adding one

    for (int i = n - 1; i >= 0; i--) {
        int sum = digits[i] + carry;
        digits[i] = sum % 10;
        carry = sum / 10;

        if (carry == 0)
            break;
    }

    if (carry) {
        printf("1 ");
        for (int i = 0; i < n; i++) {
            printf("%d ", digits[i]);
        }
    } else {
        for (int i = 0; i < n; i++) {
            printf("%d ", digits[i]);
        }
    }

    return 0;
}