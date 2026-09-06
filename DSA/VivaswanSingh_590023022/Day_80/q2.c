#include <stdio.h>
#include <stdbool.h>

bool isPowerOfTwoOrZero(int n)
{
    if (n == 0)
        return true;

    if (n > 0 && (n & (n - 1)) == 0)
        return true;

    return false;
}

int main()
{
    int n;

    printf("Enter a number: ");
    scanf("%d", &n);

    if (isPowerOfTwoOrZero(n))
        printf("true\n");
    else
        printf("false\n");

    return 0;
}