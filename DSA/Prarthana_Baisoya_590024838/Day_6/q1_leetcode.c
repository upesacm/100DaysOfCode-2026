#include <stdio.h>

int solve(int a[], int s, int e)
{
    int p1 = 0;
    int p2 = 0;

    for(int i = s; i <= e; i++)
    {
        int take = a[i] + p2;
        int notTake = p1;

        int curr;

        if(take > notTake)
            curr = take;
        else
            curr = notTake;

        p2 = p1;
        p1 = curr;
    }

    return p1;
}

int main()
{
    int n;
    scanf("%d", &n);

    int a[n];

    for(int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }

    if(n == 1)
    {
        printf("%d", a[0]);
        return 0;
    }

    int x = solve(a, 0, n - 2);
    int y = solve(a, 1, n - 1);

    if(x > y)
        printf("%d", x);
    else
        printf("%d", y);

    return 0;
}
