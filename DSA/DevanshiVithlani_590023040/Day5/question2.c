#include <stdbool.h>

bool areEqual(int arr1[], int arr2[], int n) {
    for (int i = 0; i < n; i++) {
        if (arr1[i] != arr2[i])
            return false;
    }
    return true;
}
