// Problem 2
// Balance Spectrum

#include <stdio.h>

int countMinus = 0;
int countZero = 0;
int countPlus = 0;

int height(int left, int right) {
    if (left > right)
        return 0;
    int mid = (left + right) / 2;
    int leftHeight = height(left, mid - 1);
    int rightHeight = height(mid + 1, right);
    int balance = rightHeight - leftHeight;
    if (balance == -1)
        countMinus++;
    else if (balance == 0)
        countZero++;
    else if (balance == 1)
        countPlus++;
    return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
}

int main() {
    int n;
    printf("Enter number of elements: ");
    scanf("%d", &n);
    int arr[n];
    printf("Enter sorted array: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);
    height(0, n - 1);
    printf("Balance factor -1: %d\n", countMinus);
    printf("Balance factor 0: %d\n", countZero);
    printf("Balance factor +1: %d\n", countPlus);
    return 0;
}