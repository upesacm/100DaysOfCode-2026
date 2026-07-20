#include <iostream>
#include <stack>
#include <string>
using namespace std;

string postfixToPrefix(string postfix) {
    stack<string> st;

    for (char c : postfix) {

        if (isalnum(c)) {
            st.push(string(1, c));
        }
        else {
            string op2 = st.top();
            st.pop();

            string op1 = st.top();
            st.pop();

            st.push(c + op1 + op2);
        }
    }

    return st.top();
}

int main() {
    string postfix = "ABC/-AK/L-*";

    cout << postfixToPrefix(postfix);

    return 0;
}