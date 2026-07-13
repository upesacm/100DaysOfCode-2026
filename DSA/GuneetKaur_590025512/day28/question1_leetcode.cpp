#include <iostream>
#include <stack>
#include <string>
using namespace std;

bool isValid(string s) {
    stack<char> st;

    for (char ch : s) {
        if (ch == '(' || ch == '{' || ch == '[') {
            st.push(ch);
        }
        else {
            if (st.empty()) {
                return false;
            }

            if ((ch == ')' && st.top() != '(') ||
                (ch == '}' && st.top() != '{') ||
                (ch == ']' && st.top() != '[')) {
                return false;
            }

            st.pop();
        }
    }

    return st.empty();
}

int main() {
    string s;

    cout << "Enter the parentheses string: ";
    cin >> s;

    if (isValid(s))
        cout << "Valid Parentheses" << endl;
    else
        cout << "Invalid Parentheses" << endl;

    return 0;
}