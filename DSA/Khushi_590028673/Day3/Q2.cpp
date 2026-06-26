// Q2 Number of Occurrences

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int firstOccurrence(vector<int>& arr, int target) {
        int l = 0, r = arr.size() - 1;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == target) {
                ans = mid;
                r = mid - 1; // move left
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    int lastOccurrence(vector<int>& arr, int target) {
        int l = 0, r = arr.size() - 1;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == target) {
                ans = mid;
                l = mid + 1; // move right
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    int countOccurrences(vector<int>& arr, int target) {
        int first = firstOccurrence(arr, target);
        if (first == -1) return 0;

        int last = lastOccurrence(arr, target);

        return (last - first + 1);
    }
};

int main() {
    int n;
    cout << "Enter size of array: ";
    cin >> n;

    vector<int> arr(n);

    cout << "Enter sorted array elements: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int target;
    cout << "Enter target: ";
    cin >> target;

    Solution sol;
    int result = sol.countOccurrences(arr, target);

    cout << "Number of occurrences: " << result << endl;

    return 0;
}

