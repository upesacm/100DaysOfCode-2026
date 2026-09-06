#include <bits/stdc++.h>
using namespace std;

string postfixToPrefix(string s)
{
    stack<string> st;

    for(char ch : s)
    {
        // Operand
        if(isalpha(ch))
        {
            string temp = "";
            temp += ch;
            st.push(temp);
        }

        // Operator
        else
        {
            string op2 = st.top();
            st.pop();

            string op1 = st.top();
            st.pop();

            string ans = "";
            ans += ch;
            ans += op1;
            ans += op2;

            st.push(ans);
        }
    }

    return st.top();
}

int main()
{
    string s;

    cout << "Enter postfix expression: ";
    cin >> s;

    cout << "Prefix Expression: " << postfixToPrefix(s);

    return 0;
}