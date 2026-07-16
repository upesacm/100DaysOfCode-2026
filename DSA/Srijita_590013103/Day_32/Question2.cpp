#include <stack>
using namespace std;

stack<int> copyStack(stack<int> &st) {
    stack<int> temp;
    stack<int> copy;

    while (!st.empty()) {
        temp.push(st.top());
        st.pop();
    }

    while (!temp.empty()) {
        int x = temp.top();
        temp.pop();

        st.push(x);
        copy.push(x);
    }

    return copy;
}