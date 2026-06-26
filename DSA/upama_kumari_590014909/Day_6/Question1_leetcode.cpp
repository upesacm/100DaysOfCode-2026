#include <iostream>
#include <vector>
using namespace std;

int robLine(vector<int>& nums, int start, int end)
{
    int prev1 = 0;
    int prev2 = 0;

    for(int i = start; i <= end; i++)
    {
        int take = nums[i] + prev2;
        int notTake = prev1;

        int curr = max(take, notTake);

        prev2 = prev1;
        prev1 = curr;
    }

    return prev1;
}

int rob(vector<int>& nums)
{
    int n = nums.size();

    if(n == 1)
        return nums[0];

    int case1 = robLine(nums, 0, n - 2);
    int case2 = robLine(nums, 1, n - 1);

    return max(case1, case2);
}

int main()
{
    vector<int> nums = {1, 2, 3, 1};

    cout << rob(nums);

    return 0;
}