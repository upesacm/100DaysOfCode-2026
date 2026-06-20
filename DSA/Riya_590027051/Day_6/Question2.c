#include <stdio.h>

int main() {
    int n, m;

    // Input size of first array
    printf("Enter size of first array: ");
    scanf("%d", &n);

    int arr1[n];
    printf("Enter elements of first sorted array: ");
    for(int i = 0; i < n; i++) {
        scanf("%d", &arr1[i]);
    }

    // Input size of second array
    printf("Enter size of second array: ");
    scanf("%d", &m);

    int arr2[m];
    printf("Enter elements of second sorted array: ");
    for(int i = 0; i < m; i++) {
        scanf("%d", &arr2[i]);
    }

    int i = 0, j = 0;

    printf("Union: ");

    while(i < n && j < m) {
        if(arr1[i] < arr2[j]) {
            if(i == 0 || arr1[i] != arr1[i-1])
                printf("%d ", arr1[i]);
            i++;
        }
        else if(arr1[i] > arr2[j]) {
            if(j == 0 || arr2[j] != arr2[j-1])
                printf("%d ", arr2[j]);
            j++;
        }
        else {
            if(i == 0 || arr1[i] != arr1[i-1])
                printf("%d ", arr1[i]);
            i++;
            j++;
        }
    }

    // Remaining elements of arr1
    while(i < n) {
        if(i == 0 || arr1[i] != arr1[i-1])
            printf("%d ", arr1[i]);
        i++;
    }

    // Remaining elements of arr2
    while(j < m) {
        if(j == 0 || arr2[j] != arr2[j-1])
            printf("%d ", arr2[j]);
        j++;
    }

    return 0;
}