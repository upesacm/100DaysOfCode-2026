#include <iostream>
#include <stack>
using namespace std;

class Solution {
public:
    void insertAtBottom(stack<int> &st, int x) {
        // Base case
        if (st.empty()) {
            st.push(x);
            return;
        }

        // Store the top element
        int temp = st.top();
        st.pop();

        // Recursive call
        insertAtBottom(st, x);

        // Push the stored element back
        st.push(temp);
    }
};

// Function to print stack from bottom to top
void printStack(stack<int> st) {
    stack<int> temp;

    // Reverse the stack
    while (!st.empty()) {
        temp.push(st.top());
        st.pop();
    }

    cout << "[";
    while (!temp.empty()) {
        cout << temp.top();
        temp.pop();
        if (!temp.empty())
            cout << ",";
    }
    cout << "]" << endl;
}

int main() {
    Solution obj;
    stack<int> st;

    int n;
    cout << "Enter number of elements: ";
    cin >> n;

    cout << "Enter stack elements (bottom to top): ";
    int arr[n];

    for (int i = 0; i < n; i++)
        cin >> arr[i];

    // Push elements into stack
    for (int i = 0; i < n; i++)
        st.push(arr[i]);

    int x;
    cout << "Enter element to insert at bottom: ";
    cin >> x;

    obj.insertAtBottom(st, x);

    cout << "Stack after insertion: ";
    printStack(st);

    return 0;
}
