#include <iostream>
#include <stack>
using namespace std;

class Solution {
public:
    void solve(stack<int> &st, int x) {
        // Base case
        if (st.empty()) {
            st.push(x);
            return;
        }

        int num = st.top();
        st.pop();

        // Recursive call
        solve(st, x);

        // Push the removed element back
        st.push(num);
    }

    stack<int> insertAtBottom(stack<int> st, int x) {
        solve(st, x);
        return st;
    }
};

int main() {
    stack<int> st;

    // Bottom -> Top : 1 2 3 4
    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);

    int x = 5;

    Solution obj;
    st = obj.insertAtBottom(st, x);

    // Store elements to print from bottom to top
    stack<int> temp;
    while (!st.empty()) {
        temp.push(st.top());
        st.pop();
    }

    cout << "Stack after inserting at bottom: ";
    while (!temp.empty()) {
        cout << temp.top() << " ";
        temp.pop();
    }

    return 0;
}