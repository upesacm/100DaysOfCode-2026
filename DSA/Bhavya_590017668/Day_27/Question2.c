#include <stdio.h>

int countBounded(int* arr, int n, int bound) {
    int count = 0, ans = 0;

    for (int i = 0; i < n; i++) {
        if (arr[i] <= bound)
            count++;
        else
            count = 0;

        ans += count;
    }

    return ans;
}

int numSubarrayBoundedMax(int* arr, int n, int l, int r) {
    return countBounded(arr, n, r) - countBounded(arr, n, l - 1);
}