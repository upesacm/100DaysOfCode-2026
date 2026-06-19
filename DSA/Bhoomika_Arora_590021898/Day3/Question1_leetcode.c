#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

    int digits[101];

    for(int i = 0; i < n; i++)
        scanf("%d", &digits[i]);

    for(int i = n - 1; i >= 0; i--) {
        if(digits[i] < 9) {
            digits[i]++;
            for(int j = 0; j < n; j++)
                printf("%d ", digits[j]);
            return 0;
        }
        digits[i] = 0;
    }

    printf("1 ");
    for(int i = 0; i < n; i++)
        printf("0 ");

    return 0;
}