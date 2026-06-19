#include <stdio.h>

void rev(int arr[], int f, int l) {
    while (f<l) {
        int t = arr[f];
        arr[f] = arr[l];
        arr[l]= t;
        f++;
        l--;
    }
}

void rotate(int arr[], int n, int k) {
    k%=n;
    rev(arr, 0, n-1);
    rev(arr, 0, k-1);
    rev(arr, k, n-1);
}

int main() {
    int n, k;
    printf("Enter size of array: ");
    scanf("%d", &n);
    int arr[n];

    printf("Enter %d elements of array: ", n);
    for (int i=0; i<n; i++) {
        scanf("%d", &arr[i]);
    }
    printf("Enter number of rotations: ");
    scanf("%d", &k);
    rotate(arr, n, k);
    
    printf("Array after rotation: ");
    for (int i=0; i<n; i++) {
        printf("%d ", arr[i]);
    }
    return 0;
}