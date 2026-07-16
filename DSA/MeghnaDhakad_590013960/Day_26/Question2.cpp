#include <iostream>
#include <algorithm>
using namespace std;

bool tripletSum(int arr[], int n) {
    sort(arr, arr + n);

    for (int k = n - 1; k >= 2; k--) {
        int left = 0;
        int right = k - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == arr[k])
                return true;

            if (sum < arr[k])
                left++;
            else
                right--;
        }
    }

    return false;
}

int main() {
    int arr[] = {4, 1, 3, 2, 5};
    int n = sizeof(arr) / sizeof(arr[0]);

    cout << (tripletSum(arr, n) ? "true" : "false");

    return 0;
}