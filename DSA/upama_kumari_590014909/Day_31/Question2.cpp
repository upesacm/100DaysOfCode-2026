#include <iostream>
#include <vector>
#include <stack>
using namespace std;

class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& arr) {
        int n = arr.size();
        vector<int> ans(n);
        stack<int> st;

        for (int i = n - 1; i >= 0; i--) {

            while (!st.empty() && st.top() <= arr[i]) {
                st.pop();
            }

            if (st.empty())
                ans[i] = -1;
            else
                ans[i] = st.top();

            st.push(arr[i]);
        }

        return ans;
    }
};

int main() {

    Solution obj;

    vector<int> arr = {1, 3, 2, 4};

    vector<int> ans = obj.nextGreaterElement(arr);

    cout << "Next Greater Elements: ";

    for (int x : ans)
        cout << x << " ";

    return 0;
}