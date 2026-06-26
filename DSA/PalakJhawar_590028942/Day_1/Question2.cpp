#include <stdio.h>

long long arraySum(int* arr, int size) {
    long long sum = 0;
    for (int i = 0; i < size; i++) {
        sum += arr[i];
    }
    return sum;
}

int main() {
    int arr[] = {3, 8, 2, 9, 1};
    int size = sizeof(arr) / sizeof(arr[0]);
    
    long long result = arraySum(arr, size);
    printf("Output: %lld\n", result);
    
    return 0;
}