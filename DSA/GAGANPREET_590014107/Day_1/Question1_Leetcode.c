#include <stdio.h>

int main() {
    int n, x;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    long long sum = 0;
    printf("Enter %d elements:\n", n);

    for(int i = 0; i < n; i++) {
        scanf("%d", &x);
        sum += x;
    }
    long long expected = (long long)n * (n + 1) / 2;

    printf("Missing number = %lld\n", expected - sum);

    return 0;
}