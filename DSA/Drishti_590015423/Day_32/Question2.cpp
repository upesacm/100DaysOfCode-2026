#include <iostream>
#include <stack>
using namespace std;

void copyStack(stack<int> &st, stack<int> &copied)
{
    stack<int> temp;

    // Move elements from original to temp
    while (!st.empty())
    {
        temp.push(st.top());
        st.pop();
    }

    // Restore original and create copy
    while (!temp.empty())
    {
        st.push(temp.top());
        copied.push(temp.top());
        temp.pop();
    }
}

int main()
{
    stack<int> st, copied;

    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);

    copyStack(st, copied);

    cout << "Copied Stack (top to bottom): ";

    while (!copied.empty())
    {
        cout << copied.top() << " ";
        copied.pop();
    }

    return 0;
}
