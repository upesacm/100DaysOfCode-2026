#include <iostream>
#include <stack>
#include <vector>
using namespace std;

void insertAtBottom(stack<int>& st, int x) {
    if (st.empty()) {
        st.push(x);
        return;
    }

    int topElement = st.top();
    st.pop();

    insertAtBottom(st, x);

    st.push(topElement);
}

int main() {
    stack<int> st;

    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);

    int x = 5;

    insertAtBottom(st, x);

    vector<int> result;

    while (!st.empty()) {
        result.push_back(st.top());
        st.pop();
    }

    cout << "[";

    for (int i = result.size() - 1; i >= 0; i--) {
        cout << result[i];
        if (i > 0) cout << ",";
    }

    cout << "]" << endl;

    return 0;
}