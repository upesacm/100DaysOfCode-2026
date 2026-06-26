#include <stdio.h>

void unionArray(int a[], int n, int b[], int m)
{
    int i = 0, j = 0;
    int last = -1;

    while (i < n && j < m)
    {
        if (a[i] < b[j])
        {
            if (a[i] != last)
            {
                printf("%d ", a[i]);
                last = a[i];
            }
            i++;
        }
        else if (a[i] > b[j])
        {
            if (b[j] != last)
            {
                printf("%d ", b[j]);
                last = b[j];
            }
            j++;
        }
        else
        {
            if (a[i] != last)
            {
                printf("%d ", a[i]);
                last = a[i];
            }
            i++;
            j++;
        }
    }

    while (i < n)
    {
        if (a[i] != last)
        {
            printf("%d ", a[i]);
            last = a[i];
        }
        i++;
    }

    while (j < m)
    {
        if (b[j] != last)
        {
            printf("%d ", b[j]);
            last = b[j];
        }
        j++;
    }
}

int main()
{
    int a[] = {1, 2, 3, 4, 5};
    int b[] = {1, 2, 3, 6, 7};

    int n = sizeof(a) / sizeof(a[0]);
    int m = sizeof(b) / sizeof(b[0]);

    unionArray(a, n, b, m);

    return 0;
}