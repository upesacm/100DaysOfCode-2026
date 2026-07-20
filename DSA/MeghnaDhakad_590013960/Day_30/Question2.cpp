#include <iostream>
#include <stack>
using namespace std;

void insertAtBottom(stack<int>& st, int x) {
    if (st.empty()) {
        st.push(x);
        return;
    }

    int top = st.top();
    st.pop();

    insertAtBottom(st, x);

    st.push(top);
}

void printStack(stack<int> st) {
    while (!st.empty()) {
        cout << st.top() << " ";
        st.pop();
    }
}

int main() {
    stack<int> st;

    // Stack shown as [1, 2, 3, 4]
    // Here, 1 is the current top and 4 is the bottom.
    st.push(4);
    st.push(3);
    st.push(2);
    st.push(1);

    int x = 5;

    insertAtBottom(st, x);

    printStack(st);

    return 0;
}