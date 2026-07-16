#include <iostream>
#include <stack>
using namespace std;

void insertAtBottom(stack<int> &st, int x)
{
    // Base Case
    if (st.empty())
    {
        st.push(x);
        return;
    }

    // Save top element
    int num = st.top();
    st.pop();

    // Recursive call
    insertAtBottom(st, x);

    // Push saved element back
    st.push(num);
}

void printStack(stack<int> st)
{
    while (!st.empty())
    {
        cout << st.top() << " ";
        st.pop();
    }
}

int main()
{
    stack<int> st;

    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);

    int x = 5;

    insertAtBottom(st, x);

    printStack(st);

    return 0;
}
