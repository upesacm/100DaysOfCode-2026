#include <stdio.h>

void merge_arr(int arr1[], int arr2[], int s1, int s2) {
    int arr[s1+s2];
    arr[0] = (arr1[0] <= arr2[0]) ? arr1[0]: arr2[0];
    int i=0, j=0, k=0;

    while (i<s1 && j<s2) {
        if (arr1[i] == arr[k]) {i++; continue;}
        if (arr2[j] == arr[k]) {j++; continue;}
        arr[++k] = (arr1[i] < arr2[j]) ? arr1[i++]: arr2[j++];
    }

    while (i<s1) {
        if (arr1[i] == arr[k]) {i++; continue;}
        arr[++k] = arr1[i++];        
    }
    
    while (j<s2) {
        if (arr2[j] == arr[k]) {j++; continue;}
        arr[++k] = arr2[j++];
    }

    printf("Merged array:\n");
    for (int a = 0; a<=k; a++) {
        printf("%d ", arr[a]);
    }
}

void main() {
    int s1, s2;
    printf("Enter the size of array 1: ");
    scanf("%d", &s1);

    printf("Enter the size of array 2: ");
    scanf("%d", &s2);

    int a[s1], b[s2];

    printf("Enter %d elements for first array in sorted order: ", s1);
    for(int i=0; i<s1; i++) scanf("%d", &a[i]);

    printf("Enter %d elements for second array in sorted order: ", s2);
    for(int i=0; i<s2; i++) scanf("%d", &b[i]);

    merge_arr(a, b, s1, s2);
}