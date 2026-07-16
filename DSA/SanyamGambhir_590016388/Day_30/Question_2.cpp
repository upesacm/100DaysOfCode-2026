#include <iostream>
#include <stack>

using namespace std;
// Function to insert an element at the bottom of the stack
void insertAtBottom(stack<int>& st, int x) {
    // Base case: If stack is empty, push x and return
    if (st.empty()) {
        st.push(x);
        return;
    }

    // Hold the top element in the call stack
    int topElement = st.top();
    st.pop();

    // Recursively call for the remaining stack
    insertAtBottom(st, x);

    // Push the held element back onto the stack
    st.push(topElement);
}

// Helper function to print the stack from bottom to top
void printStack(stack<int> st) {
    // We pass by value so the original stack isn't modified during printing
    stack<int> temp;
    while (!st.empty()) {
        temp.push(st.top());
        st.pop();
    }
    
    cout << "[";
    while (!temp.empty()) {
        cout << temp.top();
        temp.pop();
        if (!temp.empty()) cout << ",";
    }
    cout << "]" << endl;
}

int main() {
    stack<int> st;
    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);
    
    int x = 5;

    cout << "Original Stack view (bottom to top representation): [1,2,3,4]\n";
    
    insertAtBottom(st, x);
    
    cout << "Updated Stack: ";
    printStack(st); // Output: [5,1,2,3,4]

    return 0;
}