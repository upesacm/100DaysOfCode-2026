#include <bits/stdc++.h>
using namespace std;

string reverseString(string s)
{
    stack<char> st;

    // Push all characters
    for(char ch : s)
    {
        st.push(ch);
    }

    string ans = "";

    // Pop all characters
    while(!st.empty())
    {
        ans += st.top();
        st.pop();
    }

    return ans;
}

int main()
{
    cout << "Enter a string: ";
    string s;

    getline(cin, s);

    string reversed = reverseString(s);

    cout << "Reversed string: " << reversed << endl;

    return 0;
}