//Need to count subarrays whose maximum lies between l and r

#include <iostream>
#include <vector>
using namespace std;

int countBounded(vector<int>& arr, int l, int r)
{
    int ans = 0;

    int lastGreater = -1;
    int lastValid = -1;

    for (int i = 0; i < arr.size(); i++)
    {
        // this breaks every valid subarray
        if (arr[i] > r)
        {
            lastGreater = i;
        }

        // latest position where max can be inside the range
        if (arr[i] >= l && arr[i] <= r)
        {
            lastValid = i;
        }

        // every valid starting point adds one more subarray
        ans += max(0, lastValid - lastGreater);
    }

    return ans;
}

int main()
{
    vector<int> arr = {1, 2, 3, 4, 5};

    int l = 2;
    int r = 5;

    cout << countBounded(arr, l, r);

    return 0;
}