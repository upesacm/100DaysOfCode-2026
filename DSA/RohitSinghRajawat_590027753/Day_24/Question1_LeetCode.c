#include<stdio.h>
#include<stdbool.h>
int sumOfSquares(int n)
{
    int sum = 0;

    while (n > 0)
    {
        int digit = n % 10;
        sum += digit * digit;
        n = n / 10;
    }

    return sum;
}

bool isHappy(int n)
{
    int slow = n;
    int fast = n;
    do
    {
        slow = sumOfSquares(slow);
        fast = sumOfSquares(sumOfSquares(fast));

    } while (slow != fast);
    return slow == 1;
}