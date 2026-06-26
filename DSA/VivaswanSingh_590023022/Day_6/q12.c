#include <stdio.h>

void unionArrays(int arr1[], int n, int arr2[], int m)
{
    int i = 0, j = 0;
    int result[n + m];
    int k = 0;

    while(i < n && j < m)
    {
        int val;

        if(arr1[i] < arr2[j])
            val = arr1[i++];
        else if(arr1[i] > arr2[j])
            val = arr2[j++];
        else
        {
            val = arr1[i];
            i++;
            j++;
        }

        if(k == 0 || result[k-1] != val)
            result[k++] = val;
    }

    while(i < n)
    {
        if(k == 0 || result[k-1] != arr1[i])
            result[k++] = arr1[i];
        i++;
    }

    while(j < m)
    {
        if(k == 0 || result[k-1] != arr2[j])
            result[k++] = arr2[j];
        j++;
    }

    printf("Union: ");
    for(i = 0; i < k; i++)
        printf("%d ", result[i]);
}

int main()
{
    int arr1[] = {1, 2};
    int arr2[] = {2, 3};

    int n = sizeof(arr1)/sizeof(arr1[0]);
    int m = sizeof(arr2)/sizeof(arr2[0]);

    unionArrays(arr1, n, arr2, m);

    return 0;
}