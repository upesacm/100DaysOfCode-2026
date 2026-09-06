#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;

int maxPeopleVisible(vector<int>& arr) {
    int n = arr.size();

    vector<int> left(n), right(n);
    stack<int> st;

    // Nearest greater or equal on the left
    for (int i = 0; i < n; i++) {
        while (!st.empty() && arr[st.top()] < arr[i])
            st.pop();

        if (st.empty())
            left[i] = -1;
        else
            left[i] = st.top();

        st.push(i);
    }

    while (!st.empty()) st.pop();

    // Nearest greater or equal on the right
    for (int i = n - 1; i >= 0; i--) {
        while (!st.empty() && arr[st.top()] < arr[i])
            st.pop();

        if (st.empty())
            right[i] = n;
        else
            right[i] = st.top();

        st.push(i);
    }

    int ans = 1;

    for (int i = 0; i < n; i++) {
        ans = max(ans, right[i] - left[i] - 1);
    }

    return ans;
}

int main() {
    vector<int> arr = {6, 2, 5, 4, 5, 1, 6};

    cout << maxPeopleVisible(arr) << endl;

    return 0;
}