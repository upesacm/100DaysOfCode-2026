#include <stdio.h>

int countSubarrays(int arr[], int n, int bound) {

    int ans = 0;
    int len = 0;

    for (int i = 0; i < n; i++) {

        if (arr[i] <= bound)
            len++;
        else
            len = 0;

        ans += len;
    }

    return ans;
}

int boundedMaxSubarrays(int arr[], int n, int l, int r) {

    return countSubarrays(arr, n, r) - countSubarrays(arr, n, l - 1);
}

int main() {

    int arr[] = {1, 2, 3, 4, 5};
    int n = sizeof(arr) / sizeof(arr[0]);

    int l = 2;
    int r = 5;

    printf("Count = %d\n", boundedMaxSubarrays(arr, n, l, r));

    return 0;
}