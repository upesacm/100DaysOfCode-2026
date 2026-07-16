#include <iostream>
#include <stack>
#include <string>
using namespace std;
string reverseString(string s) {
    stack<char> st;
    for(char ch : s)
        st.push(ch);
    string reversed = "";
    while(!st.empty()) {
        reversed += st.top();
        st.pop();
    }
    return reversed;
}

int main() {
    string s;
    cout << "Enter a string: ";
    cin >> s;
    cout << "Reversed string: " << reverseString(s);
    return 0;
}
