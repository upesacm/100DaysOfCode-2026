#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
    string s;
    cin >> s;

    stack<char> st;

    // Push all characters onto the stack
    for (char ch : s) {
        st.push(ch);
    }

    // Pop characters to form the reversed string
    string reversed = "";
    while (!st.empty()) {
        reversed += st.top();
        st.pop();
    }

    cout << reversed << endl;

    return 0;
}