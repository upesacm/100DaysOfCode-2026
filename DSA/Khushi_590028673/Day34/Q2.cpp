#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;

int maximumPeopleVisible(vector<int>& arr) {
    int n = arr.size();

    vector<int> left(n), right(n);
    stack<int> st;

    for (int i = 0; i < n; i++) {
        while (!st.empty() && arr[st.top()] < arr[i]) {
            st.pop();
        }

        if (st.empty())
            left[i] = -1;
        else
            left[i] = st.top();

        st.push(i);
    }

    while (!st.empty())
        st.pop();

    for (int i = n - 1; i >= 0; i--) {
        while (!st.empty() && arr[st.top()] < arr[i]) {
            st.pop();
        }

        if (st.empty())
            right[i] = n;
        else
            right[i] = st.top();

        st.push(i);
    }

    int ans = 0;

    for (int i = 0; i < n; i++) {
        int visible = right[i] - left[i] - 1;
        ans = max(ans, visible);
    }

    return ans;
}

int main() {
    vector<int> arr = {6, 2, 5, 4, 5, 1, 6};

    cout << "Maximum people visible = "
         << maximumPeopleVisible(arr) << endl;

    return 0;
}