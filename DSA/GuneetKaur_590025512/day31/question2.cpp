#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int main()
{
    vector<int> v = {1, 3, 2, 4};
    stack<int> st;
    vector<int> ans(v.size(), 0);

    for (int i = v.size() - 1; i >= 0; i--)
    {
        while (!st.empty() && st.top() <= v[i])
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

        st.push(v[i]);
    }

    for (int val : ans)
    {
        cout << val << " ";
    }

    cout << endl;
    return 0;
}