#include <iostream>
#include <vector>
using namespace std;

vector<int> sortedSquares(vector<int>& nums) {

    int n = nums.size();
    vector<int> ans(n);

    int left = 0;
    int right = n - 1;
    int pos = n - 1;

    while (left <= right) {

        if (abs(nums[left]) > abs(nums[right])) {
            ans[pos--] = nums[left] * nums[left];
            left++;
        } else {
            ans[pos--] = nums[right] * nums[right];
            right--;
        }
    }

    return ans;
}

int main() {

    vector<int> nums = {-4, -1, 0, 3, 10};

    vector<int> ans = sortedSquares(nums);

    for (int x : ans)
        cout << x << " ";

    return 0;
}