#include <iostream>
#include <stack>
using namespace std;

void copyStack(stack<int> source, stack<int>& destination) {
    stack<int> temp;

    while (!source.empty()) {
        temp.push(source.top());
        source.pop();
    }

    while (!temp.empty()) {
        destination.push(temp.top());
        temp.pop();
    }
}

int main() {
    stack<int> st, copied;

    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);

    copyStack(st, copied);

    while (!copied.empty()) {
        cout << copied.top() << " ";
        copied.pop();
    }

    return 0;
}