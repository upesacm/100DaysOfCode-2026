#include <stdio.h>
int main() {
    int n, val;
    printf("Enter size of array: ");
    scanf("%d", &n);

    int arr[n];

    printf("Enter array elements: ");
    for(int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    printf("Enter value to remove: ");
    scanf("%d", &val);

    int count = 0;

    for(int i = 0; i < n; i++) {
        if(arr[i] != val) {
            arr[count] = arr[i];
            count++;
        }
    }

    printf("Remaining elements count: %d\n", count);

    printf("Updated array: ");
    for(int i = 0; i < count; i++) {
        printf("%d ", arr[i]);
    }

    return 0;
}
