#include <bits/stdc++.h>
using namespace std;

vector<int> sortedSquares(vector<int>& nums)
{
    int n = nums.size();

    vector<int> ans(n);

    int left = 0;
    int right = n - 1;
    int index = n - 1;

    while(left <= right)
    {
        if(abs(nums[left]) > abs(nums[right]))
        {
            ans[index] = nums[left] * nums[left];
            left++;
        }
        else
        {
            ans[index] = nums[right] * nums[right];
            right--;
        }

        index--;
    }

    return ans;
}

int main()
{
    cout << "Enter the number of elements: ";
    int n;
    cin >> n;

    vector<int> nums(n);

    cout << "Enter the elements in sorted order:" << endl;
    for(int i = 0; i < n; i++)
    {
        cin >> nums[i];
    }

    vector<int> result = sortedSquares(nums);

    cout << "Sorted squares are: [";
    for(int i = 0; i < result.size(); i++)
    {
        cout << result[i];
        if(i != result.size() - 1)
            cout << ", ";
    }
    cout << "]" << endl;

    return 0;
}