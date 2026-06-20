#include <stdio.h>

void unionArrays(int a[], int n1, int b[], int n2) {
    int i = 0, j = 0;

    printf("Union: ");

    while (i < n1 && j < n2) {
        // skip duplicates in a
        if (i > 0 && a[i] == a[i - 1]) { i++; continue; }

        if (a[i] < b[j])
            printf("%d ", a[i++]);
        else if (a[i] > b[j])
            printf("%d ", b[j++]);
        else {
            printf("%d ", a[i++]);
            j++;
        }
    }

    while (i < n1) {
        if (i == 0 || a[i] != a[i - 1])
            printf("%d ", a[i]);
        i++;
    }

    while (j < n2) {
        if (j == 0 || b[j] != b[j - 1])
            printf("%d ", b[j]);
        j++;
    }

    printf("\n");
}

int main() {
    int n1, n2;

    printf("Enter size of array 1: ");
    scanf("%d", &n1);
    int a[n1];
    printf("Enter elements of array 1 (sorted): ");
    for (int i = 0; i < n1; i++)
        scanf("%d", &a[i]);

    printf("Enter size of array 2: ");
    scanf("%d", &n2);
    int b[n2];
    printf("Enter elements of array 2 (sorted): ");
    for (int i = 0; i < n2; i++)
        scanf("%d", &b[i]);

    unionArrays(a, n1, b, n2);

    return 0;
}
