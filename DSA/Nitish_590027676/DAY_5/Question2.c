#include <stdio.h>
#include <stdbool.h>

bool areEqual(int arr1[], int arr2[], int n) {
    for(int i = 0; i < n; i++) {
        if(arr1[i] != arr2[i]) {
            return false;
        }
    }
    return true;
}

int main() {
    int arr1[] = {1, 2, 3, 4};
    int arr2[] = {1, 2, 3, 4};

    int n = sizeof(arr1) / sizeof(arr1[0]);

    if(areEqual(arr1, arr2, n))
        printf("True");
    else
        printf("False");

    return 0;
}