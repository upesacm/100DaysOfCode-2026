#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// Function to check if there exists a triplet such that
// arr[i] + arr[j] = arr[k]
bool hasTriplet(vector<int>& arr) {
    sort(arr.begin(), arr.end());

    int n = arr.size();

    // Fix the largest element as arr[k]
    for (int k = n - 1; k >= 2; k--) {
        int left = 0;
        int right = k - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == arr[k]) {
                return true;
            }
            else if (sum < arr[k]) {
                left++;
            }
            else {
                right--;
            }
        }
    }

    return false;
}

int main() {
    int n;

    cout << "Enter the size of the array: ";
    cin >> n;

    vector<int> arr(n);

    cout << "Enter the array elements: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    if (hasTriplet(arr))
        cout << "true";
    else
        cout << "false";

    return 0;
}