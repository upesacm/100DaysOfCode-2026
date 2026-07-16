#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
    string s;
    stack<char> st;

    cout << "Enter a string: ";
    getline(cin, s);

    for (char ch : s) {
        st.push(ch);
    }
    cout << "Reversed string: ";
    while (!st.empty()) {
        cout << st.top();
        st.pop();
    }

    cout << endl;

    return 0;
}