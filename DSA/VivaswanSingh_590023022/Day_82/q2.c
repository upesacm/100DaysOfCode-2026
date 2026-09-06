#include <stdio.h>

int turnOffRightmostBit(int n)
{
    return n & (n - 1);
}

int main()
{
    int n;

    scanf("%d", &n);

    printf("%d\n", turnOffRightmostBit(n));

    return 0;
}