//Need to check if both strings become the same after applying backspaces

#include <iostream>
#include <stack>
#include <string>
using namespace std;

string process(string str)
{
    stack<char> st;

    for (char ch : str)
    {
        if (ch == '#')
        {
            // remove the last character if possible
            if (!st.empty())
            {
                st.pop();
            }
        }
        else
        {
            st.push(ch);
        }
    }

    string ans = "";

    while (!st.empty())
    {
        ans = st.top() + ans;
        st.pop();
    }

    return ans;
}

int main()
{
    string s = "ab#c";
    string t = "ad#c";

    if (process(s) == process(t))
    {
        cout << "true";
    }
    else
    {
        cout << "false";
    }

    return 0;
}