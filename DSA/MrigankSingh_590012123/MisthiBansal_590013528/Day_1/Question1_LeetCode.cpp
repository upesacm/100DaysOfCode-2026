#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int arraySum(vector<int>& arr)
    {
        int sum = 0;

        for(int num : arr)
        {
            sum += num;
        }

        return sum;
    }
};

int main()
{
    cout << "Enter the size of the array: ";

    int n;
    cin >> n;

    vector<int> arr(n);

    cout << "Enter " << n << " elements: ";

    for(int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    Solution obj;

    cout << "Sum of all array elements = "
         << obj.arraySum(arr) << endl;

    return 0;
}