#include <stdio.h>

int main()
{
    int n;

    scanf("%d", &n);

    int arr[100];
    int result[100];

    for(int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }

    int k;
    scanf("%d", &k);

    k = k % n;

    for(int i = 0; i < n; i++)
    {
        result[(i + k) % n] = arr[i];
    }

    for(int i = 0; i < n; i++)
    {
        printf("%d ", result[i]);
    }

    return 0;
}
