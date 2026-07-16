#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    long long countSubarrays(vector<int>& arr, int limit) {
        long long ans = 0;
        long long len = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr[i] <= limit) {
                len++;
            } else {
                len = 0;
            }
            ans += len;
        }

        return ans;
    }

    long long numSubarrayBoundedMax(vector<int>& arr, int l, int r) {
        return countSubarrays(arr, r) - countSubarrays(arr, l - 1);
    }
};

int main() {
    Solution obj;

    int n;
    cout << "Enter size of array: ";
    cin >> n;

    vector<int> arr(n);

    cout << "Enter array elements: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int l, r;
    cout << "Enter l and r: ";
    cin >> l >> r;

    long long ans = obj.numSubarrayBoundedMax(arr, l, r);

    cout << "Number of valid subarrays = " << ans << endl;

    return 0;
}
