//Need to find the first greater element on the right

#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int main()
{
    vector<int> arr = {1, 3, 2, 4};

    vector<int> ans(arr.size());

    stack<int> st;

    // moving from right lets us find the next greater quickly
    for (int i = arr.size() - 1; i >= 0; i--)
    {
        // these can't be the answer anymore
        while (!st.empty() && st.top() <= arr[i])
        {
            st.pop();
        }

        if (st.empty())
        {
            ans[i] = -1;
        }
        else
        {
            ans[i] = st.top();
        }

        st.push(arr[i]);
    }

    for (int x : ans)
    {
        cout << x << " ";
    }

    return 0;
}