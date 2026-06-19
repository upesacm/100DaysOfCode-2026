#include <stdio.h>

int main()
{
    int n;

    scanf("%d", &n);

    int digits[101];

    for(int i = 0; i < n; i++)
    {
        scanf("%d", &digits[i]);
    }

    int carry = 1;

    for(int i = n - 1; i >= 0; i--)
    {
        digits[i] = digits[i] + carry;

        if(digits[i] == 10)
        {
            digits[i] = 0;
            carry = 1;
        }
        else
        {
            carry = 0;
            break;
        }
    }

    if(carry == 1)
    {
        printf("1 ");
        for(int i = 0; i < n; i++)
        {
            printf("%d ", digits[i]);
        }
    }
    else
    {
        for(int i = 0; i < n; i++)
        {
            printf("%d ", digits[i]);
        }
    }

    return 0;
}
