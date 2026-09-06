#include <iostream>
#include <vector>
using namespace std;

// Function to check if there exists a pair with the given target sum
bool hasPairWithSum(vector<int>& arr, int target) {
    int left = 0;
    int right = arr.size() - 1;

    while (left < right) {
        int sum = arr[left] + arr[right];

        if (sum == target) {
            return true;
        }
        else if (sum < target) {
            left++;
        }
        else {
            right--;
        }
    }

    return false;
}

int main() {
    int n;

    cout << "Enter the size of the array: ";
    cin >> n;

    vector<int> arr(n);

    cout << "Enter the sorted array elements: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int target;
    cout << "Enter the target sum: ";
    cin >> target;

    if (hasPairWithSum(arr, target))
        cout << "true";
    else
        cout << "false";

    return 0;
}