#include <stdio.h>
int firstpos(int arr[], int n, int x) {
    int low = 0, high = n - 1, ans = -1;

    while (low <= high) {
        int mid = (low + high) / 2;

        if (arr[mid] == x) {
            ans = mid;
            high = mid - 1;
        } else if (arr[mid] < x) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return ans;
}

int lastpos(int arr[], int n, int x) {
    int low = 0, high = n - 1, ans = -1;

    while (low <= high) {
        int mid = (low + high) / 2;

        if (arr[mid] == x) {
            ans = mid;
            low = mid + 1;
        } else if (arr[mid] < x) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return ans;
}

int main() {
    int n, target;

    printf("Enter size: ");
    scanf("%d", &n);

    int arr[n];
    printf("Enter sorted array: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    printf("Enter target: ");
    scanf("%d", &target);

    int first = firstpos(arr, n, target);

    if (first == -1) {
        printf("Occurrences: 0");
        return 0;
    }

    int last = lastpos(arr, n, target);

    printf("Occurrences: %d", last - first + 1);

    return 0;
}