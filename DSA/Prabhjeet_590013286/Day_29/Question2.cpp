//Need to reverse the string using a stack

#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main()
{
    string s;

    cin >> s;

    stack<char> st;

    // push every character into the stack
    for (char ch : s)
    {
        st.push(ch);
    }

    // popping gives the string in reverse
    while (!st.empty())
    {
        cout << st.top();
        st.pop();
    }

    return 0;
}