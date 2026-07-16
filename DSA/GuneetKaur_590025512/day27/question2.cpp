#include <iostream>
#include <vector>
using namespace std;

int countSubarrays(vector<int>& arr, int x) {
    int count = 0;
    int length = 0;

    for (int i = 0; i < arr.size(); i++) {
        if (arr[i] <= x) {
            length++;
            count += length;
        } else {
            length = 0;
        }
    }

    return count;
}

int boundedMaximum(vector<int>& arr, int l, int r) {
    return countSubarrays(arr, r) - countSubarrays(arr, l - 1);
}

int main() {
    int n;
    cin >> n;

    vector<int> arr(n);

    for (int i = 0; i < n; i++)
        cin >> arr[i];

    int l, r;
    cin >> l >> r;

    cout << boundedMaximum(arr, l, r);

    return 0;
}