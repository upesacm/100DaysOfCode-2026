#include <iostream>
#include <stack>
using namespace std;

void insertAtBottom(stack<int> &st, int x) {
    if(st.empty()) {
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
    int n;
    cout << "Enter the number of elements: ";
    cin >> n;
    cout << "Enter the stack elements: ";
    for(int i = 0; i < n; i++) {
        int value;
        cin >> value;
        st.push(value);
    }
    int x;
    cout << "Enter the element to insert at the bottom: ";
    cin >> x;
    insertAtBottom(st, x);
    stack<int> temp;
    while(!st.empty()) {
        temp.push(st.top());
        st.pop();
    }
    cout << "Updated stack: ";
    while(!temp.empty()) {
        cout << temp.top() << " ";
        temp.pop();
    }
    return 0;
}
