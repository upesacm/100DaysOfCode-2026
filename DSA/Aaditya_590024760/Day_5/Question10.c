#include <stdio.h>

void sortArray(int arr[], int n) {
    for (int i = 0; i < n - 1; i++)
        for (int j = 0; j < n - i - 1; j++)
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
}

int main() {
    int n1, n2;

    printf("Enter size of array 1: ");
    scanf("%d", &n1);
    int a[n1];
    printf("Enter elements of array 1: ");
    for (int i = 0; i < n1; i++)
        scanf("%d", &a[i]);

    printf("Enter size of array 2: ");
    scanf("%d", &n2);
    int b[n2];
    printf("Enter elements of array 2: ");
    for (int i = 0; i < n2; i++)
        scanf("%d", &b[i]);

    if (n1 != n2) {
        printf("Arrays are not equal (different sizes)\n");
        return 0;
    }

    sortArray(a, n1);
    sortArray(b, n2);

    int equal = 1;
    for (int i = 0; i < n1; i++) {
        if (a[i] != b[i]) {
            equal = 0;
            break;
        }
    }

    if (equal)
        printf("Arrays are equal\n");
    else
        printf("Arrays are not equal\n");

    return 0;
}
