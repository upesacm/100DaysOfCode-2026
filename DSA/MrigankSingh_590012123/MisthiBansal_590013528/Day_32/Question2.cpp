/*Given a stack of integers, copy all of its elements into a second, empty 
stack such that the relative order of elements is preserved, meaning the element on top of the 
original stack must also end up on top of the new stack*/
#include <bits/stdc++.h>
using namespace std;

void copyStack(stack<int> &st, stack<int> &copy)
{
    if(st.empty())
        return;

    int x = st.top();
    st.pop();

    copyStack(st, copy);

    st.push(x);      // Restore original stack
    copy.push(x);    // Copy to new stack
}

int main()
{
    stack<int> st;

    int n;
    cout << "Enter number of elements: ";
    cin >> n;

    cout << "Enter elements:\n";

    for(int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        st.push(x);
    }

    stack<int> copy;

    copyStack(st, copy);

    cout << "\nOriginal Stack (Top -> Bottom): ";
    stack<int> temp1 = st;
    while(!temp1.empty())
    {
        cout << temp1.top() << " ";
        temp1.pop();
    }

    cout << "\nCopied Stack (Top -> Bottom): ";
    while(!copy.empty())
    {
        cout << copy.top() << " ";
        copy.pop();
    }

    return 0;
}