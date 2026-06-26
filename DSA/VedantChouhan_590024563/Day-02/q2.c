#include <stdio.h>

int main() {
    int arr[] = {23, 42, 11, 3, 99, 54};
    int size = sizeof(arr) / sizeof(arr[0]);

    int largest = arr[0];

    for(int i = 1; i < size; i++) {
        if(arr[i] > largest) {
            largest = arr[i];
        }
    }

    printf("Largest element: %d\n", largest);

    return 0;
}