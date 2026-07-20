#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;

int maximumVisible(vector<int>& h) {
    int n = h.size();
    vector<int> left(n, 1), right(n, 1);
    stack<int> st;

    // Visible to the left
    for (int i = 0; i < n; i++) {
        while (!st.empty() && h[st.top()] < h[i]) {
            left[i]++;
            st.pop();
        }
        if (!st.empty())
            left[i]++;
        st.push(i);
    }

    while (!st.empty()) st.pop();

    // Visible to the right
    for (int i = n - 1; i >= 0; i--) {
        while (!st.empty() && h[st.top()] < h[i]) {
            right[i]++;
            st.pop();
        }
        if (!st.empty())
            right[i]++;
        st.push(i);
    }

    int ans = 1;

    for (int i = 0; i < n; i++)
        ans = max(ans, left[i] + right[i] - 1);

    return ans;
}

int main() {
    vector<int> arr = {6, 2, 5, 4, 5, 1, 6};

    cout << maximumVisible(arr);

    return 0;
}