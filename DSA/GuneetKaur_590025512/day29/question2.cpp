#include <iostream>
#include <stack>
using namespace std;

void insertAtBottom(stack<int> &st, int x)
{
    stack<int> temp;

    while(!st.empty())
    {
        temp.push(st.top());
        st.pop();
    }

    st.push(x);

    while(!temp.empty())
    {
        st.push(temp.top());
        temp.pop();
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

    cout << "Updated Stack (Top to Bottom): ";

    while(!st.empty())
    {
        cout << st.top() << " ";
        st.pop();
    }

    return 0;
}