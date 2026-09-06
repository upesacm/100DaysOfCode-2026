#include <stdio.h>
#include <stdbool.h>
bool isPowerOfTwoOrZero(int n) {
    if (n == 0)
        return true;
    if ((n & (n - 1)) == 0)
        return true;
    return false;
}
int main() {
    int n;
    scanf("%d", &n);
    if (isPowerOfTwoOrZero(n))
        printf("true\n");
    else
        printf("false\n");
    return 0;
}