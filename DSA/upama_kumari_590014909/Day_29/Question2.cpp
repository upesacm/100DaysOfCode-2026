#include <iostream>
#include <stack>
using namespace std;

string reverseString(string s) {
    stack<char> st;

    for (char ch : s) {
        st.push(ch);
    }

    string ans = "";

    while (!st.empty()) {
        ans += st.top();
        st.pop();
    }

    return ans;
}

int main() {
    string s;
    cin >> s;

    cout << reverseString(s);

    return 0;
}