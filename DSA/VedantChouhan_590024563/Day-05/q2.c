#include <stdio.h>
#include <stdbool.h>

void sort(int arr[], int n) {
    for(int i = 0; i < n - 1; i++) {
        for(int j = 0; j < n - i - 1; j++) {
            if(arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

int main() {
    int a[] = {3, 5, 2, 5, 2};
    int b[] = {2, 3, 5, 2, 5};

    int n = sizeof(a) / sizeof(a[0]);

    sort(a, n);
    sort(b, n);

    bool equal = true;

    for(int i = 0; i < n; i++) {
        if(a[i] != b[i]) {
            equal = false;
            break;
        }
    }

    if(equal)
        printf("true\n");
    else
        printf("false\n");

    return 0;
}