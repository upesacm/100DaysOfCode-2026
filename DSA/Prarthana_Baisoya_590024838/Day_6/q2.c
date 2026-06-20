#include <stdio.h>

int main()
{
    int n, m;

    scanf("%d", &n);
    int a[n];

    for(int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }

    scanf("%d", &m);
    int b[m];

    for(int i = 0; i < m; i++)
    {
        scanf("%d", &b[i]);
    }

    int i = 0, j = 0;
    int last = -1000000001;

    while(i < n && j < m)
    {
        int x;

        if(a[i] < b[j])
        {
            x = a[i];
            i++;
        }
        else if(a[i] > b[j])
        {
            x = b[j];
            j++;
        }
        else
        {
            x = a[i];
            i++;
            j++;
        }

        if(x != last)
        {
            printf("%d ", x);
            last = x;
        }
    }

    while(i < n)
    {
        if(a[i] != last)
        {
            printf("%d ", a[i]);
            last = a[i];
        }
        i++;
    }

    while(j < m)
    {
        if(b[j] != last)
        {
            printf("%d ", b[j]);
            last = b[j];
        }
        j++;
    }

    return 0;
}
