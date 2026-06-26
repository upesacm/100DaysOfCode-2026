#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int compare(const void *a, const void *b)
{
    return (*(int*)a - *(int*)b);
}

bool areEqual(int a[], int b[], int n)
{
    qsort(a, n, sizeof(int), compare);
    qsort(b, n, sizeof(int), compare);

    for(int i = 0; i < n; i++)
    {
        if(a[i] != b[i])
            return false;
    }

    return true;
}

int main()
{
    int a[] = {1,2,5,4,0};
    int b[] = {2,4,5,0,1};

    int n = sizeof(a)/sizeof(a[0]);

    if(areEqual(a,b,n))
        printf("true\n");
    else
        printf("false\n");

    return 0;
}