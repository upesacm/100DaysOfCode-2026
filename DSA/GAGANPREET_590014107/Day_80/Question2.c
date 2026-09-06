#include <stdio.h>
#include <stdbool.h>

bool isPowerOfTwoOrZero(int n) {
    return n == 0 || (n > 0 && (n & (n - 1)) == 0);
}

int main() {
    int n;

    printf("Enter n: ");
    scanf("%d", &n);

    if (isPowerOfTwoOrZero(n))
        printf("true\n");
    else
        printf("false\n");

    return 0;
}
