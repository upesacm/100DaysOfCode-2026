#include <iostream>
#include <vector>
using namespace std;
int findFirst(vector<int>& arr, int target) {
    int left = 0;
    int right = arr.size() - 1;
    int index = -1;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            index = mid;
            right = mid - 1;
        }
        else if (arr[mid] < target) {
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }
    return index;
}
int findLast(vector<int>& arr, int target) {
    int left = 0;
    int right = arr.size() - 1;
    int index = -1;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            index = mid;
            left = mid + 1;
        }
        else if (arr[mid] < target) {
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }
    return index;
}
int main() {
    vector<int> arr = {1, 1, 2, 2, 2, 2, 3};
    int target = 2;
    int first = findFirst(arr, target);
    int last = findLast(arr, target);
    if (first == -1) {
        cout << 0;
    }
    else {
        cout << last - first + 1;
    }
   return 0;
}
