#include <iostream>
#include <stack>
using namespace std;

void insertAtBottom(stack<int> &st, int x) {

    if (st.empty()) {
        st.push(x);
        return;
    }

    int topElement = st.top();
    st.pop();

    insertAtBottom(st, x);

    st.push(topElement);
}