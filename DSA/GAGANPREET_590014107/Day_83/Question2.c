#include <stdio.h>

int main() {
    unsigned int n;
    scanf("%u", &n);

    int count = 0;

    while (n > 0) {
        n = n & (n - 1);
        count++;
    }

    printf("%d\n", count);

    return 0;
}
