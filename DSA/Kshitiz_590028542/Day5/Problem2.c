#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int compare(const void* a, const void* b) {
    return (*(int*)a - *(int*)b);
}

bool comparison(int arr1[], int arr2[], int size){

    qsort(arr1, size, sizeof(int), compare);
    qsort(arr2, size, sizeof(int), compare);

    for (int i = 0; i < size; i++) {
        if (arr1[i] != arr2[i]) return false;
    }
    return true;
}

int main(){
    int size;
    printf("Enter the size of the array: ");
    scanf("%d", &size);
    
    int arr1[size], arr2[size];
    printf("Enter %d numbers for first array: ", size);
    for (int j=0; j<size; j++){
        scanf("%d", &arr1[j]);
    }
    printf("Enter %d numbers for second array: ", size);
    for (int k=0; k<size; k++){
        scanf("%d", &arr2[k]);
    }
    
    if (comparison(arr1, arr2, size)) {
        printf("\nThe arrays are identical (contain the same elements).\n");
    } else {
        printf("\nThe arrays are different.\n");
    }
return 0;
}