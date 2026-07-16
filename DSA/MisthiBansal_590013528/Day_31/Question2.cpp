#include <bits/stdc++.h>
using namespace std;

vector<int> nextGreater(vector<int> &arr)
{
    int n = arr.size();

    vector<int> ans(n);
    stack<int> st;      // stores elements

    for(int i = n - 1; i >= 0; i--)
    {
        while(!st.empty() && st.top() <= arr[i])
        {
            st.pop();
        }

        if(st.empty())
            ans[i] = -1;
        else
            ans[i] = st.top();

        st.push(arr[i]);
    }

    return ans;
}

int main()
{
    int n;

    cout << "Enter number of elements: ";
    cin >> n;

    vector<int> arr(n);

    cout << "Enter elements:\n";

    for(int i = 0; i < n; i++)
        cin >> arr[i];

    vector<int> ans = nextGreater(arr);

    cout << "Next Greater Elements:\n";

    for(int x : ans)
        cout << x << " ";

    return 0;
}