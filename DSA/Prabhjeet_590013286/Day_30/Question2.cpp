//Need to insert a new element at the bottom of the stack

#include <iostream>
#include <stack>
using namespace std;

void insertBottom(stack<int>& st, int x)
{
    // reached the bottom, place it here
    if (st.empty())
    {
        st.push(x);
        return;
    }

    int top = st.top();
    st.pop();

    insertBottom(st, x);

    // put everything back in the same order
    st.push(top);
}

int main()
{
    stack<int> st;

    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);

    int x = 5;

    insertBottom(st, x);

    stack<int> temp;

    while (!st.empty())
    {
        temp.push(st.top());
        st.pop();
    }

    while (!temp.empty())
    {
        cout << temp.top() << " ";
        temp.pop();
    }

    return 0;
}