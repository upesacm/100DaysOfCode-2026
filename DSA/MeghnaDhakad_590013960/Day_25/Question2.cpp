#include <iostream>
#include <vector>
using namespace std;

bool hasPair(vector<int>& arr, int target) {
    int left = 0;
    int right = arr.size() - 1;

    while (left < right) {
        int sum = arr[left] + arr[right];

        if (sum == target)
            return true;

        if (sum < target)
            left++;
        else
            right--;
    }

    return false;
}

int main() {
    vector<int> arr = {1, 2, 4, 6, 10};
    int target = 8;

    cout << (hasPair(arr, target) ? "true" : "false");

    return 0;
}