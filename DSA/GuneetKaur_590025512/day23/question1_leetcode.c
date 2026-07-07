
#include <stdio.h>
void bubbleSort(int arr[], int n)
{
    int i, j, temp;

    for(i = 0; i < n - 1; i++)
    {
        for(j = 0; j < n - i - 1; j++)
        {
            if(arr[j] > arr[j + 1])
            {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

int findContentChildren(int* g, int gSize, int* s, int sSize)
{
    bubbleSort(g, gSize);
    bubbleSort(s, sSize);

    int i = 0;
    int j = 0; 

    while(i < gSize && j < sSize)
    {
        if(s[j] >= g[i])
        {
            i++;
        }
        j++;        
    }

    return i;
}