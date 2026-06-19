#include <iostream>
#include <vector>
using namespace std;
int firstO(vector<int>& arr, int target)
 {
    int low = 0, high = arr.size() - 1;
    int first = -1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] == target) 
        {
            first = mid;
            high = mid - 1;
        }
        else if (arr[mid] < target)
        {
            low = mid + 1;
        }
        else 
        {
            high = mid - 1;
        }
    }
    return first;
}
int lastO(vector<int>& arr, int target)
 {
    int low = 0, high = arr.size() - 1;
    int last = -1;
    while (low <= high)
    {
        int mid = low + (high - low) / 2;
        if (arr[mid] == target)
        {
            last = mid;
            low = mid + 1;
        }
        else if (arr[mid] < target)
        {
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
    }
    return last;
}

int main()
{
    int n;
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    int target;
    cout<<"Enter Target value:";
    cin >> target;
    int first = firstO(arr, target);
    if (first == -1)
    {
        cout << 0;
    }
    else
    {
        int last = lastO(arr, target);
        cout << last - first + 1;
    }
    return 0;
}