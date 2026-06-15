#include <iostream>
#include <vector>
using namespace std;

int missingNumber(vector<int>& nums) {

    int n = nums.size();

    int expectedSum = n * (n + 1) / 2; // Sum from 0 to n

    int actualSum = 0;

    for (int num : nums) {
        actualSum += num;
    }

    return expectedSum - actualSum; // Missing number
}

int main() {

    vector<int> nums = {3, 0, 1};

    cout << missingNumber(nums);

    return 0;
}