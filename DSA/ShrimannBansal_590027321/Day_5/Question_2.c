#include <stdio.h>
int main() 
{
    int n, i;
    printf("Enter the number of elements in each array: ");
    scanf("%d", &n);
    int a[n], b[n];
    int count[1001] = {0};
    printf("Enter the elements of the first array:\n");
    for (i = 0; i < n; i++) {
        scanf("%d", &a[i]);
        count[a[i]]++;
    }
    printf("Enter the elements of the second array:\n");
    for (i = 0; i < n; i++) {
        scanf("%d", &b[i]);
        count[b[i]]--;
    }
    for (i = 0; i < 1001; i++) {
        if (count[i] != 0) {
            printf("\nThe two arrays are not equal.\n");
            return 0;
        }
    }
    printf("\nBoth arrays contain the same elements.\n");
    return 0;
}