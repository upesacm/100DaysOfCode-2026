#include <iostream>
#include <vector>
using namespace std;

long long countAtMost(vector<int>& arr, int limit) {
    long long count = 0;
    long long length = 0;

    for (int num : arr) {
        if (num <= limit) {
            length++;
        } else {
            length = 0;
        }

        count += length;
    }

    return count;
}

long long boundedMaximum(vector<int>& arr, int l, int r) {
    return countAtMost(arr, r) - countAtMost(arr, l - 1);
}

int main() {
    vector<int> arr = {1, 2, 3, 4, 5};

    int l = 2;
    int r = 5;

    cout << boundedMaximum(arr, l, r);

    return 0;
}