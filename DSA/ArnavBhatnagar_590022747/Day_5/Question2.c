#include <stdio.h>
#include <stdbool.h>

bool areArraysEqual(int arr1[], int arr2[], int n1, int n2) {
    if (n1 != n2) return false;  

    for (int i = 0; i < n1; i++) {
        if (arr1[i] != arr2[i]) {
            return false;        
        }
    }
    return true;                 
}

int main() {
    int arr1[] = {1, 2, 3, 4};
    int arr2[] = {1, 2, 3, 4};
    int n1 = sizeof(arr1) / sizeof(arr1[0]);
    int n2 = sizeof(arr2) / sizeof(arr2[0]);

    if (areArraysEqual(arr1, arr2, n1, n2)) {
        printf("Arrays are equal\n");
    } else {
        printf("Arrays are not equal\n");
    }

    return 0;
}
